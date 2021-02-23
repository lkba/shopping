package com.lkb.controller.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.pojo.order.CategoryReport;
import com.lkb.pojo.order.OrderReport;
import com.lkb.service.order.CategoryReportService;
import com.lkb.service.order.OrderReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orderReport")
public class OrderReportController {

    @Reference
    private OrderReportService orderReportService;

    /**
     * 昨天的数据统计（商品类目）
     * @return
     */
    @GetMapping("/yesterday")
    public OrderReport yesterday(){
        LocalDate localDate= LocalDate.now().minusDays(1);//得到昨天的日期
        return orderReportService.orderReport(localDate);
    }



    @GetMapping("/order1Count")
    public List<Map> order1Count(String date1,String date2){
        return orderReportService.order1Count(date1,date2);
    }


}
