package com.lkb.service.teammanager;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.TempTeacher;

import java.util.*;

/**
 * tempTeacher业务逻辑层
 */
public interface TempTeacherService {


    public List<TempTeacher> findAll();


    public PageResult<TempTeacher> findPage(int page, int size);


    public List<TempTeacher> findList(Map<String, Object> searchMap);


    public PageResult<TempTeacher> findPage(Map<String, Object> searchMap, int page, int size);


    public TempTeacher findById(Integer id);

    public void add(TempTeacher tempTeacher);


    public void update(TempTeacher tempTeacher);


    public void delete(Integer id);

}
