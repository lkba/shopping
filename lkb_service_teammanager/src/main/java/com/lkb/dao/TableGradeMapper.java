package com.lkb.dao;

import com.lkb.pojo.teammanager.TableGrade;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import tk.mybatis.mapper.common.Mapper;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public interface TableGradeMapper extends Mapper<TableGrade> {


    @Select("SELECT ttg.gid,tbi.team,tbi.project,tu.`name` FROM tb_table_grade ttg left JOIN tb_basic_infor tbi on ttg.tid=tbi.tid  left JOIN tb_user tu on ttg.tid=tu.tid   WHERE ttg.grade_date_id=#{grade_date_id}  ORDER BY  ttg.gid desc  limit #{page},#{size};")
    public List<Map> findPageGradeList(@Param("grade_date_id") String grade_date_id, @Param("page") int page, @Param("size") int size) throws UnsupportedEncodingException;

    @Select("SELECT ttg.gid,ttg.is_grade,tbi.team,tbi.project,tu.`name`,tu.phone FROM tb_table_grade ttg left JOIN tb_basic_infor tbi on ttg.tid=tbi.tid  left JOIN tb_user tu on ttg.tid=tu.tid  ORDER BY  ttg.gid desc  limit #{page},#{size};")
    public List<Map> findPageGradeListSearch(@Param("page") int page, @Param("size") int size) throws UnsupportedEncodingException;

    @Select("SELECT count(ttg.gid) count  FROM tb_table_grade ttg left JOIN tb_basic_infor tbi on ttg.tid=tbi.tid  left JOIN tb_user tu on ttg.tid=tu.tid   ORDER BY  ttg.gid desc ;")
    public List<Map> findPageGradeCount() throws UnsupportedEncodingException;

    @Delete("DELETE  from tb_table_grade where grade_date_id=#{grade_date_id}")
    public void deleteTableGrades(@Param("grade_date_id") int grade_date_id);
}
