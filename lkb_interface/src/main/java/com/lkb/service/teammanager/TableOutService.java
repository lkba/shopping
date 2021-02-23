package com.lkb.service.teammanager;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.TableOut;
import com.lkb.pojo.teammanager.TableOutUserBasic;

import java.util.*;

/**
 * tableOut业务逻辑层
 */
public interface TableOutService {


    public List<TableOut> findAll();


    public PageResult<TableOut> findPage(int page, int size);


    public List<TableOut> findList(Map<String, Object> searchMap);


    public PageResult<TableOut> findPage(Map<String, Object> searchMap, int page, int size);


    public List<TableOutUserBasic>  findPageUserBaisc(Map<String, Object> searchMap, int page, int size);



    public TableOut findById(Integer oid);

    public void add(TableOut tableOut);


    public void update(TableOut tableOut);


    public void delete(Integer oid);

}
