package com.lkb.controller.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.service.order.CategoryReportService;
import com.lkb.service.order.OrderReportService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OrderTask {

    @Scheduled(cron = "* 1 * * * ?")
    public void orderTimeOutLogic(){
//        System.out.println(new Date());
    }


    @Reference
    private CategoryReportService categoryReportService;

    @Reference
    private OrderReportService orderReportService;

//商品类目
    @Scheduled(cron = "0 0 1 * * ?")
    public void createCategoryReportDate(){
        System.out.println("生成类目统计数据");
        categoryReportService.createData();
    }

//    订单类目
    @Scheduled(cron = "0 0 1 * * ?")
    public void createOrderReportDate(){
        System.out.println("生成类目统计数据");
        orderReportService.createData();
    }


}
