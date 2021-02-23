package com.lkb.controller.teammanager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.teammanager.TempInfo;
import com.lkb.service.teammanager.TempInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tempInfo")
public class TempInfoController {

    @Reference
    private TempInfoService tempInfoService;

    @GetMapping("/findAll")
    public List<TempInfo> findAll(){
        return tempInfoService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<TempInfo> findPage(int page, int size){
        return tempInfoService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<TempInfo> findList(@RequestBody Map<String,Object> searchMap){
        return tempInfoService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<TempInfo> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  tempInfoService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public TempInfo findById(Integer tpid){
        return tempInfoService.findById(tpid);
    }


    @PostMapping("/add")
    public Result add(@RequestBody TempInfo tempInfo){
        tempInfoService.add(tempInfo);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody TempInfo tempInfo){
        tempInfoService.update(tempInfo);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer tpid){
        tempInfoService.delete(tpid);
        return new Result();
    }

}
