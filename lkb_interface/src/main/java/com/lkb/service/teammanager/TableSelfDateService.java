package com.lkb.service.teammanager;
import com.alibaba.fastjson.JSON;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.TableSelfDate;

import java.text.ParseException;
import java.util.*;

/**
 * tableSelfDate业务逻辑层
 */
public interface TableSelfDateService {


    public List<TableSelfDate> findAll();


    public PageResult<TableSelfDate> findPage(int page, int size);


    public List<TableSelfDate> findList(Map<String, Object> searchMap);


    public PageResult<TableSelfDate> findPage(Map<String, Object> searchMap, int page, int size);


    public TableSelfDate findById(Integer id);

//    public void add(TableSelfDate tableSelfDate);

    public JSON add(String tableSelfDate) throws ParseException;

    public JSON addSelfTab();

    public void update(TableSelfDate tableSelfDate);


    public void delete(Integer id);

}
