package com.lkb.service.teammanager;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.TempInfo;

import java.util.*;

/**
 * tempInfo业务逻辑层
 */
public interface TempInfoService {


    public List<TempInfo> findAll();


    public PageResult<TempInfo> findPage(int page, int size);


    public List<TempInfo> findList(Map<String, Object> searchMap);


    public PageResult<TempInfo> findPage(Map<String, Object> searchMap, int page, int size);


    public TempInfo findById(Integer tpid);

    public void add(TempInfo tempInfo);


    public void update(TempInfo tempInfo);


    public void delete(Integer tpid);

}
