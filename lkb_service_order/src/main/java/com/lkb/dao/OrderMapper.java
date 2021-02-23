package com.lkb.dao;

import com.lkb.pojo.order.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface OrderMapper extends Mapper<Order> {
    @Select("SELECT * FROM tb_order WHERE username=#{username} and order_status=#{orderStatus} ORDER BY create_time desc  LIMIT #{pageStat},#{pageEnd} ")
    public List<Map> findListOrderPay(@Param("username")  String username, @Param("orderStatus") Integer orderStatus, @Param("pageStat") Integer pageStat, @Param("pageEnd") Integer pageEnd);

    @Select("SELECT * from tb_order where username =#{username} ORDER BY create_time DESC")
    public List<Order> findListOrderDetail(@Param("username") String username );

}
