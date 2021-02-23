package com.lkb.service.information;
import com.lkb.entity.PageResult;
import com.lkb.pojo.information.NewsManypop;

import java.util.*;

/**
 * newsManypop业务逻辑层
 */
public interface NewsManypopService {


    public List<NewsManypop> findAll();


    public PageResult<NewsManypop> findPage(int page, int size);


    public List<NewsManypop> findList(Map<String, Object> searchMap);


    public PageResult<NewsManypop> findPage(Map<String, Object> searchMap, int page, int size);


    public NewsManypop findById(Integer id);

    public void add(NewsManypop newsManypop);


    public void update(NewsManypop newsManypop);


    public void delete(Integer id);

}
