package com.lkb.service.teammanager;
import com.alibaba.fastjson.JSON;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.TableGradeDate;

import java.text.ParseException;
import java.util.*;

/**
 * tableGradeDate业务逻辑层
 */
public interface TableGradeDateService {


    public List<TableGradeDate> findAll();


    public PageResult<TableGradeDate> findPage(int page, int size);


    public List<TableGradeDate> findList(Map<String, Object> searchMap);


    public PageResult<TableGradeDate> findPage(Map<String, Object> searchMap, int page, int size);


    public TableGradeDate findById(Integer id);

    public JSON add(String tableGradeDate) throws ParseException;

    public JSON addGTab();

    public void update(TableGradeDate tableGradeDate);


    public void delete(Integer id);

}
