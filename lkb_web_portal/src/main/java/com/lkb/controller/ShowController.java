package com.lkb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.pojo.business.Ad;
import com.lkb.service.business.AdService;
import com.lkb.service.goods.CategoryService;
import com.lkb.service.goods.SkuSearchService;
import com.lkb.util.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ShowController {
    @Reference
    private SkuSearchService skuSearchService;

//    @GetMapping("/search")
//    public String search(Model model, @RequestParam Map<String, String> searchMap) throws Exception {
    /**
     * 网站首页
     * @return
     */
    @GetMapping("/show")
    public String index(Model model, @RequestParam Map<String, String> searchMap) throws Exception {
        //字符集处理(解决中文乱码问题)
        searchMap = WebUtil.convertCharsetToUTF8(searchMap);
        System.out.println("keys" + searchMap);

        //没有页码则设置为1
        if (searchMap.get("pageNo") == null) {
            searchMap.put("pageNo","1");
        }

        //页面传递给后端两个参数  sort排序字段  sortOrder排序规则（升序、降序）
        if (searchMap.get("sort")==null){
            searchMap.put("sort","");
        }
        if (searchMap.get("sortOrder")==null){
            searchMap.put("sortOrder","DESC");
        }


        Map reslut = skuSearchService.show(searchMap);
        model.addAttribute("result", reslut);

        //url处理
        StringBuffer url = new StringBuffer("/show.do?");
        for (String key : searchMap.keySet()) {
            url.append("&" + key + "=" + searchMap.get(key));
        }
        model.addAttribute("url", url);
        model.addAttribute("searchMap", searchMap);

        //当前页码
        int pageNo=Integer.parseInt(searchMap.get("pageNo"));
        model.addAttribute("pageNo",pageNo);

        Long totalPages=(Long) reslut.get("totalPages");//得到总页数
        int startPage=1;//开始页
        int endPage=totalPages.intValue();//结束页

        if(totalPages>5){
            startPage=pageNo-2;
            if (startPage<1){
                startPage=1;
            }
            endPage=startPage+4;
        }

        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        return "show";
    }
}