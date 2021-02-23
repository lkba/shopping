package com.lkb.service.teammanager;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.Teammate;

import java.util.*;

/**
 * teammate业务逻辑层
 */
public interface TeammateService {


    public List<Teammate> findAll();
    public Map findCount();

    public PageResult<Teammate> findPage(int page, int size);


    public List<Teammate> findList(Map<String, Object> searchMap);


    public PageResult<Teammate> findPage(Map<String, Object> searchMap, int page, int size);


    public Teammate findById(Integer id);

    public void add(Teammate teammate);


    public void update(Teammate teammate);


    public void delete(Integer id);

}
