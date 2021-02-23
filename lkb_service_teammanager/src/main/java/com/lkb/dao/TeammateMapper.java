package com.lkb.dao;

import com.lkb.pojo.teammanager.Teammate;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

public interface TeammateMapper extends Mapper<Teammate> {
    @Select("select COUNT(* ) teammates from  tb_teammate t, tb_user u where t.tid = u.tid and u.is_pass='1'")
    public Map  findTeammateCount();

    @Select("select COUNT(* ) users from tb_user  where is_pass='1'")
    public Map  findUserCount();

    @Select("select COUNT(* ) basicInfors from tb_basic_infor  where registered='是'")
    public Map  findRegisteredCount();

    @Select("select COUNT(* ) registeredIn from  tb_basic_infor bi, tb_user u where bi.tid = u.tid and bi.registered='是' and u.is_out='1' and u.is_pass='1'")
    public Map  findRegisteredInCount();

    @Select("select COUNT(* ) registeredOut  from  tb_basic_infor bi, tb_user u where bi.tid = u.tid and bi.registered='否' and u.is_out='1' and u.is_pass='1'")
    public Map  findRegisteredOutCount();

    @Select("select COUNT(* ) registeredAll from  tb_basic_infor bi, tb_user u where bi.tid = u.tid  and u.is_out='1' and u.is_pass='1'")
    public Map  findRegisteredAllCount();










}
