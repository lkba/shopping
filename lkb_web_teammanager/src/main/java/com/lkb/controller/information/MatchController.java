package com.lkb.controller.information;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.information.Match;
import com.lkb.service.information.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Reference
    private MatchService matchService;

    @GetMapping("/findAll")
    public List<Match> findAll(){
        return matchService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Match> findPage(int page, int size){
        return matchService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Match> findList(@RequestBody Map<String,Object> searchMap){
        return matchService.findList(searchMap);
    }

    @GetMapping("/findMacthLast")
    public JSONObject findMacthLast(){
        int id=matchService.findMacthLast();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("id",id);
        return jsonObject;
    }

    @PostMapping("/findPage")
    public PageResult<Match> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  matchService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Match findById(Integer id){
        return matchService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Match match){
        matchService.add(match);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Match match){
        matchService.update(match);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer id){
        matchService.delete(id);
        return new Result();
    }

}
