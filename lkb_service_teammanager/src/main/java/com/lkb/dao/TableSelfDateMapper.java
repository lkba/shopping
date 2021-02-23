package com.lkb.dao;

import com.lkb.pojo.teammanager.TableGradeDate;
import com.lkb.pojo.teammanager.TableSelfDate;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface TableSelfDateMapper extends Mapper<TableSelfDate> {
    @Select("SELECT * FROM tb_table_self_date ORDER BY id DESC")
    public List<TableSelfDate> selectAsc();

    @Select("SELECT * FROM tb_table_self_date ORDER BY id DESC")
    public List<Map> selectAscLM();
}
