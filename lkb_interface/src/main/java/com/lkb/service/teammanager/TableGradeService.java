package com.lkb.service.teammanager;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.TableGrade;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * tableGrade业务逻辑层
 */
public interface TableGradeService {


    public List<TableGrade> findAll();
    public int getGradeCount(Map<String, Object> searchMap);

    public PageResult<TableGrade> findPage(int page, int size);

    public Map<String,List<Map>> findPageGradeList(Map<String,Object> searchMap, int page, int size) throws UnsupportedEncodingException;

    public List<TableGrade> findList(Map<String, Object> searchMap);


    public PageResult<TableGrade> findPage(Map<String, Object> searchMap, int page, int size);


    public TableGrade findById(Integer gid);

    public void add(TableGrade tableGrade);


    public void update(TableGrade tableGrade);


    public void delete(Integer gid);
    public void deleteTableGrades(Integer grade_date_id);

}
