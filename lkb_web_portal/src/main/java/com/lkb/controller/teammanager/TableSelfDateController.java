package com.lkb.controller.teammanager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.teammanager.TableSelfDate;
import com.lkb.service.teammanager.TableSelfDateService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tableSelfDate")
public class TableSelfDateController {

    @Reference
    private TableSelfDateService tableSelfDateService;

    @GetMapping("/findAll")
    public List<TableSelfDate> findAll() {
        return tableSelfDateService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<TableSelfDate> findPage(int page, int size) {
        return tableSelfDateService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<TableSelfDate> findList(@RequestBody Map<String, Object> searchMap) {
        return tableSelfDateService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<TableSelfDate> findPage(@RequestBody Map<String, Object> searchMap, int page, int size) {
        return tableSelfDateService.findPage(searchMap, page, size);
    }

    @GetMapping("/findById")
    public TableSelfDate findById(Integer id) {
        return tableSelfDateService.findById(id);
    }


    //    @PostMapping("/add")
//    public Result add(@RequestBody TableSelfDate tableSelfDate){
//        tableSelfDateService.add(tableSelfDate);
//        return new Result();
//    }
    @PostMapping("/add")
    public JSON add(@RequestParam("date") String tableSelfDate) throws ParseException {
        return tableSelfDateService.add(tableSelfDate);
    }
    @GetMapping("/addSelfTab")
    public JSON addSelfTab(){
        return tableSelfDateService.addSelfTab();
    }


    @PostMapping("/update")
    public Result update(@RequestBody TableSelfDate tableSelfDate) {
        tableSelfDateService.update(tableSelfDate);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer id) {
        tableSelfDateService.delete(id);
        return new Result();
    }

}
