package com.lkb.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.OrderConfigMapper;
import com.lkb.dao.OrderItemMapper;
import com.lkb.dao.OrderLogMapper;
import com.lkb.dao.OrderMapper;
import com.lkb.entity.PageResult;

import com.lkb.pojo.order.*;
import com.lkb.service.goods.SkuService;
import com.lkb.service.order.CartService;
import com.lkb.service.order.OrderService;
import com.lkb.util.IdWorker;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import tk.mybatis.mapper.entity.Example;


import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service(interfaceClass = OrderService.class)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private OrderLogMapper orderLogMapper;

    @Autowired
    private OrderConfigMapper orderConfigMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CartService cartService;

    /**
     * 返回全部记录
     *
     * @return
     */
    public List<Order> findAll() {
        return orderMapper.selectAll();
    }

    /**
     * 分页查询
     *
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Order> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<Order> orders = (Page<Order>) orderMapper.selectAll();
        return new PageResult<Order>(orders.getTotal(), orders.getResult());
    }

    /**
     * 条件查询
     *
     * @param searchMap 查询条件
     * @return
     */
    public List<Order> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return orderMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     *
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Order> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page, size);
        Example example = createExample(searchMap);
        Page<Order> orders = (Page<Order>) orderMapper.selectByExample(example);
        return new PageResult<Order>(orders.getTotal(), orders.getResult());
    }


//    /**
//     * 根据Id查询
//     * @param id
//     * @return
//     */
//    public Order findById(String id) {
//        return orderMapper.selectByPrimaryKey(id);
//    }

    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    public OrderDetail findById(String id) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder(orderMapper.selectByPrimaryKey(id));
        Example example = new Example(OrderItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderId", id);
        List<OrderItem> orderItemList = orderItemMapper.selectByExample(example);
        orderDetail.setOrderItemList(orderItemList);
        return orderDetail;
    }

    /**
     * 查用户所有订单
     *
     * @param searchMap
     * @return
     */
    public List<OrderDetail> findListOrderDetail(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);

//        List<Order> orderList = orderMapper.findListOrderDetail((String)searchMap.get("username"));
        List<Order> orderList = orderMapper.selectByExample(example);
        List<OrderDetail> orderDetailList = new LinkedList<>();
        for (Order order : orderList) {
            Example example1 = new Example(OrderItem.class);
            Example.Criteria criteria = example1.createCriteria();
            criteria.andEqualTo("orderId", order.getId());

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setOrderItemList(orderItemMapper.selectByExample(example1));
            orderDetailList.add(orderDetail);
        }
