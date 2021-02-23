package com.lkb.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lkb.pojo.goods.Goods;
import com.lkb.pojo.goods.Sku;
import com.lkb.pojo.goods.Spu;
import com.lkb.service.goods.CategoryService;
import com.lkb.service.goods.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Reference
    private SpuService spuService;

    @Autowired
    private TemplateEngine templateEngine;//在配置文件配置

    @Value("${pagePath}")
    private String pagePath;

    @Reference
    private CategoryService categoryService;


    /**
     * 生成商品详细页
     *
     * @param spuId
     */
    @GetMapping("/createPage")
    public void createPage(String spuId) {

        //查询商品信息
        Goods goods = spuService.findGoodsById(spuId);
        //获取SPU 信息
        Spu spu = goods.getSpu();
        //获取sku列表
        List<Sku> skuList = goods.getSkuList();

        //查询商品分类
        List<String> categoryList = new ArrayList<String>();
        categoryList.add(categoryService.findById(spu.getCategory1Id()).getName());//一级分类
        categoryList.add(categoryService.findById(spu.getCategory2Id()).getName());//二级分类
        categoryList.add(categoryService.findById(spu.getCategory3Id()).getName());//三级分类

        //通过地址获取sku 内容，先将所有url 保存在urlmap中
        Map<String,String> urlMap=new HashMap<>();
        for(Sku sku:skuList){
            if("1".equals(sku.getStatus())){//当状态为 1 存在  组合{"版本":"6GB+64GB","颜色":"红色"}
                String specJson=JSON.toJSONString(JSON.parseObject(sku.getSpec()), SerializerFeature.MapSortField);
                urlMap.put(specJson,sku.getId()+".html");
                System.out.println("存在:"+sku.getStatus()+"--specJson"+specJson);
            }else {
                System.out.println("不存在:"+sku.getStatus()+"--specJson"+null);
            }

        }


        //创建页面（每个SKU为一个页面）
        for (Sku sku : skuList) {
            // 1.上下文
            Context context = new Context();
            //创建数据模型
            Map<String, Object> dataModel = new HashMap();
            dataModel.put("spu", spu);
            dataModel.put("sku", sku);
            dataModel.put("categoryList", categoryList);

            dataModel.put("skuImages", sku.getImages().split(","));//SKU图片列表
            dataModel.put("spuImages", spu.getImages().split(","));//SPU图片列表

            Map paraItems = JSON.parseObject(spu.getParaItems());//SPU参数列表
            dataModel.put("paraItems", paraItems);
            Map<String ,String > specItems = (Map)JSON.parseObject(sku.getSpec());//当前SKU规格
            dataModel.put("specItems", specItems);

            //规格选择面板
            // {"颜色":["天空之境","珠光贝母"],"内存":["8GB+64GB","8GB+128GB","8GB+256GB"]}
            // {"颜色":[{‘option’:"天空之境",checked:true},{‘option’:"珠光贝母",checked:false}]
            Map<String, List> specMap = (Map) JSON.parse(spu.getSpecItems());
            for(String key:specMap.keySet()){
                System.out.println(specMap.get(key));
                if (specMap.get(key)!=null){
//
//                    if (specMap.get(key) instanceof String){
//
//                    }else {
                        List<String> list=specMap.get(key);//["天空之境","珠光贝母"]
//                    }
                    List<Map> mapList=new ArrayList<>();//新的集合 [{‘option’:"天空之境",checked:true},{‘option’:"珠光贝母",checked:false}]

                    //循环规格选项
                    for(String value:list){
                        Map map=new HashMap();
                        map.put("option",value);

                        if (specItems.get(key)!=null){
                            if(specItems.get(key).equals(value)){//如果和当前的sku规格相同则选中
                                map.put("checked",true);
                            }else {
                                map.put("checked",false);
                            }
                        }


                        Map<String,String> spec=(Map) JSON.parseObject(sku.getSpec());//当前的Sku，
                        spec.put(key,value);
                        String specJson=JSON.toJSONString(spec,SerializerFeature.MapSortField);//得到spec字符串  SerializerFeature.MapSortField: 排序使字符串一样
//                    System.out.println("specJson："+specJson);
                        map.put("url",urlMap.get(specJson));

                        mapList.add(map);
                    }

                    specMap.put(key,mapList);//用新集合覆盖原集合
                }

            }
            dataModel.put("specMap", specMap);//规格面板

            context.setVariables(dataModel);
            // 2.准备文件
            File dir = new File(pagePath);
            if (!dir.exists()) {
                dir.mkdir();
            }
//            System.out.println("skuId:"+sku.getId());
            File dest = new File(dir, sku.getId() + ".html");
            // 3.生成页面
            try {
                PrintWriter writer = new PrintWriter(dest, "UTF-8");
                templateEngine.process("item", context, writer);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }


}
