package com.lkb.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.goods.Sku;
import com.lkb.service.goods.SkuService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/sku")
public class SkuController {

    @Reference
    private SkuService skuService;

    @GetMapping("/findAll")
    public List<Sku> findAll(){
        return skuService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Sku> findPage(int page, int size){
        return skuService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Sku> findList(@RequestBody Map<String,Object> searchMap){
        return skuService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Sku> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  skuService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Sku findById(String id){
        return skuService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Sku sku){
        skuService.add(sku);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Sku sku){
        skuService.update(sku);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        skuService.delete(id);
        return new Result();
    }

    @PostMapping("/addSkus")
    public List<Sku> addSkus(){
        List<Sku> skuList=skuService.findAll();
        for(Sku sku:skuList){
            System.out.println(sku.getBrandName());
        }
        //        HttpHost httpHost=new HttpHost("127.0.0.1",9200,"http");//url地址封装
//        RestClientBuilder builder= RestClient.builder(httpHost);//rest客户端构建器
//        RestHighLevelClient restHighLevelClient=new RestHighLevelClient(builder);// rest高级客户端
        return skuList;
    }

}
