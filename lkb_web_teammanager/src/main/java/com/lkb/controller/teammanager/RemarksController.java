package com.lkb.controller.teammanager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.teammanager.Remarks;
import com.lkb.service.teammanager.RemarksService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/remarks")
public class RemarksController {

    @Reference
    private RemarksService remarksService;

    @GetMapping("/findAll")
    public List<Remarks> findAll(){
        return remarksService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Remarks> findPage(int page, int size){
        return remarksService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Remarks> findList(@RequestBody Map<String,Object> searchMap){
        return remarksService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Remarks> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  remarksService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Remarks findById(Integer rid){
        return remarksService.findById(rid);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Remarks remarks){
        remarksService.add(remarks);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Remarks remarks){
        remarksService.update(remarks);
        return new Result();
    }

    @PostMapping("/updatefiles")
    public Result updatefiles(String key,String val){
        remarksService.updatefiles( key, val);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer rid){
        remarksService.delete(rid);
        return new Result();
    }

}
