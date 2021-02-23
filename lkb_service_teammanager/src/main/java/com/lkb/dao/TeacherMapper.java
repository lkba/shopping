package com.lkb.dao;

import com.lkb.pojo.teammanager.Teacher;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface TeacherMapper extends Mapper<Teacher> {

    @Select("select * from tb_teacher GROUP BY name")
    public List<Map> getAllTeacherName();
//    @Select("select * from tb_teacher  where name=#{name} GROUP BY name")

    @Select("select * from tb_teacher  where name like CONCAT('%',#{name},'%') GROUP BY name")
    public List<Map> getAllTeacherNameONSearch(@Param("name") String name);

    @Select("select tid from tb_teacher where name= #{name}")
    public  List<Map> getAllTeacherTid(@Param("name") String name);

    @Select("select * from tb_teacher where name= #{name}")
    public List<Map> getTeacher(@Param("name") String name);

}
