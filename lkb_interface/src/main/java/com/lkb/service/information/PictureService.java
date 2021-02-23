package com.lkb.service.information;
import com.lkb.entity.PageResult;
import com.lkb.pojo.information.Picture;

import java.util.*;

/**
 * picture业务逻辑层
 */
public interface PictureService {


    public List<Picture> findAll();


    public PageResult<Picture> findPage(int page, int size);


    public List<Picture> findList(Map<String, Object> searchMap);


    public PageResult<Picture> findPage(Map<String, Object> searchMap, int page, int size);


    public Picture findById(Integer nid);

    public void add(Picture picture);


    public void update(Picture picture);


    public void delete(Integer nid);

}
