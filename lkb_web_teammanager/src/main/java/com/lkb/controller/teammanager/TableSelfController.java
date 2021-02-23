package com.lkb.controller.teammanager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.teammanager.TableSelf;
import com.lkb.service.teammanager.TableSelfService;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.*;

@RestController
@RequestMapping("/tableSelf")
public class TableSelfController {

    @Reference
    private TableSelfService tableSelfService;

    @GetMapping("/findAll")
    public List<TableSelf> findAll(){
        return tableSelfService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<TableSelf> findPage(int page, int size){
        return tableSelfService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<TableSelf> findList(@RequestBody Map<String,Object> searchMap){
        return tableSelfService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<TableSelf> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  tableSelfService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public TableSelf findById(Integer sid){
        return tableSelfService.findById(sid);
    }

    @PostMapping("/findPageSelfList")
    public Map<String,List<Map>> findPageSelfList(@RequestBody Map<String,Object> searchMap,  int page, int size) throws UnsupportedEncodingException {
        return tableSelfService.findPageSelfList(searchMap,page,size);
    }

    @PostMapping("/add")
    public Result add(@RequestBody TableSelf tableSelf){
        tableSelfService.add(tableSelf);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody TableSelf tableSelf){
        tableSelfService.update(tableSelf);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer sid){
        tableSelfService.delete(sid);
        return new Result();
    }

}
