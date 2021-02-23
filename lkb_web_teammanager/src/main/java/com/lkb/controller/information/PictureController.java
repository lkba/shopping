package com.lkb.controller.information;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.information.Picture;
import com.lkb.service.information.PictureService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/picture")
public class PictureController {

    @Reference
    private PictureService pictureService;

    @GetMapping("/findAll")
    public List<Picture> findAll(){
        return pictureService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Picture> findPage(int page, int size){
        return pictureService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Picture> findList(@RequestBody Map<String,Object> searchMap){
        return pictureService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Picture> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  pictureService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Picture findById(Integer nid){
        return pictureService.findById(nid);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Picture picture){
        pictureService.add(picture);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Picture picture){
        pictureService.update(picture);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer nid){
        pictureService.delete(nid);
        return new Result();
    }

}
