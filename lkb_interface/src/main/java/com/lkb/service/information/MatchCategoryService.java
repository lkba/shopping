package com.lkb.service.information;
import com.lkb.entity.PageResult;
import com.lkb.pojo.information.MatchCategory;

import java.util.*;

/**
 * matchCategory业务逻辑层
 */
public interface MatchCategoryService {


    public List<MatchCategory> findAll();


    public PageResult<MatchCategory> findPage(int page, int size);


    public List<MatchCategory> findList(Map<String, Object> searchMap);


    public PageResult<MatchCategory> findPage(Map<String, Object> searchMap, int page, int size);


    public MatchCategory findById(Integer cid);

    public void add(MatchCategory matchCategory);


    public void update(MatchCategory matchCategory);


    public void delete(Integer cid);

}
