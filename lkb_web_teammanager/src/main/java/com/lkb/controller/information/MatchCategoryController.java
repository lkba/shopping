package com.lkb.controller.information;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.information.MatchCategory;
import com.lkb.service.information.MatchCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/matchCategory")
public class MatchCategoryController {

    @Reference
    private MatchCategoryService matchCategoryService;

    @GetMapping("/findAll")
    public List<MatchCategory> findAll(){
        return matchCategoryService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<MatchCategory> findPage(int page, int size){
        return matchCategoryService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<MatchCategory> findList(@RequestBody Map<String,Object> searchMap){
        return matchCategoryService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<MatchCategory> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  matchCategoryService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public MatchCategory findById(Integer cid){
        return matchCategoryService.findById(cid);
    }


    @PostMapping("/add")
    public Result add(@RequestBody MatchCategory matchCategory){
        matchCategoryService.add(matchCategory);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody MatchCategory matchCategory){
        matchCategoryService.update(matchCategory);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer cid){
        matchCategoryService.delete(cid);
        return new Result();
    }

}
