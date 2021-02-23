package com.lkb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.teammanager.TableEnter;
import com.lkb.service.teammanager.TableEnterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tableEnter")
public class TableEnterController {

    @Reference
    private TableEnterService tableEnterService;

    @GetMapping("/findAll")
    public List<TableEnter> findAll(){
        return tableEnterService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<TableEnter> findPage(int page, int size){
        return tableEnterService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<TableEnter> findList(@RequestBody Map<String,Object> searchMap){
        return tableEnterService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<TableEnter> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  tableEnterService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public TableEnter findById(Integer eid){
        return tableEnterService.findById(eid);
    }


    @PostMapping("/add")
    public Result add(@RequestBody TableEnter tableEnter){
        tableEnterService.add(tableEnter);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody TableEnter tableEnter){
        tableEnterService.update(tableEnter);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer eid){
        tableEnterService.delete(eid);
        return new Result();
    }

}
