package com.lkb.pojo.order;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name="tb_order_report")
public class OrderReport implements Serializable {
    @Id
    private Date countDate;//统计日期

    private Integer orderPeople;//下单人数
    private Integer orderTotal;//订单总数
    private Integer orderGoods;//下单件数
    private Integer orderEffective;//有效订单数
    private Integer orderMoney;//订单总金额
    private Integer returnMoney;//退款金额
    private Integer payPeople;//付款人数
    private Integer payOrder;//付款订单数
    private Integer payGoods;//付款商品数
    private Integer payMoney;//付款金额

    public Date getCountDate() {
        return countDate;
    }

    public void setCountDate(Date countDate) {
        this.countDate = countDate;
    }

    public Integer getOrderPeople() {
        return orderPeople;
    }

    public void setOrderPeople(Integer orderPeople) {
        this.orderPeople = orderPeople;
    }

    public Integer getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Integer orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(Integer orderGoods) {
        this.orderGoods = orderGoods;
    }

    public Integer getOrderEffective() {
        return orderEffective;
    }

    public void setOrderEffective(Integer orderEffective) {
        this.orderEffective = orderEffective;
    }

    public Integer getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Integer orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(Integer returnMoney) {
        this.returnMoney = returnMoney;
    }

    public Integer getPayPeople() {
        return payPeople;
    }

    public void setPayPeople(Integer payPeople) {
        this.payPeople = payPeople;
    }

    public Integer getPayOrder() {
        return payOrder;
    }

    public void setPayOrder(Integer payOrder) {
        this.payOrder = payOrder;
    }

    public Integer getPayGoods() {
        return payGoods;
    }

    public void setPayGoods(Integer payGoods) {
        this.payGoods = payGoods;
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }
}
