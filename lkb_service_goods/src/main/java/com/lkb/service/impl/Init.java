package com.lkb.service.impl;

import com.lkb.service.goods.CategoryService;
import com.lkb.service.goods.SkuService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Init implements InitializingBean {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SkuService skuService;

    public void afterPropertiesSet() throws Exception {
        System.out.println("‐‐‐缓存预热‐‐‐");
        categoryService.saveCategoryTreeToRedis();//加载商品分类导航缓存
        skuService.saveAllPriceToRedis();//加载价格数据

    }
}
