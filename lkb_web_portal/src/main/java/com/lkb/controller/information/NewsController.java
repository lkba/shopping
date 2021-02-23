package com.lkb.controller.information;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.information.News;
import com.lkb.service.information.NewsService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Reference
    private NewsService newsService;

    @GetMapping("/findAll")
    public List<News> findAll(){
        return newsService.findAll();
    }

    @PostMapping("/addNews")
    public Result  addNews(@RequestParam("content") String content,@RequestParam(value="checkList[]",required=true) List checkList) throws ParseException {
        System.out.println("content:"+content+"   checkList:"+checkList);
        newsService.addNews(content,checkList);
        return  new Result();
    }
    @GetMapping("/findPage")
    public PageResult<News> findPage(int page, int size){
        return newsService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<News> findList(@RequestBody Map<String,Object> searchMap){
        return newsService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<News> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  newsService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public News findById(Integer id){
        return newsService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody News news){
        newsService.add(news);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody News news){
        newsService.update(news);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer id){
        newsService.delete(id);
        return new Result();
    }

}
