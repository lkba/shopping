package com.lkb.service.information;
import com.alibaba.fastjson.JSON;
import com.lkb.entity.PageResult;
import com.lkb.pojo.information.News;

import java.text.ParseException;
import java.util.*;

/**
 * news业务逻辑层
 */
public interface NewsService {


    public List<News> findAll();

//    public JSON addNews(String content, List list) throws ParseException;
    public PageResult<News> findPage(int page, int size);

    public JSON addNews(String content, List list) throws ParseException;

    public List<News> findList(Map<String, Object> searchMap);


    public PageResult<News> findPage(Map<String, Object> searchMap, int page, int size);


    public News findById(Integer id);

    public void add(News news);


    public void update(News news);


    public void delete(Integer id);

}
