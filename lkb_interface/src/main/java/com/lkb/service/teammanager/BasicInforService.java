package com.lkb.service.teammanager;
import com.alibaba.fastjson.JSON;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.BasicInfor;

import java.util.*;

/**
 * basicInfor业务逻辑层
 */
public interface BasicInforService {


    public List<BasicInfor> findAll();


    public PageResult<BasicInfor> findPage(int page, int size);


    public List<BasicInfor> findList(Map<String, Object> searchMap);
    public JSON updateMoney(Integer tid, String money);

    public PageResult<BasicInfor> findPage(Map<String, Object> searchMap, int page, int size);


    public BasicInfor findById(Integer id);

    public void add(BasicInfor basicInfor);


    public void update(BasicInfor basicInfor);


    public void delete(Integer id);

}
