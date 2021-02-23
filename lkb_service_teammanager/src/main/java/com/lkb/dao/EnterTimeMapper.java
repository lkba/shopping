package com.lkb.dao;

import com.lkb.pojo.teammanager.EnterTime;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public interface EnterTimeMapper extends Mapper<EnterTime> {

    @Select("SELECT time FROM tb_enter_time")
    public String[] findTimes();

//    @Select("SELECT name,image FROM tb_brand WHERE id IN (SELECT brand_id FROM tb_category_brand WHERE category_id IN(SELECT id FROM tb_category WHERE NAME=#{name}) )order by seq")
//    public List<Map> findListByCategoryName(@Param("name") String categoryName);

}
