package com.lkb.service.teammanager;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.TableEnter;

import java.util.*;

/**
 * tableEnter业务逻辑层
 */
public interface TableEnterService {


    public List<TableEnter> findAll();


    public PageResult<TableEnter> findPage(int page, int size);


    public List<TableEnter> findList(Map<String, Object> searchMap);


    public PageResult<TableEnter> findPage(Map<String, Object> searchMap, int page, int size);


    public TableEnter findById(Integer eid);

    public void add(TableEnter tableEnter);


    public void update(TableEnter tableEnter);


    public void delete(Integer eid);

}
