package com.lkb.task;

import com.lkb.dao.SeckillGoodsMapper;
import com.lkb.pojo.seckill.SeckillGoods;
import com.lkb.pojo.seckill.SeckillOrder;
import com.lkb.util.IdWorker;
import com.lkb.util.SeckillStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MultiThreadingCreateOrder {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;
    @Autowired
    private IdWorker idWorker;

    /**
     * 异步操作方法
     * run
     * 注解 @Async
     */
    @Async
    public void createOrder() {
        try {
            System.out.println("---准备抢单@Async执行---");
            Thread.sleep(10000);

            SeckillStatus seckillStatus = (SeckillStatus) redisTemplate.boundListOps("SeckillOrderQueue").rightPop();

            //用户抢单数据
            String username=seckillStatus.getUsername();
            String time=seckillStatus.getTime();
            Long id=seckillStatus.getGoodsId();

            //获取队列中的商品ID
            Object sid=redisTemplate.boundListOps("SeckillGoodsCountList_"+id).rightPop();

            //售罄
            if (sid==null){
                //清理排队信息
                clearQueue(seckillStatus);
                return;
            }

            SeckillGoods goods = (SeckillGoods) redisTemplate.boundHashOps("SeckillGoods_" + time).get(id);

            if (goods != null && goods.getStockCount() > 0) {
                //创建订单
                SeckillOrder seckillOrder = new SeckillOrder();
                seckillOrder.setId(idWorker.nextId());
                seckillOrder.setSeckillId(id);
                seckillOrder.setMoney(goods.getCostPrice());
                seckillOrder.setUserId(username);
                seckillOrder.setSellerId(goods.getSellerId());
                seckillOrder.setCreateTime(new Date());
                seckillOrder.setStatus("0");
                redisTemplate.boundHashOps("SeckillOrder").put(username, seckillOrder);

                //库存削减
                goods.setStockCount(goods.getStockCount() - 1);
                //商品库存=0->将数据同步到MySQL，并清理Redis缓存
                if (goods.getStockCount() <= 0) {
                    seckillGoodsMapper.updateByPrimaryKeySelective(goods);
                    //清理Redis缓存
                    redisTemplate.boundHashOps("SeckillGoods_" + time).delete(id);
                } else {
                    redisTemplate.boundHashOps("SeckillGoods_" + time).put(id, goods);
                }

                seckillStatus.setOrderId(seckillOrder.getId());
                seckillStatus.setMoney(seckillOrder.getMoney().floatValue());
                seckillStatus.setStatus(2);//更改抢单成功，待支付
                redisTemplate.boundHashOps("UserQueueStatus").put(username,seckillStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 清理排队信息
     * @param seckillStatus
     */
    private void clearQueue(SeckillStatus seckillStatus) {
        //清理重复排队信息
        redisTemplate.boundHashOps("UserQueueCount").delete(seckillStatus.getUsername());
        //清理排队存储信息
        redisTemplate.boundHashOps("UserQueueStatus").delete(seckillStatus.getUsername());

    }


}
