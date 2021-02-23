package com.lkb.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.SeckillGoodsMapper;
import com.lkb.entity.PageResult;
//import com.lkb.pojo.order.SeckillGoods;
//import com.lkb.pojo.order.ReturnOrder;
import com.lkb.pojo.seckill.SeckillGoods;
import com.lkb.service.seckill.SeckillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class SeckillGoodsServcieImpl implements SeckillGoodsService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public SeckillGoods one(String time, Long id) {
        return (SeckillGoods) redisTemplate.boundHashOps("SeckillGoods_"+ time).get(id);
    }

    @Override
    public List<SeckillGoods> list(String time) {
        //组装kill
        String key="SeckillGoods_"+time;
        return redisTemplate.boundHashOps(key).values();
    }



    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<SeckillGoods> findAll() {
        return seckillGoodsMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<SeckillGoods> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<SeckillGoods> orderLogs = (Page<SeckillGoods>) seckillGoodsMapper.selectAll();
        return new PageResult<SeckillGoods>(orderLogs.getTotal(),orderLogs.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<SeckillGoods> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return seckillGoodsMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<SeckillGoods> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<SeckillGoods> orderLogs = (Page<SeckillGoods>) seckillGoodsMapper.selectByExample(example);
        return new PageResult<SeckillGoods>(orderLogs.getTotal(),orderLogs.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public SeckillGoods findById(String id) {
        return seckillGoodsMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param orderLog
     */
    public void add(SeckillGoods orderLog) {
        seckillGoodsMapper.insert(orderLog);
    }

    /**
     * 修改
     * @param orderLog
     */
    public void update(SeckillGoods orderLog) {
        seckillGoodsMapper.updateByPrimaryKeySelective(orderLog);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(String id) {
        seckillGoodsMapper.deleteByPrimaryKey(id);
    }

    private Example createExample(Map<String, Object> searchMap) {
        Example example = new Example(SeckillGoods.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null) {
            // 用户账号
            if (searchMap.get("title") != null && !"".equals(searchMap.get("title"))) {
                criteria.andLike("title", "%" + searchMap.get("title") + "%");
            }
        }
        return example;
    }

}
