package com.lkb.service.teammanager;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.TableGrade;
import com.lkb.pojo.teammanager.TableSelf;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * tableSelf业务逻辑层
 */
public interface TableSelfService {


    public List<TableSelf> findAll();


    public PageResult<TableSelf> findPage(int page, int size);

    public int getSelfCount(Map<String, Object> searchMap);

    public int getSubCount(Map<String, Object> searchMap);


    public Map<String,List<Map>> findPageSelfList(Map<String,Object> searchMap, int page, int size) throws UnsupportedEncodingException;


    public List<TableSelf> findList(Map<String, Object> searchMap);


    public PageResult<TableSelf> findPage(Map<String, Object> searchMap, int page, int size);


    public TableSelf findById(Integer sid);

    public void add(TableSelf tableSelf);


    public void update(TableSelf tableSelf);


    public void delete(Integer sid);

    public void deleteTableSelfs(Integer self_date_id);
}
