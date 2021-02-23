package com.lkb.dao;

import com.lkb.pojo.order.CategoryReport;
import com.lkb.pojo.order.OrderReport;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface OrderReportMapper extends Mapper<OrderReport> {

    @Select("select count(o.`receiver_contact`) orderPeople,count(o.`id`) orderTotal ,count(oi.`id`) orderGoods ,sum(o.`total_money`) orderMoney,DATE_FORMAT(o.`create_time`,'%Y-%m-%d') countDate" +
            "FROM tb_order o,tb_order_item oi" +
            "WHERE o.`id`=oi.`order_id` and DATE_FORMAT(o.`create_time`,'%Y-%m-%d') =#{date}" +
            "GROUP BY DATE_FORMAT(o.`create_time`,'%Y-%m-%d')")
    public List<Map> orderReport(@Param("date") LocalDate date);

    @Select("select count(o.`receiver_contact`) payPeople,count(o.`id`) payOrder ,count(oi.`id`) payGoods ,sum(o.`pay_money`) payMoney" +
            "FROM tb_order o,tb_order_item oi" +
            "WHERE o.`id`=oi.`order_id` and DATE_FORMAT(o.`create_time`,'%Y-%m-%d') =#{date} and o.`pay_status`='1'" +
            "GROUP BY DATE_FORMAT(o.`create_time`,'%Y-%m-%d')")
    public List<Map> orderPayReport(@Param("date") LocalDate date);

    @Select("SELECT * " +
            " FROM tb_order_report " +
            " WHERE count_date>=#{date1} AND count_date<=#{date2} " +
            " GROUP BY count_date ")
    public List<Map>  order1Count(@Param("date1") String date1, @Param("date2") String date2);

}
