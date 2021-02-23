package com.lkb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.pojo.order.OrderDetail;
import com.lkb.service.order.OrderService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Reference
    private OrderService orderService;

    @GetMapping("findListOrderDetail")
    public List<OrderDetail> findListOrderDetail(){
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        Map map=new HashMap();
        map.put("username",username);
        return orderService.findListOrderDetail(map);
    }

    @GetMapping("findListOrderPay")
    public Map findListOrderPay(Integer pageNo,String orderStatus){

        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        Map map=new HashMap();
        map.put("username",username);
        map.put("orderStatus",orderStatus);
//        System.out.println(map);
        return orderService.findListOrderPage(map,pageNo);
    }
}
