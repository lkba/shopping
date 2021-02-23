package com.lkb.controller.information;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.information.NewsManypop;
import com.lkb.service.information.NewsManypopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/newsManypop")
public class NewsManypopController {

    @Reference
    private NewsManypopService newsManypopService;

    @GetMapping("/findAll")
    public List<NewsManypop> findAll(){
        return newsManypopService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<NewsManypop> findPage(int page, int size){
        return newsManypopService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<NewsManypop> findList(@RequestBody Map<String,Object> searchMap){
        return newsManypopService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<NewsManypop> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  newsManypopService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public NewsManypop findById(Integer id){
        return newsManypopService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody NewsManypop newsManypop){
        newsManypopService.add(newsManypop);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody NewsManypop newsManypop){
        newsManypopService.update(newsManypop);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer id){
        newsManypopService.delete(id);
        return new Result();
    }

}
