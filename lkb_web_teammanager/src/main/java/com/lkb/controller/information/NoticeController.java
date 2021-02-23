package com.lkb.controller.information;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.information.Notice;
import com.lkb.service.information.NoticeService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Reference
    private NoticeService noticeService;

    @GetMapping("/findAll")
    public List<Notice> findAll(){
        return noticeService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Notice> findPage(int page, int size){
        return noticeService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Notice> findList(@RequestBody Map<String,Object> searchMap){
        return noticeService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Notice> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  noticeService.findPage(searchMap,page,size);
    }



    @GetMapping("/findById")
    public Notice findById(Integer nid){
        return noticeService.findById(nid);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Notice notice){
        noticeService.add(notice);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Notice notice){
        noticeService.update(notice);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer nid){
        noticeService.delete(nid);
        return new Result();
    }

}
