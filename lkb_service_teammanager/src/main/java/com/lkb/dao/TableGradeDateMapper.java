package com.lkb.dao;

import com.lkb.pojo.teammanager.TableGradeDate;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface TableGradeDateMapper extends Mapper<TableGradeDate> {


    @Select("SELECT * FROM tb_table_grade_date ORDER BY id DESC")
    public List<TableGradeDate> selectAsc();

    @Select("SELECT * FROM tb_table_grade_date ORDER BY id DESC")
    public List<Map> selectAscLM();
}
