package com.lkb.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.service.goods.StockBackService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class SkuTask {
    @Reference
    private StockBackService stockBackService;
//    @Scheduled(cron = "0 * * * * ?")
//    @Scheduled(cron = "0 0 0/1 * * ?")
    @Scheduled(cron = "0 0 0/1 * * ?")
    public void orderTimeOutLogic(){
        System.out.println("执行库存回滚");
        stockBackService.doBack();
        System.out.println("执行库存回滚结束");
    }

}
