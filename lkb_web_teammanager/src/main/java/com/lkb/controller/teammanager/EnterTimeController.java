package com.lkb.controller.teammanager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.teammanager.BasicInfor;
import com.lkb.pojo.teammanager.EnterTime;
import com.lkb.pojo.teammanager.User;
import com.lkb.service.teammanager.BasicInforService;
import com.lkb.service.teammanager.EnterTimeService;
import com.lkb.service.teammanager.UserService;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/enterTime")
public class EnterTimeController {

    @Reference
    private EnterTimeService enterTimeService;

    @Reference
    private UserService userService;

    @Reference
    private BasicInforService basicInforService;



    @GetMapping("/findAll")
    public List<EnterTime> findAll(){
        return enterTimeService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<EnterTime> findPage(int page, int size){
        return enterTimeService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<EnterTime> findList(@RequestBody Map<String,Object> searchMap){
        return enterTimeService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<EnterTime> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  enterTimeService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public EnterTime findById(Integer id){
        return enterTimeService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody EnterTime enterTime){
        enterTimeService.add(enterTime);
        return new Result();
    }

    @GetMapping("/audEnter")
    public JSON audEnter(String tid,String res, String time) throws UnsupportedEncodingException {
        JSONObject jsonObject=new JSONObject();
        String res_g = new String(res.getBytes("ISO8859-1"),"utf-8");
        String time_g = new String(time.getBytes("ISO8859-1"),"utf-8");

        Map<String, Object> searchMap=new HashMap<String, Object>();
        searchMap.put("tid",tid);
        List<User> userList=userService.findList(searchMap);
        List<BasicInfor> basicInforList=basicInforService.findList(searchMap);
        if (res_g.equals("不通过")){
//            System.out.println("不通过");
            userList.get(0).setIsSub("0");
            userList.get(0).setIsPass("2");
            userService.update(userList.get(0));
            jsonObject.put("flag",false);
        }else if (res_g.equals("通过")){

            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
            Date date=new Date(System.currentTimeMillis());

            System.out.println("通过" +time_g+tid+date);
            userList.get(0).setIsPass("1");
            userList.get(0).setIsSub("1");
            userList.get(0).setTime(time_g);
            userService.update(userList.get(0));
            basicInforList.get(0).setInTime(date);
            basicInforService.update(basicInforList.get(0));

            String[] times = enterTimeService.findTimes();
            //
            List<String> list = Arrays.asList(times);
            boolean result = list.contains(time_g);
            if (!result){
                EnterTime enterTime=new EnterTime();
                enterTime.setTime(time_g);
                enterTimeService.add(enterTime);
            }

            jsonObject.put("flag",true);
//            System.out.println(result); // true
        }
//        System.out.println("没有流程");
        return jsonObject;
    }
    @PostMapping("/update")
    public Result update(@RequestBody EnterTime enterTime){
        enterTimeService.update(enterTime);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer id){
        enterTimeService.delete(id);
        return new Result();
    }

}
