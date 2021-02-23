package com.lkb.service.goods;
import com.lkb.entity.PageResult;
import com.lkb.pojo.goods.Goods;
import com.lkb.pojo.goods.Spu;

import java.io.IOException;
import java.util.*;

/**
 * spu业务逻辑层
 */
public interface SpuService {


    public List<Spu> findAll();


    public PageResult<Spu> findPage(int page, int size);


    public List<Spu> findList(Map<String, Object> searchMap);


    public PageResult<Spu> findPage(Map<String, Object> searchMap, int page, int size);


    public Spu findById(String id);

    public void add(Spu spu);


    public void update(Spu spu);


    public void delete(String id);

    /**
     * 保存商品
     * @param goods 商品组合实体类
     */
    public void saveGoods(Goods goods) throws Exception;

    /**
     * 根据ID查询商品
     * @param id
     * @return
     */
    public Goods findGoodsById(String id);

    public void audit(String id, String status, String message);

    /**
     * 下架商品
     * @param id
     */
    public void pull(String id);

    /**
     * 上架商品
     * @param id
     */
    public void put(String id);

    /**
     * 批量上架商品
     * @param ids
     */
    public int putMany(Long[] ids);

    /**
     * 批量上架商品
     * @param ids
     */
    public int pullMany(Long[] ids);

    /**
     * 逻辑删除商品
     * @param id
     */
    public void deleteGoods(String id);
    /**
     * 逻辑还原商品
     * @param id
     */
    public void reGoods(String id);


}
