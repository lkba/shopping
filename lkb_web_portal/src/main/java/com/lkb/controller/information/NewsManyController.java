package com.lkb.controller.information;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.information.NewsMany;
import com.lkb.service.information.NewsManyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/newsMany")
public class NewsManyController {

    @Reference
    private NewsManyService newsManyService;

    @GetMapping("/findAll")
    public List<NewsMany> findAll(){
        return newsManyService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<NewsMany> findPage(int page, int size){
        return newsManyService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<NewsMany> findList(@RequestBody Map<String,Object> searchMap){
        return newsManyService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<NewsMany> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  newsManyService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public NewsMany findById(Integer id){
        return newsManyService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody NewsMany newsMany){
        newsManyService.add(newsMany);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody NewsMany newsMany){
        newsManyService.update(newsMany);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer id){
        newsManyService.delete(id);
        return new Result();
    }

}
