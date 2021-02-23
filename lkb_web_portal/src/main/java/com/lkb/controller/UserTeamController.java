package com.lkb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.teammanager.User;
import com.lkb.service.teammanager.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userTeam")
public class UserTeamController {

    @Reference
    private UserService userService;

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/findAuditedTeamList")
    public List<Map>  findAuditedTeamList(){
        return  userService.findAuditedTeamList();
    }

    @GetMapping("/getTeamCache")
    public Map getTeamCache(){
        //将筛选的searchMap加入缓存
        return userService.getTeamCache();
    }

//    @GetMapping("/getPhone")
//    public Map getPhone(){
//        String username= SecurityContextHolder.getContext().getAuthentication().getName();
//        User user = userService.findById(username);
//        Map map=new HashMap();
//        map.put("phone",user.getPhone());
//        return map;
//    }

    @GetMapping("/reviseTeam")
    public JSON reviseTeam(int tid,String val,String fields){
        return  userService.reviseTeam(tid,val,fields);
    }

    @GetMapping("/findPage")
    public PageResult<User> findPage(int page, int size){
        return userService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<User> findList(@RequestBody Map<String,Object> searchMap){
//        System.out.println(searchMap);
        return userService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<User> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  userService.findPage(searchMap,page,size);
    }

    @PostMapping("/findPageTeamList")
    public Map<String,List<Map>> findPageTeamList(@RequestBody Map<String,Object> searchMap,  int page, int size) throws UnsupportedEncodingException {
       return userService.findPageTeamList(searchMap,page,size);
    }
    @PostMapping("/findPageTeamOutList")
    public Map<String,List<Map>> findPageTeamOutList(@RequestBody Map<String,Object> searchMap,  int page, int size) throws UnsupportedEncodingException {
       return userService.findPageTeamOutList(searchMap,page,size);
    }
    @Autowired
    private HttpServletRequest request;

    @PostMapping("/native")
    public String nativeUpload(@RequestParam("file") MultipartFile file) {
        String path=request.getSession().getServletContext().getRealPath("file");
        String filePath = path +"/"+ file.getOriginalFilename();
        File desFile = new File(filePath);
        if(!desFile.getParentFile().exists()){
            desFile.mkdirs();
        }
        try {
            file.transferTo(desFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("path:---"+filePath);
        return "http://localhost:9101/uploads/word/"+file.getOriginalFilename();
    }

    @PostMapping("input_team")
    public JSON input_team(@RequestBody Map map) throws ParseException {
        System.out.println(map);
        return userService.input_team(map);
    }

    @PostMapping("/findTeamAll")
    public List<Map> findTeamAll(){
        return userService.findTeamAll();
    }

    @GetMapping("/findById")
    public User findById(Integer tid){
        return userService.findById(tid);
    }


    @PostMapping("/add")
    public Result add(@RequestBody User user){
        userService.add(user);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user){
        userService.update(user);
        return new Result();
    }


    @GetMapping("/delete")
    public Result delete(Integer tid){
        userService.delete(tid);
        return new Result();
    }

}
