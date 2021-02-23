package com.lkb.service.information;
import com.lkb.entity.PageResult;
import com.lkb.pojo.information.MatchPicture;

import java.util.*;

/**
 * matchPicture业务逻辑层
 */
public interface MatchPictureService {


    public List<MatchPicture> findAll();


    public PageResult<MatchPicture> findPage(int page, int size);


    public List<MatchPicture> findList(Map<String, Object> searchMap);


    public PageResult<MatchPicture> findPage(Map<String, Object> searchMap, int page, int size);


    public MatchPicture findById(Integer pid);

    public void add(MatchPicture matchPicture);


    public void update(MatchPicture matchPicture);


    public void delete(Integer pid);

}
