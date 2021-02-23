package com.lkb.service.teammanager;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.Admin;

import java.util.*;

/**
 * admin业务逻辑层
 */
public interface AdminService {


    public List<Admin> findAll();


    public PageResult<Admin> findPage(int page, int size);


    public List<Admin> findList(Map<String, Object> searchMap);


    public PageResult<Admin> findPage(Map<String, Object> searchMap, int page, int size);


    public Admin findById(Integer aid);

    public void add(Admin admin);


    public void update(Admin admin);


    public void delete(Integer aid);

}
