package com.lkb.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.user.Areas;
import com.lkb.service.user.AreasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/areas")
public class AreasController {

    @Reference
    private AreasService areasService;

    @GetMapping("/findAll")
    public List<Areas> findAll(){
        return areasService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Areas> findPage(int page, int size){
        return areasService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Areas> findList(@RequestBody Map<String,Object> searchMap){
        return areasService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Areas> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  areasService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Areas findById(String areaid){
        return areasService.findById(areaid);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Areas areas){
        areasService.add(areas);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Areas areas){
        areasService.update(areas);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String areaid){
        areasService.delete(areaid);
        return new Result();
    }

}
