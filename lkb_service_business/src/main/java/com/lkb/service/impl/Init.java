package com.lkb.service.impl;

import com.lkb.service.business.AdService;
import com.lkb.service.goods.CategoryService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Init implements InitializingBean {

    @Autowired
    private AdService adService;

    public void afterPropertiesSet() throws Exception {
        System.out.println("‐‐‐广告缓存预热‐‐‐");
        adService.saveAllAdToRedis();//加载所有广告
    }
}
