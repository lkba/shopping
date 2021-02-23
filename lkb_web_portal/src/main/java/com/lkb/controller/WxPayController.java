package com.lkb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.pojo.order.Order;
import com.lkb.pojo.order.OrderDetail;
import com.lkb.service.order.OrderService;
import com.lkb.service.order.WxPayService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@RestController
@RequestMapping("/wxpay")
public class WxPayController {

    @Reference
    private OrderService orderService;

    @Reference
    private WxPayService wxPayService;


    @GetMapping("createNative")
    public Map createNative(String orderId){
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        OrderDetail order=orderService.findById(orderId);
        System.out.println(order.getOrder().getPayStatus()+"  orderid:"+orderId);
        if(order!=null){
            System.out.println(order.getOrder().getPayStatus()+"  orderid:"+orderId);
            System.out.println(order.getOrder().getOrderStatus());
            System.out.println(order.getOrder().getUsername());
            if ("0".equals(order.getOrder().getPayStatus())&&"0".equals(order.getOrder().getOrderStatus())&&username.equals(order.getOrder().getUsername())){
                return wxPayService.createNative(orderId,order.getOrder().getPayMoney(),"http://lkb.easy.echosite.cn/wxpay/notify.do");
            }else {
                return null;
            }
        }else {
            return null;
        }

    }

    /**
     * 回调
     */
    @RequestMapping("/notify")
    public void notifyLogic(HttpServletRequest request){
        System.out.println("支付成功回调。。。。");
        try {
            InputStream inputStream = (InputStream)request.getInputStream();
            ByteArrayOutputStream outputStream=new ByteArrayOutputStream();

            byte[] buffer=new byte[1024];
            int len=0;
            while( ( len= inputStream.read(buffer) )!=-1   ){
                outputStream.write( buffer,0,len );
            }
            outputStream.close();
            inputStream.close();
            String result=new String( outputStream.toByteArray(),"utf-8" );
            System.out.println(result);
            wxPayService.notifyLogic(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
