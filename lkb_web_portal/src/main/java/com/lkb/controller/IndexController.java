package com.lkb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.pojo.business.Ad;
import com.lkb.service.business.AdService;
import com.lkb.service.goods.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Reference
    private AdService adService;

    @Reference
    private CategoryService categoryService;
    /**
     * 网站首页
     * @return
     */
    @GetMapping("/index")
    public String index(Model model){
        //查询首页轮播图
        List<Ad> lbtList = adService.findByPosition("index_lb");
//        System.out.println(lbtList);
        model.addAttribute("lbt",lbtList);


        //分类列表
        List<Map> categoryList=categoryService.findCategoryTree();
        model.addAttribute("categoryList",categoryList);

        return "index";
    }
}