package com.lkb.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.Result;
import com.lkb.pojo.order.Order;
import com.lkb.pojo.teammanager.User;
import com.lkb.pojo.user.Address;
import com.lkb.service.order.CartService;
import com.lkb.service.order.OrderService;
import com.lkb.service.teammanager.UserService;
import com.lkb.service.user.AddressService;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Reference
    private CartService cartService;

    @GetMapping("/findCartList")
    public List<Map<String,Object>> findCartList(){
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        List<Map<String, Object>> cartList = cartService.findCartList(username);
        return cartList;
    }

    @GetMapping("/addItem")
    public Result addItem(String skuId, Integer num){
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username+","+skuId+","+","+num);
        cartService.addItem(username,skuId,num);
        return  new Result();
    }


    @GetMapping("/buy")
    public void buy(HttpServletResponse response, String skuId, Integer num) throws IOException {
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username);
        System.out.println(skuId);
        System.out.println(num);
        cartService.addItem(username,skuId,num);
        response.sendRedirect("/cart.html");
    }


    @GetMapping("/updateChecked")
    public Result updateChecked(String skuId,boolean checked){
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        cartService.updateChecked(username,skuId,checked);
        return new Result();
    }


    /**
     * 删除选中的购物车
     * @return
     */
    @GetMapping("/deleteCheckedCart")
    public Result deleteCheckedCart(){
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        cartService.deleteCheckedCart(username);
        return new Result();
    }

    @Reference
    private UserService userService;

    /**
     * 计算当前购物车优惠金额
     * @return
     */
    @GetMapping("/preferential")
    public Map preferential(){
        String username=SecurityContextHolder.getContext().getAuthentication().getName();


        Map mapUser=new HashMap();
        mapUser.put("username",username);
        User user=userService.findOneUser(mapUser);

        int preferential = cartService.preferential(username,user.getIsPass().toString());
        Map map=new HashMap();
        map.put("preferential",preferential);
        return map;
    }

    /**
     * 获取刷新单价后的购物车列表
     * @return
     */
    @GetMapping("/findNewOrderItemList")
    public List<Map<String,Object>> findNewOrderItemList(){
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        return cartService.findNewOrderItemList(username);
    }

    @Reference
    private AddressService addressService;

    /**
     * 根据登录用户查询地址列表
     * @return
     */
    @GetMapping("/findAddressList")
    public List<Address> findAddressList(){
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        return addressService.findByUsername(username);
    }

    @Reference
    private OrderService orderService;

    /**
     * 保存订单
     * @param order
     * @return
     */
    @PostMapping("/saveOrder")
    public Map<String,Object> saveOrder(@RequestBody Order order ){
        String username=SecurityContextHolder.getContext().getAuthentication().getName();

        Map mapUser=new HashMap();
        mapUser.put("username",username);
        User user=userService.findOneUser(mapUser);


        order.setUsername(username);
        return  orderService.add(order,user.getIsPass().toString());
    }


}
