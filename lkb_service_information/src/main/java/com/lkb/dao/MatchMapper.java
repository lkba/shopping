package com.lkb.dao;

import com.lkb.pojo.information.Match;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;


public interface MatchMapper extends Mapper<Match> {

    @Select("SELECT * FROM tb_match  ORDER BY id DESC")
    public List<Match> findMatchDesc();

    @Select("SELECT m.id,m.title,m.host_time,mp.thumb,mp.describes,m.release_time FROM tb_match m, tb_match_picture mp WHERE (m.id=mp.mid and m.is_best='yes') ORDER BY m.release_time desc limit 0,5")
    public List<Map> findMatchOnReleaseTimeDesc();
}
