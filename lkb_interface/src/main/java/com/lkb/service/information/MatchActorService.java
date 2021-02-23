package com.lkb.service.information;
import com.lkb.entity.PageResult;
import com.lkb.pojo.information.MatchActor;

import java.util.*;

/**
 * matchActor业务逻辑层
 */
public interface MatchActorService {


    public List<MatchActor> findAll();

    public Integer findActorCount(Map<String, Object> searchMap);

    public PageResult<MatchActor> findPage(int page, int size);


    public List<MatchActor> findList(Map<String, Object> searchMap);


    public PageResult<MatchActor> findPage(Map<String, Object> searchMap, int page, int size);


    public MatchActor findById(Integer ma_id);

    public void add(MatchActor matchActor);


    public void update(MatchActor matchActor);


    public void delete(Integer ma_id);

}
