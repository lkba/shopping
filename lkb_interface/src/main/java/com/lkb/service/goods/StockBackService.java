package com.lkb.service.goods;

import com.lkb.pojo.order.OrderItem;

import java.util.List;

public interface StockBackService {


    public void addList(List<OrderItem> orderItemList);


    /**
     * 执行库存回滚
     */
    public void doBack();
}
