package com.lkb.controller.teammanager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.teammanager.BasicInfor;
import com.lkb.pojo.teammanager.TableOut;
import com.lkb.pojo.teammanager.TableOutUserBasic;
import com.lkb.pojo.teammanager.User;
import com.lkb.service.teammanager.TableOutService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tableOut")
public class TableOutController {

    @Reference
    private TableOutService tableOutService;

    @GetMapping("/findAll")
    public List<TableOut> findAll(){
        return tableOutService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<TableOut> findPage(int page, int size){
        return tableOutService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<TableOut> findList(@RequestBody Map<String,Object> searchMap){
        return tableOutService.findList(searchMap);
    }

    @PostMapping("/findPageUserBaisc")
    public List<TableOutUserBasic>  findPageUserBaisc(@RequestBody Map<String,Object> searchMap, int page, int size){
        return  tableOutService.findPageUserBaisc(searchMap,page,size);
    }

    @PostMapping("/findPage")
    public PageResult<TableOut> findPage(@RequestBody Map<String,Object> searchMap, int page, int size){
        return  tableOutService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public TableOut findById(Integer oid){
        return tableOutService.findById(oid);
    }


    @PostMapping("/add")
    public Result add(@RequestBody TableOut tableOut){
        tableOutService.add(tableOut);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody TableOut tableOut){
        tableOutService.update(tableOut);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer oid){
        tableOutService.delete(oid);
        return new Result();
    }

}
