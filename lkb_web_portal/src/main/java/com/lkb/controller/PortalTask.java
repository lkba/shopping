package com.lkb.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PortalTask {

    @Scheduled(cron = "10,12,16-20 * * * * ?")
    public void orderTimeOutLogic(){
//        System.out.println(new Date());
    }
//
//
//    @Reference
//    private CategoryReportService categoryReportService;
//
//
//    @Scheduled(cron = "0 0 1 * * ?")
//    public void createCategoryReportDate(){
//        System.out.println("生成类目统计数据");
//        categoryReportService.createData();
//    }


}
