package com.lkb.controller.seckill;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.pojo.seckill.SeckillOrder;
import com.lkb.service.seckill.SeckillOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seckill")
public class SeckillController {

    @Reference
    SeckillOrderService seckillOrderService;

    @GetMapping("seckillOrder")
    public RuntimeException seckillOrder(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        seckillOrderService.findSeckillPayOrder(username);
        return new RuntimeException();
    }

}
