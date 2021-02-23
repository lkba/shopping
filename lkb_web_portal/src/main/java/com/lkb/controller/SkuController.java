package com.lkb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.service.goods.SkuService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sku")
@CrossOrigin//解决跨域问题
public class SkuController {
    @Reference
    private SkuService skuService;

    @GetMapping("/price")
    public Integer price(String id){
        return skuService.findPrice(id);
    }
}
