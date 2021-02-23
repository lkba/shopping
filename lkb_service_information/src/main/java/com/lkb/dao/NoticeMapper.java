package com.lkb.dao;

import com.lkb.pojo.information.Notice;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface NoticeMapper extends Mapper<Notice> {
    @Select("SELECT * from tb_notice ORDER BY ntime DESC limit 0,7")
    public List<Map> findNoticeOnReleaseTimeDesc();
}
