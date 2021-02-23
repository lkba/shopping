package com.lkb.service.teammanager;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.EnterTime;

import java.lang.reflect.Array;
import java.util.*;

/**
 * enterTime业务逻辑层
 */
public interface EnterTimeService {


    public List<EnterTime> findAll();
     public String[] findTimes();


    public PageResult<EnterTime> findPage(int page, int size);


    public List<EnterTime> findList(Map<String, Object> searchMap);


    public PageResult<EnterTime> findPage(Map<String, Object> searchMap, int page, int size);


    public EnterTime findById(Integer id);

    public void add(EnterTime enterTime);


    public void update(EnterTime enterTime);


    public void delete(Integer id);

}
