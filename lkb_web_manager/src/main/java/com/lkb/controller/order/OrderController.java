package com.lkb.controller.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.order.Order;
import com.lkb.pojo.order.OrderDetail;
import com.lkb.service.order.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Reference
    private OrderService orderService;

    @GetMapping("/findAll")
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Order> findPage(int page, int size) {
        return orderService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Order> findList(@RequestBody Map<String, Object> searchMap) {
        return orderService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Order> findPage(@RequestBody Map<String, Object> searchMap, int page, int size) {
        return orderService.findPage(searchMap, page, size);
    }

    @GetMapping("/findById")
    public OrderDetail findById(String id) {
        return orderService.findById(id);
    }

//    @GetMapping("/findByIds")
//    public List<Order> findByIds(String[] ids) {
//        System.out.println(ids);
//        return orderService.findByIds(ids);
//    }

    @PostMapping("/findByIds")
    public List<Order> findByIds(@RequestBody Map<String, Object> searchMap) {
        System.out.println(searchMap);
        return orderService.findByIds(searchMap);
    }

//    @PostMapping("/findByIds")
//    public void  findByIds(@RequestBody String ids) {
//        System.out.println(ids);
//
//    }


//    @PostMapping("/add")
//    public Result add(@RequestBody Order order) {
//        orderService.add(order);
//        return new Result();
//    }

    @PostMapping("/update")
    public Result update(@RequestBody Order order) {
        orderService.update(order);
        return new Result();
    }


    @GetMapping("/delete")
    public Result delete(String id) {
        orderService.delete(id);
        return new Result();
    }

    @PostMapping("/batchSend")
    public Result batchSend(@RequestBody List<Order> orders) {
        orderService.batchSend(orders);
        return new Result();
    }

    @GetMapping("/merge")
    public Result merge(Long orderId1, Long orderId2) {
        orderService.merge(orderId1, orderId2);
        return new Result();
    }

    @PostMapping("split")
    public List<Map<String, Object>> split(@RequestBody List<Map<String, Object>> searchMap,Long orderId){
        System.out.println(searchMap);
        System.out.println(orderId);
        System.out.println(searchMap.get(1));
        return searchMap;
    }


}
