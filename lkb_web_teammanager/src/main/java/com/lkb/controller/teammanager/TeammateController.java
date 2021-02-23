package com.lkb.controller.teammanager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.teammanager.Teammate;
import com.lkb.service.teammanager.TeammateService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/teammate")
public class TeammateController {

    @Reference
    private TeammateService teammateService;

    @GetMapping("/findAll")
    public List<Teammate> findAll(){
        return teammateService.findAll();
    }

    @GetMapping("/findCount")
    public Map findCount(){
        return teammateService.findCount();
    }

    @GetMapping("/findPage")
    public PageResult<Teammate> findPage(int page, int size){
        return teammateService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Teammate> findList(@RequestBody Map<String,Object> searchMap){
        return teammateService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Teammate> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  teammateService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Teammate findById(Integer id){
        return teammateService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Teammate teammate){
        teammateService.add(teammate);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Teammate teammate){
        teammateService.update(teammate);
        return new Result();
    }


    @GetMapping("/delete")
    public Result delete(Integer id){
        teammateService.delete(id);
        return new Result();
    }

}
