package com.lkb.controller.information;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.information.MatchActor;
import com.lkb.service.information.MatchActorService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/matchActor")
public class MatchActorController {

    @Reference
    private MatchActorService matchActorService;

    @GetMapping("/findAll")
    public List<MatchActor> findAll(){

        return matchActorService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<MatchActor> findPage(int page, int size){
        return matchActorService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<MatchActor> findList(@RequestBody Map<String,Object> searchMap){
        return matchActorService.findList(searchMap);
    }
    @PostMapping("/findActorCount")
    public Integer findActorCount(@RequestBody Map<String,Object> searchMap){
        return matchActorService.findActorCount(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<MatchActor> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  matchActorService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public MatchActor findById(Integer maId){
        return matchActorService.findById(maId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody MatchActor matchActor){
        matchActorService.add(matchActor);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody MatchActor matchActor){
        matchActorService.update(matchActor);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer maId){
        matchActorService.delete(maId);
        return new Result();
    }

}
