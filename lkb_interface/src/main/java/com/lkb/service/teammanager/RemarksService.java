package com.lkb.service.teammanager;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.Remarks;

import java.util.*;

/**
 * remarks业务逻辑层
 */
public interface RemarksService {

    public void updatefiles(String key,String val);
    public List<Remarks> findAll();


    public PageResult<Remarks> findPage(int page, int size);


    public List<Remarks> findList(Map<String, Object> searchMap);


    public PageResult<Remarks> findPage(Map<String, Object> searchMap, int page, int size);


    public Remarks findById(Integer rid);

    public void add(Remarks remarks);


    public void update(Remarks remarks);


    public void delete(Integer rid);

}
