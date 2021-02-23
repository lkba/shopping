package com.lkb.dao;

import com.lkb.pojo.teammanager.BasicInfor;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface BasicInforMapper extends Mapper<BasicInfor> {
    @Select("select team from tb_basic_infor where tid= #{tid}")
    public List<Map>  getAllTeamName(@Param("tid") String tid);
}
