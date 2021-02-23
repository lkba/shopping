package com.lkb.service.order;

import com.lkb.entity.PageResult;
import com.lkb.pojo.order.Order;
import com.lkb.pojo.order.OrderDetail;

import java.util.*;

/**
 * order业务逻辑层
 */
public interface OrderService {

    /**
     * 批量发货
     * @param orders   
     */
//    public void batchSend(List<Order> orders);
// public  void batchSend(List<Order> orders);
    public List<Order> findAll();


    public PageResult<Order> findPage(int page, int size);


    public List<Order> findList(Map<String, Object> searchMap);


    public PageResult<Order> findPage(Map<String, Object> searchMap, int page, int size);


//    public Order findById(String id);

    public Map<String, Object> add(Order order,String isPass);


    public void update(Order order);


    public void delete(String id);

    public OrderDetail findById(String id);

    public List<Order> findByIds(Map<String, Object> searchMap);

    /**
     * 批量发货
     *
     * @param orders
     */
    public void batchSend(List<Order> orders);

    /**
     * 查询用户所有订单
     * @param searchMap
     * @return
     */
    public List<OrderDetail> findListOrderDetail(Map<String, Object> searchMap);

    /**
     * 查询用户订单
     * @param searchMap
     * @param pageNo
     * @return
     */
    public Map findListOrderPage(Map<String, Object> searchMap,Integer pageNo);
    /**
     * 订单超时处理逻辑
     */
    public void orderTimeOutLogic();

    public void merge(Long orderId1, Long orderId2);

    public Order split(List<Map<String, Object>> searchMap, Long orderId);

    /**
     * 修改订单状态
     *
     * @param orderId
     * @param transactionId
     */
    public void updatePayStatus(String orderId, String transactionId);


}
