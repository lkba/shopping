package com.lkb.controller.information;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.information.MatchPicture;
import com.lkb.service.information.MatchPictureService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/matchPicture")
public class MatchPictureController {

    @Reference
    private MatchPictureService matchPictureService;

    @GetMapping("/findAll")
    public List<MatchPicture> findAll(){
        return matchPictureService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<MatchPicture> findPage(int page, int size){
        return matchPictureService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<MatchPicture> findList(@RequestBody Map<String,Object> searchMap){
        return matchPictureService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<MatchPicture> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  matchPictureService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public MatchPicture findById(Integer pid){
        return matchPictureService.findById(pid);
    }


    @PostMapping("/add")
    public Result add(@RequestBody MatchPicture matchPicture){
        matchPictureService.add(matchPicture);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody MatchPicture matchPicture){
        matchPictureService.update(matchPicture);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer pid){
        matchPictureService.delete(pid);
        return new Result();
    }

}
