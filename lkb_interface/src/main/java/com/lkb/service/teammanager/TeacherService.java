package com.lkb.service.teammanager;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.Teacher;

import java.util.*;

/**
 * teacher业务逻辑层
 */
public interface TeacherService {

    public List<Map> getTeachers(Map<String,Object> searchMap);
    public List<Teacher> findAll();


    public PageResult<Teacher> findPage(int page, int size);


    public List<Teacher> findList(Map<String, Object> searchMap);


    public PageResult<Teacher> findPage(Map<String, Object> searchMap, int page, int size);


    public Teacher findById(Integer id);

    public void add(Teacher teacher);


    public void update(Teacher teacher);


    public void delete(Integer id);

}
