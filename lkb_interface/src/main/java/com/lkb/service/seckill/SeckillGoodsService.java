package com.lkb.service.seckill;

import com.lkb.entity.PageResult;
import com.lkb.pojo.seckill.SeckillGoods;
//import com.lkb.pojo.seckill.SeckillGoods;

import java.util.List;
import java.util.Map;

/****
 * @Author:shenkunlin
 * @Date:2019/5/27 12:12
 * @Description:
 *****/
public interface SeckillGoodsService {


    /***
     * 根据商品ID查询商品详情
     * @param time:商品秒杀时区
     * @param id:商品ID
     */
    SeckillGoods one(String time, Long id);

    /***
     * 根据时间区间查询秒杀商品列表
     * @param time
     */
    List<SeckillGoods> list(String time);

    public List<SeckillGoods> findAll();


    public PageResult<SeckillGoods> findPage(int page, int size);


    public List<SeckillGoods> findList(Map<String, Object> searchMap);


    public PageResult<SeckillGoods> findPage(Map<String, Object> searchMap, int page, int size);


    public SeckillGoods findById(String id);

    public void add(SeckillGoods seckillGoods);


    public void update(SeckillGoods seckillGoods);


    public void delete(String id);


}
