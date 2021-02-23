package com.lkb.controller.teammanager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.teammanager.Teacher;
import com.lkb.service.teammanager.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Reference
    private TeacherService teacherService;

    @GetMapping("/findAll")
    public List<Teacher> findAll(){
        return teacherService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Teacher> findPage(int page, int size){
        return teacherService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Teacher> findList(@RequestBody Map<String,Object> searchMap){
        return teacherService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Teacher> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  teacherService.findPage(searchMap,page,size);
    }
    @PostMapping("/getTeachers")
    public List<Map> getTeachers(@RequestBody Map<String,Object> searchMap){
        return teacherService.getTeachers(searchMap);
    }
    @GetMapping("/findById")
    public Teacher findById(Integer id){
        return teacherService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Teacher teacher){
        teacherService.add(teacher);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Teacher teacher){
        teacherService.update(teacher);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer id){
        teacherService.delete(id);
        return new Result();
    }

}
