package com.lkb.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.goods.Goods;
import com.lkb.pojo.goods.Spu;
import com.lkb.service.goods.SpuService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/spu")
public class SpuController {

    @Reference
    private SpuService spuService;

    @GetMapping("/findAll")
    public List<Spu> findAll(){
        return spuService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Spu> findPage(int page, int size){
        return spuService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Spu> findList(@RequestBody Map<String,Object> searchMap){
        return spuService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Spu> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  spuService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Spu findById(String id){
        return spuService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Spu spu){
        spuService.add(spu);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Spu spu){
        spuService.update(spu);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        spuService.delete(id);
        return new Result();
    }

    @PostMapping("/save")
    public Result save(@RequestBody Goods goods) throws Exception {
        spuService.saveGoods(goods);
        return new Result();

    }

    @GetMapping("/findGoodsById")
    public Goods findGoodsById(String id){
        return  spuService.findGoodsById(id);
    }

    @GetMapping("/audit")
    public Result audit(@RequestBody Map<String ,String> map){
        spuService.audit(map.get("id"),map.get("status"),map.get("message"));
        return new Result();
    }

    @GetMapping("/pull")
    public Result pull(String id){
        spuService.pull(id);
        return new Result();
    }

    @GetMapping("/put")
    public Result put(String id){
        spuService.put(id);
        return new Result();
    }

    @GetMapping("/putMany")
    public Result putMany(Long[] ids){
        int count = spuService.putMany(ids);
        return new Result(0,"上架"+count+"个商品");
    }

    @GetMapping("/pullMany")
    public Result pullMany(Long[] ids){
        int count = spuService.pullMany(ids);
        return new Result(0,"下架"+count+"个商品");
    }

    @GetMapping("/deleteGoods")
    public Result deleteGoods(String id){
        spuService.deleteGoods(id);
        return new Result();
    }

    @GetMapping("/reGoods")
    public Result reGoods(String id){
        spuService.reGoods(id);
        return new Result();
    }


}
