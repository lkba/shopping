package com.lkb.service.seckill;

import com.lkb.entity.PageResult;
import com.lkb.pojo.seckill.SeckillOrder;
import com.lkb.util.SeckillStatus;

import java.util.List;
import java.util.Map;

/****
 * @Author:itheima
 * @Date:2019/5/27 18:06
 * @Description:
 *****/
public interface SeckillOrderService {

    //返回抢单情况
    public void findSeckillPayOrder(String username);
    /***
     * 抢单状态查询
     * @param username
     */
    SeckillStatus queryStatus(String username);

    /****
     * 下单实现
     * @param id:商品ID
     * @param time:商品时区
     * @param username:用户名
     * @return
     */
    Boolean add(Long id, String time, String username);

    public List<SeckillOrder> findAll();


    public PageResult<SeckillOrder> findPage(int page, int size);


    public List<SeckillOrder> findList(Map<String, Object> searchMap);


    public PageResult<SeckillOrder> findPage(Map<String, Object> searchMap, int page, int size);


    public SeckillOrder findById(String id);

    public void add(SeckillOrder seckillOrder);


    public void update(SeckillOrder seckillOrder);


    public void delete(String id);


}
