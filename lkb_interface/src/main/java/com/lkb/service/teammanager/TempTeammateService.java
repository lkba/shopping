package com.lkb.service.teammanager;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.TempTeammate;

import java.util.*;

/**
 * tempTeammate业务逻辑层
 */
public interface TempTeammateService {


    public List<TempTeammate> findAll();


    public PageResult<TempTeammate> findPage(int page, int size);


    public List<TempTeammate> findList(Map<String, Object> searchMap);


    public PageResult<TempTeammate> findPage(Map<String, Object> searchMap, int page, int size);


    public TempTeammate findById(Integer id);

    public void add(TempTeammate tempTeammate);


    public void update(TempTeammate tempTeammate);


    public void delete(Integer id);

}
