package com.lkb.controller.teammanager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.teammanager.TableGrade;
import com.lkb.service.teammanager.TableGradeService;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tableGrade")
public class TableGradeController {

    @Reference
    private TableGradeService tableGradeService;

    @GetMapping("/findAll")
    public List<TableGrade> findAll(){
        return tableGradeService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<TableGrade> findPage(int page, int size){
        return tableGradeService.findPage(page, size);
    }

    @PostMapping("/findPageGradeList")
    public Map<String,List<Map>> findPageGradeList(@RequestBody Map<String,Object> searchMap,  int page, int size) throws UnsupportedEncodingException {
        return tableGradeService.findPageGradeList(searchMap,page,size);
    }

    @PostMapping("/findList")
    public List<TableGrade> findList(@RequestBody Map<String,Object> searchMap){
        return tableGradeService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<TableGrade> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  tableGradeService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public TableGrade findById(Integer gid){
        return tableGradeService.findById(gid);
    }


    @PostMapping("/add")
    public Result add(@RequestBody TableGrade tableGrade){
        tableGradeService.add(tableGrade);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody TableGrade tableGrade){
        tableGradeService.update(tableGrade);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer gid){
        tableGradeService.delete(gid);
        return new Result();
    }

}
