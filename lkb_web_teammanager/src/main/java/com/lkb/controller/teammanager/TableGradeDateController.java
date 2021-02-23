package com.lkb.controller.teammanager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.support.Parameter;
import com.alibaba.fastjson.JSON;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.teammanager.TableGradeDate;
import com.lkb.service.teammanager.TableGradeDateService;
import com.lkb.service.teammanager.TableGradeService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.*;

@RestController
@RequestMapping("/tableGradeDate")
public class TableGradeDateController {

    @Reference
    private TableGradeDateService tableGradeDateService;

    @GetMapping("/findAll")
    public List<TableGradeDate> findAll(){
        return tableGradeDateService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<TableGradeDate> findPage(int page, int size){
        return tableGradeDateService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<TableGradeDate> findList(@RequestBody Map<String,Object> searchMap){
        return tableGradeDateService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<TableGradeDate> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  tableGradeDateService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public TableGradeDate findById(Integer id){
        return tableGradeDateService.findById(id);
    }


    @PostMapping("/add")
    public JSON add(@RequestParam("date") String tableGradeDate) throws ParseException {
        return  tableGradeDateService.add(tableGradeDate);
    }

    @PostMapping("/update")
    public Result update(@RequestBody TableGradeDate tableGradeDate){
        tableGradeDateService.update(tableGradeDate);
        return new Result();
    }

    @GetMapping("/addGTab")
    public JSON addGTab(){
        return tableGradeDateService.addGTab();
    }

    @Reference
    private TableGradeService tableGradeService;


    @GetMapping("/delete")
    public Result delete(Integer id){
        tableGradeDateService.delete(id);
        tableGradeService.deleteTableGrades(id);
        return new Result();
    }

}
