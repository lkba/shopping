package com.lkb.service.information;
import com.lkb.entity.PageResult;
import com.lkb.pojo.information.Notice;

import java.util.*;

/**
 * notice业务逻辑层
 */
public interface NoticeService {


    public List<Notice> findAll();

    public List<Map> findNoticeOnReleaseTimeDesc();
    public PageResult<Notice> findPage(int page, int size);


    public List<Notice> findList(Map<String, Object> searchMap);


    public PageResult<Notice> findPage(Map<String, Object> searchMap, int page, int size);


    public Notice findById(Integer nid);

    public void add(Notice notice);


    public void update(Notice notice);


    public void delete(Integer nid);

}
