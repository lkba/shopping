package com.lkb.service.information;
import com.lkb.entity.PageResult;
import com.lkb.pojo.information.NewsMany;

import java.util.*;

/**
 * newsMany业务逻辑层
 */
public interface NewsManyService {


    public List<NewsMany> findAll();


    public PageResult<NewsMany> findPage(int page, int size);


    public List<NewsMany> findList(Map<String, Object> searchMap);


    public PageResult<NewsMany> findPage(Map<String, Object> searchMap, int page, int size);


    public NewsMany findById(Integer id);

    public void add(NewsMany newsMany);


    public void update(NewsMany newsMany);


    public void delete(Integer id);

}
