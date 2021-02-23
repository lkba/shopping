package com.lkb.service.teammanager;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.UserTemp;

import java.util.*;

/**
 * userTemp业务逻辑层
 */
public interface UserTempService {


    public List<UserTemp> findAll();


    public PageResult<UserTemp> findPage(int page, int size);


    public List<UserTemp> findList(Map<String, Object> searchMap);


    public PageResult<UserTemp> findPage(Map<String, Object> searchMap, int page, int size);


    public UserTemp findById(Integer tid);

    public void add(UserTemp userTemp);


    public void update(UserTemp userTemp);


    public void delete(Integer tid);

}
