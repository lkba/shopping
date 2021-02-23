package com.lkb.controller.teammanager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.teammanager.TempTeacher;
import com.lkb.service.teammanager.TempTeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tempTeacher")
public class TempTeacherController {

    @Reference
    private TempTeacherService tempTeacherService;

    @GetMapping("/findAll")
    public List<TempTeacher> findAll(){
        return tempTeacherService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<TempTeacher> findPage(int page, int size){
        return tempTeacherService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<TempTeacher> findList(@RequestBody Map<String,Object> searchMap){
        return tempTeacherService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<TempTeacher> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  tempTeacherService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public TempTeacher findById(Integer id){
        return tempTeacherService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody TempTeacher tempTeacher){
        tempTeacherService.add(tempTeacher);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody TempTeacher tempTeacher){
        tempTeacherService.update(tempTeacher);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer id){
        tempTeacherService.delete(id);
        return new Result();
    }

}
