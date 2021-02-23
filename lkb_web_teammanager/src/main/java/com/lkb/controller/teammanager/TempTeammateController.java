package com.lkb.controller.teammanager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.teammanager.TempTeammate;
import com.lkb.service.teammanager.TempTeammateService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tempTeammate")
public class TempTeammateController {

    @Reference
    private TempTeammateService tempTeammateService;

    @GetMapping("/findAll")
    public List<TempTeammate> findAll(){
        return tempTeammateService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<TempTeammate> findPage(int page, int size){
        return tempTeammateService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<TempTeammate> findList(@RequestBody Map<String,Object> searchMap){
        return tempTeammateService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<TempTeammate> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  tempTeammateService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public TempTeammate findById(Integer id){
        return tempTeammateService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody TempTeammate tempTeammate){
        tempTeammateService.add(tempTeammate);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody TempTeammate tempTeammate){
        tempTeammateService.update(tempTeammate);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer id){
        tempTeammateService.delete(id);
        return new Result();
    }

}
