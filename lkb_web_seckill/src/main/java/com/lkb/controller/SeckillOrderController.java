package com.lkb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.Result;
import com.lkb.service.seckill.SeckillOrderService;
import com.lkb.util.SeckillStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import java.com.lkb.entity.Result;

@RestController
@RequestMapping(value = "/seckill/order")
public class SeckillOrderController {

    @Reference
    private SeckillOrderService seckillOrderService;

    /**
     * 查询抢单状态
     *
     * @return
     */
    @RequestMapping(value = "/query")
    public Result queryStatus() {
        //获取用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        //用户未登录
        //如果用户没登录，则提醒用户登录
        if (username.equals("anonymousUser")) {
            return new Result(403, "未登录，请先登录！");
        }

        try {
            //调用Service查询
            SeckillStatus seckillStatus = seckillOrderService.queryStatus(username);
            if (seckillStatus != null) {
                return new Result(seckillStatus.getStatus(), "抢单状态");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(2, e.getMessage());
        }
        return new Result(404, "无相关信息！");
    }


    /**
     * 用户下单操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/add")
    public Result add(Long id, String time) {

        //获取用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        //如果用户没登录，则提醒用户登录
        if (username.equals("anonymousUser")) {
            return new Result(403, "未登录，请先登录！");
        }

        try {
            Boolean bo = seckillOrderService.add(id, time, username);
            if (bo) {
                return new Result(0, "抢单成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //将错误信息返回
            return new Result(2,e.getMessage());
        }
        return new Result(1, "抢单失败！");
    }
}
