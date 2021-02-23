package com.lkb.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lkb.dao.CategoryReportMapper;
import com.lkb.dao.OrderReportMapper;
import com.lkb.pojo.order.CategoryReport;
import com.lkb.pojo.order.OrderReport;
import com.lkb.service.order.CategoryReportService;
import com.lkb.service.order.OrderReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = OrderReportService.class)
public class OrderReportServiceImpl implements OrderReportService {

    @Autowired
    private OrderReportMapper orderReportMapper;

    @Override
    public OrderReport orderReport(LocalDate date) {
        List<Map> orderReports = orderReportMapper.orderReport(date);
        List<Map> orderPayReport = orderReportMapper.orderPayReport(date);

        Map<String,Integer> map=new HashMap<String,Integer>();
        map.putAll(orderPayReport.get(0));
        map.putAll(orderReports.get(0));
//        map.put("countDate",localDate);
        OrderReport orderReport=new OrderReport();
        orderReport=(OrderReport)map;
        orderReport.setReturnMoney(0);
        return orderReport;
    }

    @Override
    @Transactional
    public void createData() {

        //查询昨天的类目统计数据
        LocalDate localDate=LocalDate.now().minusDays(1);
        List<Map> orderReports = orderReportMapper.orderReport(localDate);
        List<Map> orderPayReport = orderReportMapper.orderPayReport(localDate);

        Map<String,Integer> map=new HashMap<String,Integer>();
        map.putAll(orderPayReport.get(0));
        map.putAll(orderReports.get(0));
//        map.put("countDate",localDate);
        OrderReport orderReport=new OrderReport();
        orderReport=(OrderReport)map;
        orderReport.setReturnMoney(0);
        //保存到tb_order_report
        orderReportMapper.insert(orderReport);
        //保存到tb_order_report
    }
//
    @Override
    public List<Map> order1Count(String date1, String date2) {
        return orderReportMapper.order1Count(date1,date2);
    }

}