//        List<>
        return orderDetailList;
    }

    public Map findListOrderPage(Map<String, Object> searchMap, Integer pageNo) {
        Map map = new HashMap();
        //获取总数
        List<OrderDetail> orderPayList = findListOrderDetail(searchMap);
        map.put("pageTotal", orderPayList.size());
        //分页
        Integer pageStat;
        Integer pageEnd;
        if (pageNo == 0 || pageNo == null) {
            pageNo = 1;
            pageStat = pageNo;
            pageEnd = 10;
        } else {
            pageStat = (pageNo - 1) * 10;
            pageEnd = pageStat + 10;
        }
//        Integer pageEnd=pageStat +10;
        System.out.println(searchMap.toString());
        System.out.println(pageNo);
//        System.out.println((Integer) searchMap.get("orderStatus"));
        List<Map> list = orderMapper.findListOrderPay((String) searchMap.get("username"),Integer.parseInt(searchMap.get("orderStatus").toString()), pageStat, pageEnd);
//        System.out.println((Integer) searchMap.get("orderStatus"));
        //获取订单详情
        List<OrderDetail> orderDetailList = new LinkedList<>();

        for (Map order : list) {
            Example example1 = new Example(OrderItem.class);
            Example.Criteria criteria = example1.createCriteria();
            criteria.andEqualTo("orderId", order.get("id"));
//            转换
            Order orderT = new Order();
            orderT.setCreateTime((Date) order.get("create_time"));
            orderT.setPayMoney((Integer) order.get("pay_money"));
            orderT.setReceiverContact((String) order.get("receiver_contact"));
            orderT.setOrderStatus((String) order.get("order_status"));
            orderT.setReceiverMobile((String) order.get("receiver_mobile"));
            orderT.setReceiverAddress((String) order.get("receiver_address"));
            orderT.setId((String) order.get("id"));
//            orderT.setPayMoney((Integer) order.get("pay_money"));
            orderT.setPreMoney((Integer) order.get("pre_money"));
            orderT.setPayStatus((String) order.get("pay_status"));
            orderT.setTotalMoney((Integer) order.get("total_money"));
            orderT.setUsername((String) order.get("username"));

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(orderT);
            orderDetail.setOrderItemList(orderItemMapper.selectByExample(example1));
            orderDetailList.add(orderDetail);
        }
        map.put("Order", orderDetailList);
        map.put("pageNo", pageNo);

        return map;
    }

    public List<Order> findByIds(Map<String, Object> searchMap) {
        //批量修改
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        System.out.println(searchMap.get("ids"));
        if (searchMap.get("ids") != null) {
            criteria.andIn("id", (Iterable) searchMap.get("ids"));
            criteria.andIn("id", Arrays.asList((String[]) searchMap.get("ids")));
        }
//        Example example = createExample(searchMap);
//        criteria.andIn("id", Arrays.asList(ids));//id
//        criteria.andEqualTo("id","1");
        List<Order> order = orderMapper.selectByExample(example);
        return order;
    }

    @Reference
    private SkuService skuService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 新增
     *
     * @param order
     */
    public Map<String, Object> add(Order order ,String isPass) {
        //获取购物车(刷新单价)
        List<Map<String, Object>> cartList = cartService.findNewOrderItemList(order.getUsername());
        //获取选中的购物车
        List<OrderItem> orderItemList = cartList.stream()
                .filter(cart -> (boolean) cart.get("checked"))
                .map(cart -> (OrderItem) cart.get("item"))
                .collect(Collectors.toList());
        //扣减库存
        if (!skuService.deductionStock(orderItemList)) {
            throw new RuntimeException("库存扣减失败");
        }
        try {
            //保存订单主表
            order.setId(idWorker.nextId() + "");
            //合计数计算
            IntStream numStream = orderItemList.stream().mapToInt(OrderItem::getNum);
            IntStream moneyStream = orderItemList.stream().mapToInt(OrderItem::getMoney);
            int totalNum = numStream.sum();//总数量
            int totalMoney = moneyStream.sum();//订单总金额
            int preMoney = cartService.preferential(order.getUsername(),isPass);//计算优惠金额
            order.setTotalNum(totalNum);//总数量
            order.setTotalMoney(totalMoney);//总金额
            order.setPreMoney(preMoney);//优惠金额
            order.setPayMoney(totalMoney - preMoney);//支付金额=总金额+优惠金额
            order.setCreateTime(new Date());//订单创建日期
            order.setOrderStatus("0"); // 订单状态
            order.setPayStatus("0"); // 支付状态：未支付
            order.setConsignStatus("0"); //发货状态：未发货
            orderMapper.insert(order);

            double proportion = (double) order.getPayMoney() / totalMoney;//计算每个商品支付金额
            //保存订单明细
            for (OrderItem orderItem : orderItemList) {
                orderItem.setOrderId(order.getId());//订单主表ID
                orderItem.setId(idWorker.nextId() + "");
                orderItem.setPayMoney((int) (orderItem.getMoney() * proportion));//支付金额
                orderItemMapper.insert(orderItem);
            }


        } catch (Exception ex) {
            rabbitTemplate.convertAndSend("", "queue.skuback", JSON.toJSONString(orderItemList));
            throw new RuntimeException("订单生成失败");//抛出异常，让其回滚！
        }
        //清除选中的购物车
        cartService.deleteCheckedCart(order.getUsername());
        //返回订单号和支付的金额
        Map<String, Object> map = new HashMap<>();
        map.put("ordersn", order.getId());
        map.put("money", order.getPayMoney());
        return map;
    }

    /**
     * 修改
     *
     * @param order
     */
    public void update(Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void delete(String id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量发货
     *
     * @param orders
     */
    public void batchSend(List<Order> orders) {
//判断运单号和物流公司是否为空
        for (Order order : orders) {
            if (order.getShippingCode() == null ||
                    order.getShippingName() == null) {
                throw new RuntimeException("请选择快递公司和填写快递单号");
            }
        }
//循环订单
        for (Order order : orders) {
            order.setOrderStatus("2");//订单状态 已发货
            order.setConsignStatus("1"); //发货状态 已发货
            order.setConsignTime(new Date());//发货时间
            orderMapper.updateByPrimaryKeySelective(order);
//记录订单日志 。。。（代码略）
        }
    }


    /**
     * 订单超时处理
     */
    public void orderTimeOutLogic() {
//订单超时未付款 自动关闭
//查询超时时间
        OrderConfig orderConfig = orderConfigMapper.selectByPrimaryKey(1);
        Integer orderTimeout = orderConfig.getOrderTimeout(); //超时时间（分）60
        LocalDateTime localDateTime =
                LocalDateTime.now().minusMinutes(orderTimeout); //得到超时的时间点
//设置查询条件
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLessThan("createTime", localDateTime);//创建时间小于超时时间
        criteria.andEqualTo("orderStatus", "0");//未付款的
        criteria.andEqualTo("isDelete", "0");//未删除的
//查询超时订单
        List<Order> orders = orderMapper.selectByExample(example);
        for (Order order : orders) {
            //记录订单变动日志
            OrderLog orderLog = new OrderLog();
            orderLog.setOperater("system");// 系统
            orderLog.setOperateTime(new Date());//当前日期
            orderLog.setOrderStatus("4");
            orderLog.setPayStatus(order.getPayStatus());
            orderLog.setConsignStatus(order.getConsignStatus());
            orderLog.setRemarks("超时订单，系统自动关闭");
            orderLog.setOrderId(order.getId());
            orderLogMapper.insert(orderLog);//更改订单状态
            order.setOrderStatus("4");
            order.setCloseTime(new Date());//关闭日期
            orderMapper.updateByPrimaryKeySelective(order);
        }
    }


    //订单合并
    public void merge(Long orderId1, Long orderId2) {
        Order order1 = orderMapper.selectByPrimaryKey(orderId1);
        Order order2 = orderMapper.selectByPrimaryKey(orderId2);

        if ("0".equals(order1.getPayStatus()) && "0".equals(order2.getPayStatus())) {
            order1.setPayMoney(order1.getPreMoney() + order2.getPayMoney());

        } else {
            throw new RuntimeException("部分订单已支付");
        }

        //        查询子订单信息
        Example example = new Example(OrderItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", order2.getId());
        List<OrderItem> orderItemList = orderItemMapper.selectByExample(example);
        for (OrderItem orderItem2 : orderItemList) {
            orderItem2.setOrderId(order1.getId());
            orderItemMapper.updateByPrimaryKeySelective(orderItem2);
        }

        orderMapper.updateByPrimaryKeySelective(order1);
        orderMapper.deleteByPrimaryKey(order2);
    }


    public Order split(List<Map<String, Object>> searchMap, Long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        Integer totalNum = 0;
        Order newOrder = new Order();
        BeanUtils.copyProperties(order, newOrder);
        Long newOrderId = idWorker.nextId();
//        查询拆分商品数量，并为每个商品关联主订单
        for (Map map : searchMap) {
            totalNum = totalNum + (Integer) map.get("num");
        }

        //拆分后主订单商品数量
        if (order.getTotalNum() < totalNum) {
            throw new RuntimeException("拆分数量大于总额");
        } else {
            order.setTotalNum(order.getTotalNum() - totalNum);
        }

        for (Map map : searchMap) {
            totalNum = totalNum + (Integer) map.get("num");
//            旧订单减数量和金额
            OrderItem orderItem = orderItemMapper.selectByPrimaryKey(map.get("id"));
            orderItem.setNum(orderItem.getNum() - (Integer) map.get("num"));
            orderItem.setMoney(orderItem.getPrice() * orderItem.getNum());

            orderItemMapper.updateByPrimaryKeySelective(orderItem);
//            新订单相仿详情加数量和金额
            OrderItem neworderItem = new OrderItem();
            BeanUtils.copyProperties(orderItem, neworderItem);
            neworderItem.setOrderId(newOrderId + "");
            neworderItem.setNum((Integer) map.get("num"));
            neworderItem.setOrderId(newOrderId + "");
            neworderItem.setMoney((Integer) map.get("num") * neworderItem.getPrice());
            orderItemMapper.updateByPrimaryKeySelective(neworderItem);
        }
        Date date = new Date();
        newOrder.setTotalNum(totalNum);
        newOrder.setId(newOrderId + "");
        newOrder.setCreateTime(date);
        return order;
    }

    @Transactional
    public void updatePayStatus(String orderId, String transactionId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        System.out.println("开始更新订单状态updatePayStatus" + order.getPayStatus());
        if (order != null && "0".equals(order.getPayStatus())) {//存在订单且状态为0
            order.setPayStatus("1");
            order.setOrderStatus("1");
            order.setUpdateTime(new Date());
            order.setPayTime(new Date());
            order.setTransactionId(transactionId);//微信返回的交易流水号
            orderMapper.updateByPrimaryKeySelective(order);
            //记录订单变动日志
            OrderLog orderLog = new OrderLog();

            orderLog.setId(idWorker.nextId() + "");
            System.out.println(orderLog.getId());
            orderLog.setOperater("system");//系统
            orderLog.setOperateTime(new Date());//操作时间
            orderLog.setOrderStatus("1");//订单状态
            orderLog.setPayStatus("1");//支付状态
            orderLog.setRemarks("支付流水号：" + transactionId);//备注
            orderLog.setOrderId(orderId);
            orderLogMapper.insert(orderLog);
        }
    }

    /**
     * 构建查询条件
     *
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap) {
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null) {
            // 订单id
            if (searchMap.get("id") != null && !"".equals(searchMap.get("id"))) {
                criteria.andLike("id", "%" + searchMap.get("id") + "%");
            }
            // 支付类型，1、在线支付、0 货到付款
            if (searchMap.get("payType") != null && !"".equals(searchMap.get("payType"))) {
                criteria.andLike("payType", "%" + searchMap.get("payType") + "%");
            }
            // 物流名称
            if (searchMap.get("shippingName") != null && !"".equals(searchMap.get("shippingName"))) {
                criteria.andLike("shippingName", "%" + searchMap.get("shippingName") + "%");
            }
            // 物流单号
            if (searchMap.get("shippingCode") != null && !"".equals(searchMap.get("shippingCode"))) {
                criteria.andLike("shippingCode", "%" + searchMap.get("shippingCode") + "%");
            }
            // 用户名称
            if (searchMap.get("username") != null && !"".equals(searchMap.get("username"))) {
                criteria.andLike("username", "%" + searchMap.get("username") + "%");
            }
            // 买家留言
            if (searchMap.get("buyerMessage") != null && !"".equals(searchMap.get("buyerMessage"))) {
                criteria.andLike("buyerMessage", "%" + searchMap.get("buyerMessage") + "%");
            }
            // 是否评价
            if (searchMap.get("buyerRate") != null && !"".equals(searchMap.get("buyerRate"))) {
                criteria.andLike("buyerRate", "%" + searchMap.get("buyerRate") + "%");
            }
            // 收货人
            if (searchMap.get("receiverContact") != null && !"".equals(searchMap.get("receiverContact"))) {
                criteria.andLike("receiverContact", "%" + searchMap.get("receiverContact") + "%");
            }
            // 收货人手机
            if (searchMap.get("receiverMobile") != null && !"".equals(searchMap.get("receiverMobile"))) {
                criteria.andLike("receiverMobile", "%" + searchMap.get("receiverMobile") + "%");
            }
            // 收货人地址
            if (searchMap.get("receiverAddress") != null && !"".equals(searchMap.get("receiverAddress"))) {
                criteria.andLike("receiverAddress", "%" + searchMap.get("receiverAddress") + "%");
            }
            // 订单来源：1:web，2：app，3：微信公众号，4：微信小程序  5 H5手机页面
            if (searchMap.get("sourceType") != null && !"".equals(searchMap.get("sourceType"))) {
                criteria.andLike("sourceType", "%" + searchMap.get("sourceType") + "%");
            }
            // 交易流水号
            if (searchMap.get("transactionId") != null && !"".equals(searchMap.get("transactionId"))) {
                criteria.andLike("transactionId", "%" + searchMap.get("transactionId") + "%");
            }
            // 订单状态
            if (searchMap.get("orderStatus") != null && !"".equals(searchMap.get("orderStatus"))) {
                criteria.andLike("orderStatus", "%" + searchMap.get("orderStatus") + "%");
            }
            // 支付状态
            if (searchMap.get("payStatus") != null && !"".equals(searchMap.get("payStatus"))) {
                criteria.andLike("payStatus", "%" + searchMap.get("payStatus") + "%");
            }
            // 发货状态
            if (searchMap.get("consignStatus") != null && !"".equals(searchMap.get("consignStatus"))) {
                criteria.andLike("consignStatus", "%" + searchMap.get("consignStatus") + "%");
            }
            // 是否删除
            if (searchMap.get("isDelete") != null && !"".equals(searchMap.get("isDelete"))) {
                criteria.andLike("isDelete", "%" + searchMap.get("isDelete") + "%");
            }

            // 数量合计
            if (searchMap.get("totalNum") != null) {
                criteria.andEqualTo("totalNum", searchMap.get("totalNum"));
            }
            // 金额合计
            if (searchMap.get("totalMoney") != null) {
                criteria.andEqualTo("totalMoney", searchMap.get("totalMoney"));
            }
            // 优惠金额
            if (searchMap.get("preMoney") != null) {
                criteria.andEqualTo("preMoney", searchMap.get("preMoney"));
            }
            // 邮费
            if (searchMap.get("postFee") != null) {
                criteria.andEqualTo("postFee", searchMap.get("postFee"));
            }
            // 实付金额
            if (searchMap.get("payMoney") != null) {
                criteria.andEqualTo("payMoney", searchMap.get("payMoney"));
            }
            //批量发货
            if (searchMap.get("ids") != null) {
                criteria.andIn("id", Arrays.asList((String[]) searchMap.get("ids")));
            }

        }
        return example;
    }

}
