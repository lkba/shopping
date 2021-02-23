package com.lkb.dao;

import com.lkb.pojo.teammanager.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UserMapper extends Mapper<User> {

    @Select("select u.username,u.tid,u.name,u.phone,u.time,u.is_out,u.is_pass,b.team,b.project,b.money,b.in_time,b.business_scope,t.persons,t.areawork "+
            "from tb_user as u,tb_basic_infor as b,tb_table_enter as t  "
            +
            "where u.tid=b.tid and  u.tid=t.tid and u.is_out='1' and u.is_sub='1' and u.is_pass<>'1' order by u.tid  desc;")
    public List<Map> AuditedTeamList ();

    @Select("select u.username,u.tid,u.name,u.phone,u.time,u.is_out,b.team,b.project,b.money,b.in_time,b.business_scope,t.persons,t.areawork from tb_user as u,tb_basic_infor as b,tb_table_enter as t  where u.tid=b.tid and  u.tid=t.tid and u.is_out='1' and u.is_sub='1' and u.is_pass='1' and t.areawork=#{areawork} order by u.tid  desc limit #{page},#{size};")
    public List<Map> findTeamToAreawork(@Param("areawork") String areawork,@Param("page") int page,@Param("size") int size);

    @Select("select u.username,u.tid,u.name,u.phone,u.time,u.is_out,b.team,b.project,b.money,b.in_time,b.business_scope,t.persons,t.areawork from tb_user as u,tb_basic_infor as b,tb_table_enter as t  where u.tid=b.tid and  u.tid=t.tid and u.is_out='1' and u.is_sub='1' and u.is_pass='1' and t.areawork=#{areawork} order by u.tid  desc")
    public List<Map> findTeamToAreaworkAll(@Param("areawork") String areawork);

    @Select("select u.username,u.tid,u.name,u.phone,u.time,u.is_out,b.team,b.project,b.money,b.in_time,b.business_scope,t.persons,t.areawork,u.time from tb_user as u,tb_basic_infor as b,tb_table_enter as t where u.tid=b.tid and  u.tid=t.tid and u.is_out='1' and u.is_sub='1' and u.is_pass='1' and u.time=#{time} order by u.tid  desc limit #{page},#{size};;")
    public List<Map> findTeamToTime(@Param("time") String time,@Param("page") int page,@Param("size") int size);

    @Select("select u.username,u.tid,u.name,u.phone,u.time,u.is_out,b.team,b.project,b.money,b.in_time,b.business_scope,t.persons,t.areawork,u.time from tb_user as u,tb_basic_infor as b,tb_table_enter as t where u.tid=b.tid and  u.tid=t.tid and u.is_out='1' and u.is_sub='1' and u.is_pass='1' and u.time=#{time} order by u.tid  desc;")
    public List<Map> findTeamToTimeAll(@Param("time") String time);

    @Select("select u.username,u.tid,u.name,u.phone,u.time,u.is_out,b.team,b.project,b.money,b.in_time,b.business_scope,t.persons,t.areawork from tb_user as u,tb_basic_infor as b,tb_table_enter as t  where u.tid=b.tid and  u.tid=t.tid and u.is_out='1' and u.is_sub='1' and u.is_pass='1' and u.time=#{time} and t.areawork=#{areawork} order by u.tid  desc limit #{page},#{size};;")
    public List<Map> findTeamToTimeAndAreawork(@Param("time") String time,@Param("areawork") String areawork,@Param("page") int page,@Param("size") int size);

    @Select("select u.username,u.tid,u.name,u.phone,u.time,u.is_out,b.team,b.project,b.money,b.in_time,b.business_scope,t.persons,t.areawork from tb_user as u,tb_basic_infor as b,tb_table_enter as t  where u.tid=b.tid and  u.tid=t.tid and u.is_out='1' and u.is_sub='1' and u.is_pass='1' and u.time=#{time} and t.areawork=#{areawork} order by u.tid  desc ;")
    public List<Map> findTeamToTimeAndAreaworkAll(@Param("time") String time,@Param("areawork") String areawork);

    @Select("select u.username,u.tid,u.name,u.phone,u.time,u.is_out,b.team,b.project,b.money,b.re_money,b.in_time,b.business_scope,t.persons,t.areawork from tb_user as u,tb_basic_infor as b,tb_table_enter as t  where u.tid=b.tid and  u.tid=t.tid and u.is_out='1' and u.is_sub='1' and u.is_pass='1' order by u.tid  desc limit #{page},#{size};")
    public List<Map> findTeam(@Param("page") int page,@Param("size") int size);


    @Select("select u.username,u.tid,u.name,u.phone,u.time,u.is_out,b.team,b.project,b.money,b.re_money,b.in_time,b.business_scope,t.persons,t.areawork from tb_user as u,tb_basic_infor as b,tb_table_enter as t  where u.tid=b.tid and  u.tid=t.tid and u.is_out='1' and u.is_sub='1' and u.is_pass='1' order by u.tid  desc;")
    public List<Map> findTeamAll();

    @Select("select u.username,u.tid,u.name,u.phone,u.time,u.is_out,b.team,b.project,b.money,b.in_time,b.business_scope,t.persons,t.areawork from tb_user as u,tb_basic_infor as b,tb_table_enter as t  where u.tid=b.tid and  u.tid=t.tid and u.is_out='0' and u.is_sub='1' and u.is_pass='1' and t.areawork=#{areawork} order by u.tid  desc limit #{page},#{size};")
    public List<Map> findTeamOutToAreawork(@Param("areawork") String areawork,@Param("page") int page,@Param("size") int size);

    @Select("select u.username,u.tid,u.name,u.phone,u.time,u.is_out,b.team,b.project,b.money,b.in_time,b.business_scope,t.persons,t.areawork from tb_user as u,tb_basic_infor as b,tb_table_enter as t  where u.tid=b.tid and  u.tid=t.tid and u.is_out='0' and u.is_sub='1' and u.is_pass='1' and t.areawork=#{areawork} order by u.tid  desc")
    public List<Map> findTeamOutToAreaworkAll(@Param("areawork") String areawork);

    @Select("select u.username,u.tid,u.name,u.phone,u.time,u.is_out,b.team,b.project,b.money,b.in_time,b.business_scope,t.persons,t.areawork,u.time from tb_user as u,tb_basic_infor as b,tb_table_enter as t where u.tid=b.tid and  u.tid=t.tid and u.is_out='0' and u.is_sub='1' and u.is_pass='1' and u.time=#{time} order by u.tid  desc limit #{page},#{size};;")
    public List<Map> findTeamOutToTime(@Param("time") String time,@Param("page") int page,@Param("size") int size);

    @Select("select u.username,u.tid,u.name,u.phone,u.time,u.is_out,b.team,b.project,b.money,b.in_time,b.business_scope,t.persons,t.areawork,u.time from tb_user as u,tb_basic_infor as b,tb_table_enter as t where u.tid=b.tid and  u.tid=t.tid and u.is_out='0' and u.is_sub='1' and u.is_pass='1' and u.time=#{time} order by u.tid  desc;")
    public List<Map> findTeamOutToTimeAll(@Param("time") String time);

    @Select("select u.username,u.tid,u.name,u.phone,u.time,u.is_out,b.team,b.project,b.money,b.in_time,b.business_scope,t.persons,t.areawork from tb_user as u,tb_basic_infor as b,tb_table_enter as t  where u.tid=b.tid and  u.tid=t.tid and u.is_out='0' and u.is_sub='1' and u.is_pass='1' and u.time=#{time} and t.areawork=#{areawork} order by u.tid  desc limit #{page},#{size};;")
    public List<Map> findTeamOutToTimeAndAreawork(@Param("time") String time,@Param("areawork") String areawork,@Param("page") int page,@Param("size") int size);

    @Select("select u.username,u.tid,u.name,u.phone,u.time,u.is_out,b.team,b.project,b.money,b.in_time,b.business_scope,t.persons,t.areawork from tb_user as u,tb_basic_infor as b,tb_table_enter as t  where u.tid=b.tid and  u.tid=t.tid and u.is_out='0' and u.is_sub='1' and u.is_pass='1' and u.time=#{time} and t.areawork=#{areawork} order by u.tid  desc ;")
    public List<Map> findTeamOutToTimeAndAreaworkAll(@Param("time") String time,@Param("areawork") String areawork);

    @Select("select u.username,u.tid,u.name,u.phone,u.time,u.is_out,b.team,b.project,b.money,b.re_money,b.in_time,b.business_scope,t.persons,t.areawork from tb_user as u,tb_basic_infor as b,tb_table_enter as t  where u.tid=b.tid and  u.tid=t.tid and u.is_out='0' and u.is_sub='1' and u.is_pass='1' order by u.tid  desc limit #{page},#{size};")
    public List<Map> findTeamOut(@Param("page") int page,@Param("size") int size);


    @Select("select u.username,u.tid,u.name,u.phone,u.time,u.is_out,b.team,b.project,b.money,b.re_money,b.in_time,b.business_scope,t.persons,t.areawork from tb_user as u,tb_basic_infor as b,tb_table_enter as t  where u.tid=b.tid and  u.tid=t.tid and u.is_out='0' and u.is_sub='1' and u.is_pass='1' order by u.tid  desc;")
    public List<Map> findTeamOutAll();

    @Select("select count(*) from tb_user")
    public int selectTeamCount();

    @Select("select * from tb_user where tid=#{tid}")
    public User findUserById(@Param("tid") int page);


}
