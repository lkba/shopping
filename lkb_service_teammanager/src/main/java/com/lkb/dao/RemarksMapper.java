package com.lkb.dao;

import com.lkb.pojo.teammanager.Remarks;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface RemarksMapper extends Mapper<Remarks> {

    @Update("UPDATE tb_remarks set  ${key}=#{val} ")
    public void updatefiles(@Param("key") String key,@Param("val") String val);
}
