package com.lkb.controller.seckill;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.seckill.SeckillGoods;
import com.lkb.service.seckill.SeckillGoodsService;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/seckill")
public class SeckillGoodsController {

    @Reference
    private SeckillGoodsService seckillGoodsService;

    @GetMapping("/findAll")
    public List<SeckillGoods> findAll(){
        return seckillGoodsService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<SeckillGoods> findPage(int page, int size){
        return seckillGoodsService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<SeckillGoods> findList(@RequestBody Map<String,Object> searchMap){
        return seckillGoodsService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<SeckillGoods> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  seckillGoodsService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public SeckillGoods findById(String id){
        return seckillGoodsService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody SeckillGoods orderLog){
        seckillGoodsService.add(orderLog);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody SeckillGoods orderLog) throws ParseException {
//        DateFormat format=new D
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String end=formatter.format(orderLog.getEndTime());
        String start=formatter.format(orderLog.getStartTime());
        System.out.println(end);
        orderLog.setEndTime(formatter.parse(end));
        orderLog.setStartTime(formatter.parse(start));


//        String dateString = formatter.format(currentTime);
//        ParsePosition pos = new ParsePosition(8);
//        Date currentTime_2 = formatter.parse(dateString, pos);

        System.out.println(orderLog.toString());
        seckillGoodsService.update(orderLog);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        seckillGoodsService.delete(id);
        return new Result();
    }

}
