package com.lkb.service.information;
import com.lkb.entity.PageResult;
import com.lkb.pojo.information.Match;

import java.util.*;

/**
 * match业务逻辑层
 */
public interface MatchService {


    public List<Match> findAll();
    public Integer findMacthLast();
    public List<Map> findMatchOnReleaseTimeDesc();

    public PageResult<Match> findPage(int page, int size);


    public List<Match> findList(Map<String, Object> searchMap);


    public PageResult<Match> findPage(Map<String, Object> searchMap, int page, int size);


    public Match findById(Integer id);

    public void add(Match match);


    public void update(Match match);


    public void delete(Integer id);

}
