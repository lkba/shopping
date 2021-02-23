package com.lkb.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.Result;
import com.lkb.pojo.user.User;
import com.lkb.service.user.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;



    /**
     * 发送短信验证码
     * @param phone
     * @return
     */
    @GetMapping("/sendSms")
    public Result sendSms(String phone){
        userService.sendSms(phone);
        System.out.println(phone);
        return new Result();
    }

    @GetMapping("/getPhone")
    public Map getPhone(){
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
//        User user = userService.findById(username);
//        Map map=new HashMap();
//        map.put("phone",user.getPhone());
        return (Map)userService.findById(username);
    }

    @PostMapping("/save")
    public Result save(@RequestBody User user, String smsCode){
        System.out.println(user.getPassword());
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String newpassword=encoder.encode(user.getPassword());//加密
        user.setPassword(newpassword);
        System.out.println(user.getPassword());
        userService.add(user,smsCode);
        return new Result();
    }


}
