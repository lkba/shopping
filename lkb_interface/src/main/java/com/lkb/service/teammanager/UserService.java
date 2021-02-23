package com.lkb.service.teammanager;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.User;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.*;

/**
 * user业务逻辑层
 */
public interface UserService {


    public List<User> findAll();

    public List<Map> findAuditedTeamList();

    public JSON reviseTeam(int tid,String val,String fields);

    public PageResult<User> findPage(int page, int size);


    public List<User> findList(Map<String, Object> searchMap);

    public User findOneUser(Map<String, Object> searchMap);

    public PageResult<User> findPage(Map<String, Object> searchMap, int page, int size);

    public Map<String,List<Map>> findPageTeamList(Map<String, Object> searchMap, int page, int size) throws UnsupportedEncodingException;

    public Map<String,List<Map>> findPageTeamOutList(Map<String, Object> searchMap, int page, int size) throws UnsupportedEncodingException;
    public Map getTeamCache();

    public List<Map> findTeamAll();

    public User findById(Integer tid);

    public User findUserById(int tid);

    public JSON input_team(Map mteam) throws ParseException;
    public void insertNewTeam(Map mapTeam) throws ParseException;
    public void add(User user);


    public void update(User user);


    public void delete(Integer tid);

}
