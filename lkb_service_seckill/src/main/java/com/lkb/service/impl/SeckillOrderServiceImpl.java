package com.lkb.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.SeckillGoodsMapper;
import com.lkb.dao.SeckillOrderMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.order.ReturnOrder;
import com.lkb.pojo.seckill.SeckillOrder;
import com.lkb.service.seckill.SeckillGoodsService;
import com.lkb.service.seckill.SeckillOrderService;
import com.lkb.task.MultiThreadingCreateOrder;
import com.lkb.util.IdWorker;
import com.lkb.util.SeckillStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SeckillOrderServiceImpl implements SeckillOrderService {

    @Autowired
    private MultiThreadingCreateOrder multiThreadingCreateOrder;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SeckillOrderMapper seckillOrderMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private SeckillGoodsService seckillGoodsService;

    public void findSeckillPayOrder(String username){
//        System.out.println();
        System.out.println(username);
//        SeckillStatus seckillStatus= (SeckillStatus) redisTemplate.boundHashOps("UserQueueStatus").get(username);
        System.out.println(redisTemplate.boundHashOps("UserQueueStatus").get(username));
//        if ("2".equals(seckillStatus.getStatus())){
////            seckillGoodsService.findById(seckillStatus.getGoodsId().toString())
//        }
//        seckillStatus=
//        return redisTemplate.boundHashOps("UserQueueStatus").get("username");
    }

    /**
     * 查询抢单状态
     * @param username
     * @return
     */
    @Override
    public SeckillStatus queryStatus(String username) {
        return (SeckillStatus) redisTemplate.boundHashOps("UserQueueStatus").get(username);
    }

    /**
     * 下单实现
     * @param id:商品ID
     * @param time:商品时区
     * @param username:用户名
     * @return
     */
    @Override
    public Boolean add(Long id, String time, String username) {
        //自增特性
        //  incr(key,value):让指定key的值自增value->返回自增的值->单线程操作
        //  A   第1次:  incr(username,1)->1
        //      第2次:  incr(username,1)->2
        //      利用自增，如果用户多次提交或者多次排队，则递增值>1
        Long userQueueCount = redisTemplate.boundHashOps("UserQueueCount").increment(username, 1);
        if(userQueueCount>1){
            System.out.println("重复抢单.....");
            //100:错误状态码  重复排队
            throw new RuntimeException("100");
        }

        //创建队列所需的排队信息
        SeckillStatus seckillStatus=new SeckillStatus( username,new Date(), 1, id, time);

        //将排队信息存入到List中
        redisTemplate.boundListOps("SeckillOrderQueue").leftPush(seckillStatus);

        //将抢单状态存入到Redis中
        redisTemplate.boundHashOps("UserQueueStatus").put(username,seckillStatus);
        //异步操作调用
        multiThreadingCreateOrder.createOrder();
        System.out.println("---其他程序正在执行---");
        return true;
    }


//    @Autowired
//    private SeckillOrderMapper seckillOrderMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<SeckillOrder> findAll() {
        return seckillOrderMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<SeckillOrder> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<SeckillOrder> orderLogs = (Page<SeckillOrder>) seckillOrderMapper.selectAll();
        return new PageResult<SeckillOrder>(orderLogs.getTotal(),orderLogs.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<SeckillOrder> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return seckillOrderMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<SeckillOrder> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<SeckillOrder> orderLogs = (Page<SeckillOrder>) seckillOrderMapper.selectByExample(example);
        return new PageResult<SeckillOrder>(orderLogs.getTotal(),orderLogs.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public SeckillOrder findById(String id) {
        return seckillOrderMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param orderLog
     */
    public void add(SeckillOrder orderLog) {
        seckillOrderMapper.insert(orderLog);
    }

    /**
     * 修改
     * @param orderLog
     */
    public void update(SeckillOrder orderLog) {
        seckillOrderMapper.updateByPrimaryKeySelective(orderLog);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(String id) {
        seckillOrderMapper.deleteByPrimaryKey(id);
    }


    private Example createExample(Map<String, Object> searchMap) {
        Example example = new Example(SeckillOrder.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null) {
            // 用户账号
            if (searchMap.get("userId") != null && !"".equals(searchMap.get("userId"))) {
                criteria.andLike("userId", "%" + searchMap.get("userId") + "%");
            }
        }
        return example;
    }
}
