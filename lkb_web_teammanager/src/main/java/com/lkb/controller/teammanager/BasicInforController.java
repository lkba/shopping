package com.lkb.controller.teammanager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.teammanager.BasicInfor;
import com.lkb.service.teammanager.BasicInforService;
import jdk.nashorn.internal.runtime.ParserException;
import net.sf.jsqlparser.statement.select.PivotXml;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/basicInfor")
public class BasicInforController {

    @Reference
    private BasicInforService basicInforService;

    @GetMapping("/findAll")
    public List<BasicInfor> findAll(){
        return basicInforService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<BasicInfor> findPage(int page, int size){
        return basicInforService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<BasicInfor> findList(@RequestBody Map<String,Object> searchMap){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<BasicInfor> basicInforList=basicInforService.findList(searchMap);

//        basicInforList.get(0).setRegTime(sdf.format(basicInforList.get(0).getRegTime()));
        return basicInforList;
    }

    @PostMapping("/findPage")
    public PageResult<BasicInfor> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  basicInforService.findPage(searchMap,page,size);
    }

    @GetMapping("/updateMoney")
    public JSON updateMoney(Integer tid, String money){
        return  basicInforService.updateMoney(tid,money);
    }

    @GetMapping("/findById")
    public BasicInfor findById(Integer id){
        return basicInforService.findById(id);

    }


    @PostMapping("/add")
    public Result add(@RequestBody BasicInfor basicInfor){
        basicInforService.add(basicInfor);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody BasicInfor basicInfor){
        basicInforService.update(basicInfor);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer id){
        basicInforService.delete(id);
        return new Result();
    }

}
