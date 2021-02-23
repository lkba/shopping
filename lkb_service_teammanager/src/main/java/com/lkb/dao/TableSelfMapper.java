package com.lkb.dao;

import com.lkb.pojo.teammanager.TableSelf;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public interface TableSelfMapper extends Mapper<TableSelf> {

    @Select(" SELECT tts.sid,tts.tid,tts.is_self,tts.is_sub,tbi.team,tbi.project,tu.`name` FROM tb_table_self tts left JOIN tb_basic_infor tbi on tts.tid=tbi.tid  left JOIN tb_user tu on tts.tid=tu.tid   WHERE tts.self_date_id=#{self_date_id}  ORDER BY  tts.sid desc  limit #{page},#{size};")
    public List<Map> findPageSelfList(@Param("self_date_id") String self_date_id, @Param("page") int page, @Param("size") int size) throws UnsupportedEncodingException;

    @Select("SELECT tts.sid,tts.tid,tts.is_self,tts.is_sub,tbi.team,tbi.project,tu.`name`,tu.phone FROM tb_table_self tts left JOIN tb_basic_infor tbi on tts.tid=tbi.tid  left JOIN tb_user tu on tts.tid=tu.tid  ORDER BY  tts.sid desc limit #{page},#{size};")
    public List<Map> findPageSelfListSearch(@Param("page") int page, @Param("size") int size) throws UnsupportedEncodingException;

    @Select("SELECT count(tts.sid) count  FROM tb_table_self tts left JOIN tb_basic_infor tbi on tts.tid=tbi.tid  left JOIN tb_user tu on tts.tid=tu.tid   ORDER BY  tts.sid desc ;")
    public List<Map> findPageSelfCount() throws UnsupportedEncodingException;

    @Delete("DELETE  from tb_table_self where self_date_id=#{self_date_id}")
    public void deleteTableSelfs(@Param("self_date_id") int self_date_id);


}
