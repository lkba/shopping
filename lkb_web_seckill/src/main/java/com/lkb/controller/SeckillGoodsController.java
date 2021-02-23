package com.lkb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.pojo.seckill.SeckillGoods;
import com.lkb.service.seckill.SeckillGoodsService;
import com.lkb.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/****
 * @Author:shenkunlin
 * @Date:2019/5/27 12:22
 * @Description:
 *****/
@RestController
@RequestMapping(value = "/seckill/goods")
public class SeckillGoodsController {

    @Reference
    private SeckillGoodsService seckillGoodsService;

    @GetMapping(value = "/one")
    public SeckillGoods one(String time,Long id){
        return seckillGoodsService.one(time,id);
    }

    /**
     * 加载对应时间去的秒杀商品
     * @param time：2019052815
     * @return
     */
    @GetMapping(value = "/list")
    public List<SeckillGoods> list(String time){
        return seckillGoodsService.list(time);
    }

    /**
     * 加载所有时间菜单
     * @return
     */
    @RequestMapping(value = "/menus")
    public List<Date> loadMenus(){
        String  username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username);
        return DateUtil.getDateMenus();
    }
}
