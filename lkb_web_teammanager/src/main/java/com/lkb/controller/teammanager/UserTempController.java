package com.lkb.controller.teammanager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.teammanager.UserTemp;
import com.lkb.service.teammanager.UserTempService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/userTemp")
public class UserTempController {

    @Reference
    private UserTempService userTempService;

    @GetMapping("/findAll")
    public List<UserTemp> findAll(){
        return userTempService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<UserTemp> findPage(int page, int size){
        return userTempService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<UserTemp> findList(@RequestBody Map<String,Object> searchMap){
        return userTempService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<UserTemp> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  userTempService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public UserTemp findById(Integer tid){
        return userTempService.findById(tid);
    }


    @PostMapping("/add")
    public Result add(@RequestBody UserTemp userTemp){
        userTempService.add(userTemp);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody UserTemp userTemp){
        userTempService.update(userTemp);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer tid){
        userTempService.delete(tid);
        return new Result();
    }

}
