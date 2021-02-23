package com.lkb.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lkb.dao.BasicInforMapper;
import com.lkb.dao.UserMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.*;
import com.lkb.service.teammanager.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import tk.mybatis.mapper.entity.Example;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;


    @Autowired
    EnterTimeService enterTimeService;
    @Autowired
    TeacherService teacherService;

    /**
     * 返回全部记录
     *
     * @return
     */
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    public List<Map> findAuditedTeamList() {
        return userMapper.AuditedTeamList();
    }

    //团队退出
    public JSON reviseTeam(int tid, String val, String fields) {
        JSONObject jsonObject = new JSONObject();
        System.out.println(tid + ":" + val);
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("tid", tid);
        Example example = createExample(searchMap);
        List<User> userList = userMapper.selectByExample(example);
//        Example example = createExample(searchMap);
//        return enterTimeMapper.selectByExample(example);

        if (!userList.isEmpty()) {
            userList.get(0).setIsOut(val);
            userMapper.updateByPrimaryKeySelective(userList.get(0));
            jsonObject.put("flag", true);
            jsonObject.put("val", val);
        } else {
            jsonObject.put("flag", false);
        }


        return jsonObject;
    }

    /**
     * 分页查询
     *
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<User> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<User> users = (Page<User>) userMapper.selectAll();
        return new PageResult<User>(users.getTotal(), users.getResult());
    }

    /**
     * 条件查询
     *
     * @param searchMap 查询条件
     * @return
     */
    public List<User> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return userMapper.selectByExample(example);
    }

    public User findOneUser(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return userMapper.selectOneByExample(example);
    }

    /**
     * 分页+条件查询
     *
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<User> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page, size);
        Example example = createExample(searchMap);
        Page<User> users = (Page<User>) userMapper.selectByExample(example);
        return new PageResult<User>(users.getTotal(), users.getResult());
    }

    public Map<String, List<Map>> findPageTeamList(Map<String, Object> searchMap, int page, int size) throws UnsupportedEncodingException {
        JSONObject jsonObject = new JSONObject();
        if (searchMap.get("time") != null & !"".equals(searchMap.get("time"))) {
            String req_time = (String) searchMap.get("time");
            String time_g = new String(req_time.getBytes("ISO8859-1"), "utf-8");
            searchMap.put("time", time_g);
            redisTemplate.boundHashOps("TeamEnterSearchMap").put("time", searchMap.get("time"));
//            System.out.println("time"+time_g);
        } else {
            redisTemplate.boundHashOps("TeamEnterSearchMap").put("time", "");
        }
        if (searchMap.get("areawork") != null & !"".equals(searchMap.get("areawork"))) {
            String req_areawork = (String) searchMap.get("areawork");
//            System.out.println("req_areawork转换前:"+req_areawork);
            String areawork_g = new String(req_areawork.getBytes("ISO8859-1"), "utf-8");
            searchMap.put("areawork", areawork_g);
            redisTemplate.boundHashOps("TeamEnterSearchMap").put("areawork", searchMap.get("areawork"));

//            System.out.println(areawork_g);
        } else {
            redisTemplate.boundHashOps("TeamEnterSearchMap").put("areawork", "");
        }

        //查询数据范围
        page = (page - 1) * size;

        return createTeamSelectExample(searchMap, page, size);
    }

    public Map<String, List<Map>> findPageTeamOutList(Map<String, Object> searchMap, int page, int size) throws UnsupportedEncodingException {
        JSONObject jsonObject = new JSONObject();
        if (searchMap.get("time") != null & !"".equals(searchMap.get("time"))) {
            String req_time = (String) searchMap.get("time");
            String time_g = new String(req_time.getBytes("ISO8859-1"), "utf-8");
            searchMap.put("time", time_g);
            redisTemplate.boundHashOps("TeamEnterSearchMap").put("time", searchMap.get("time"));
//            System.out.println("time"+time_g);
        } else {
            redisTemplate.boundHashOps("TeamEnterSearchMap").put("time", "");
        }
        if (searchMap.get("areawork") != null & !"".equals(searchMap.get("areawork"))) {
            String req_areawork = (String) searchMap.get("areawork");
//            System.out.println("req_areawork转换前:"+req_areawork);
            String areawork_g = new String(req_areawork.getBytes("ISO8859-1"), "utf-8");
            searchMap.put("areawork", areawork_g);
            redisTemplate.boundHashOps("TeamEnterSearchMap").put("areawork", searchMap.get("areawork"));
//            System.out.println(areawork_g);
        } else {
            redisTemplate.boundHashOps("TeamEnterSearchMap").put("areawork", "");
        }
        //查询数据范围
        page = (page - 1) * size;
        return createTeamOutSelectExample(searchMap, page, size);
    }

    @Autowired
    BasicInforService basicInforService;
    @Autowired
    TableEnterService tableEnterService;
    @Autowired
    TeammateService teammateService;

    public void insertNewTeam(Map mapTeam) throws ParseException {
        int teamCount = userMapper.selectTeamCount();
        List<User> teamAll = userMapper.selectAll();
        //得到最后的一条插入记录
        int lastTid = teamAll.get(teamCount - 1).getTid();
        lastTid = lastTid + 1;
        User user = new User();
        user.setPassword((String) mapTeam.get("password"));
        user.setUsername((String) mapTeam.get("username"));
        user.setName("两创团队");
        user.setSalt("111");
        user.setIsOut("1");
        user.setIsSub("0");
        user.setIsPass("0");

        int result;
        result = userMapper.insert(user);
        System.out.println("返回结果：" + result);

        Integer tid = lastTid;
        System.out.println("计算tid结果：" + tid);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        TableEnter tableEnter = new TableEnter();
        tableEnter.setDate(simpleDateFormat.format(date));
        System.out.println(simpleDateFormat.format(date));
        tableEnter.setTid(Integer.valueOf(tid));
        tableEnter.setDate("2000-01-01");
        tableEnterService.add(tableEnter);
        BasicInfor basicInfor = new BasicInfor();
        basicInfor.setInTime(simpleDateFormat.parse(simpleDateFormat.format(date)));
        basicInfor.setTid(Integer.valueOf(tid));
        basicInforService.add(basicInfor);
    }

    public int insertMTeam(Map mteam) throws ParseException {
        int teamCount = userMapper.selectTeamCount();
        List<User> teamAll = userMapper.selectAll();
        //得到最后的一条插入记录
        int lastTid = teamAll.get(teamCount - 1).getTid();
        String uname = null;
        lastTid = lastTid + 1;
        if (lastTid <= 9) {
            uname = "TD000" + lastTid;
        } else if (teamCount > 9 && teamCount <= 99) {
            uname = "TD00" + lastTid;
        } else if (teamCount > 99 && teamCount <= 999) {
            uname = "TD0" + lastTid;
        } else if (teamCount > 999 && teamCount <= 9999) {
            uname = "TD" + lastTid;
        } else if (teamCount > 9999) {
            uname = "TD" + lastTid;
        }
        String gensalt = BCrypt.gensalt();//创建随机盐
        String Password = BCrypt.hashpw("123456", gensalt);
        User user = new User();
        user.setPassword(Password);
        user.setUsername(uname);
        user.setName("两创团队");
        if (mteam.get("fage") == null || "".equals(mteam.get("fage"))) {
            user.setAge(1);
        } else {
            user.setAge(Integer.parseInt(mteam.get("fage").toString()));
        }
        user.setName((String) mteam.get("fname"));
        user.setSex((String) mteam.get("fsex"));
        user.setDepartment((String) mteam.get("fdepartment"));
        user.setProfessional((String) mteam.get("fprofessional"));
        user.setPhone((String) mteam.get("fphone"));
        user.setEmail((String) mteam.get("femail"));
        user.setSalt("111");
        user.setIsOut("0");
        user.setIsSub("1");
        user.setIsPass("1");
        user.setTime((String) mteam.get("time"));

        int result;
        result = userMapper.insert(user);
        System.out.println("返回结果：" + result);

        Integer tid = lastTid;
        System.out.println("计算tid结果：" + tid);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");

        TableEnter tableEnter = new TableEnter();
        tableEnter.setDate(simpleDateFormat.format(date));
        tableEnter.setTid(Integer.valueOf(tid));
        tableEnter.setMoney((String) mteam.get("money"));
        tableEnter.setAreawork((String) mteam.get("areawork"));
        tableEnter.setEnterTime(simpleDateFormat.format(date));
        if (mteam.get("persons") != null) {
            tableEnter.setPersons(Integer.valueOf(mteam.get("persons").toString()));
        } else {
            tableEnter.setPersons(0);
        }

        tableEnter.setForm((String) mteam.get("form"));
        tableEnter.setThinking((String) mteam.get("thinking"));
        tableEnter.setEffect((String) mteam.get("effect"));
        tableEnter.setAbstracts((String) mteam.get("abstract"));
        tableEnter.setCharacters((String) mteam.get("character"));
        tableEnter.setFeasibility((String) mteam.get("feasibility"));
        tableEnter.setExplains((String) mteam.get("explain"));
        tableEnter.setProspectus((String) mteam.get("prospectus"));
        if ((String) mteam.get("date") == null) {
            tableEnter.setDate("2000-01-01");
        } else {
            tableEnter.setDate((String) mteam.get("date"));
        }
        tableEnterService.add(tableEnter);

        BasicInfor basicInfor = new BasicInfor();
        basicInfor.setInTime(simpleDateFormat.parse(simpleDateFormat.format(date)));
        basicInfor.setTid(Integer.valueOf(tid));
        basicInfor.setTeam((String) mteam.get("team"));
        basicInfor.setProject((String) mteam.get("project"));
        basicInfor.setInTime(simpleDateFormat.parse(simpleDateFormat.format(date)));
        basicInfor.setRegistered((String) mteam.get("registered"));
        basicInfor.setRegTime((String) mteam.get("date"));
        basicInfor.setMoney((String) mteam.get("money"));
        basicInfor.setBusinessScope((String) mteam.get("business_scope"));
        basicInfor.setClass_por((String) mteam.get("class_por"));
        basicInfor.setProperty((String) mteam.get("property"));
        basicInforService.add(basicInfor);
//        List teams= (List) mteam.get("teams");
        //修改队友信息
        for (Map team : (List<Map>) mteam.get("teams")) {
            System.out.println("tname" + !"".equals(team.get("tname"))+team.get("tname") != null);
            if (team.get("tname") != null && !"".equals(team.get("tname"))) {
                Teammate teammate = new Teammate();
                teammate.setSex((String) team.get("tsex"));
                teammate.setName((String) team.get("tname"));
                teammate.setPhone((String) team.get("tphone"));
                teammate.setDepartment((String) team.get("tdepartment"));
                teammate.setProfessional((String) team.get("tprofessional"));
                teammate.setEmail((String) team.get("temail"));
                teammate.setTid(tid.toString());
                System.out.println("1:"+team.get("mateid").toString() );
                System.out.println("2:"+"add".equals(team.get("mateid").toString()));
                if ("add".equals(team.get("mateid").toString())) {
                    teammateService.add(teammate);
                } else {
                    teammate.setId(Integer.valueOf(team.get("mateid").toString()));
                    teammateService.update(teammate);
                }
            }
        }

        //修改教师信息
        for (Map teacherObj : (List<Map>) mteam.get("teacher")) {
            System.out.println("name" + "".equals(teacherObj.get("name")));
            if (teacherObj.get("name") != null && !"".equals(teacherObj.get("name"))) {
                Teacher teacher = new Teacher();
                teacher.setName((String) teacherObj.get("name"));
                teacher.setDepartment((String) teacherObj.get("department"));
                teacher.setField((String) teacherObj.get("field"));
                teacher.setPosition((String) teacherObj.get("position"));
                teacher.setTid(tid);
                if ("add".equals(teacherObj.get("id").toString())) {
                    teacherService.add(teacher);
                } else  {
                    teacher.setId((Integer) teacherObj.get("id"));
                    teacherService.update(teacher);
                }
            }
        }
        return Integer.valueOf(tid);
    }


    public JSON input_team(Map mteam) throws ParseException {
        JSONObject jsonObject = new JSONObject();
        if (!mteam.isEmpty()) {

            int tid = insertMTeam(mteam);
//            添加时间
            String[] times = enterTimeService.findTimes();
            List<String> list = Arrays.asList(times);
            boolean result = list.contains(mteam.get("time"));
            if (!result) {
                EnterTime enterTime = new EnterTime();
                enterTime.setTime((String) mteam.get("time"));
                enterTimeService.add(enterTime);
            }
//            上传文件


            jsonObject.put("flag", true);

        } else {
            jsonObject.put("flag", false);
        }

        return jsonObject;

    }

    public Map getTeamCache() {
        Map map = new HashMap();
        map.put("time", redisTemplate.boundHashOps("TeamEnterSearchMap").get("time"));
        map.put("areawork", redisTemplate.boundHashOps("TeamEnterSearchMap").get("areawork"));
        return map;
    }


    public List<Map> findTeamAll() {
        return userMapper.findTeamAll();
    }

    /**
     * 根据Id查询
     *
     * @param tid
     * @return
     */
    public User findById(Integer tid) {
        return userMapper.selectByPrimaryKey(tid);
    }
    public User findUserById(int tid) {
        System.out.println("tid:"+tid);
        return userMapper.findUserById(tid);
    }

    /**
     * 新增
     *
     * @param user
     */
    public void add(User user) {
        userMapper.insert(user);
    }

    /**
     * 修改
     *
     * @param user
     */


    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 删除
     *
     * @param tid
     */
    public void delete(Integer tid) {
        userMapper.deleteByPrimaryKey(tid);
    }

    private Map<String, List<Map>> createTeamSelectExample(Map<String, Object> searchMap, int page, int size) {
//        String example;?
        Map<String, List<Map>> result = new HashMap<>();
        if (searchMap != null) {
            // 只有areawork条件
            if (searchMap.get("areawork") != null && !"".equals(searchMap.get("areawork")) && searchMap.get("time") == null && "".equals(searchMap.get("time"))) {
                result.put("rows", userMapper.findTeamToAreawork(searchMap.get("areawork").toString(), page, size));
                result.put("total", userMapper.findTeamToAreaworkAll(searchMap.get("areawork").toString()));
            }
            // time
            else if (searchMap.get("areawork") == null && "".equals(searchMap.get("areawork")) && searchMap.get("time") != null && !"".equals(searchMap.get("time"))) {
                result.put("rows", userMapper.findTeamToTime(searchMap.get("time").toString(), page, size));
                result.put("total", userMapper.findTeamToTimeAll(searchMap.get("time").toString()));
            }
            // time  and areawork
            else if (searchMap.get("areawork") != null && !"".equals(searchMap.get("areawork")) && searchMap.get("time") != null && !"".equals(searchMap.get("time"))) {
                result.put("rows", userMapper.findTeamToTimeAndAreawork(searchMap.get("time").toString(), searchMap.get("areawork").toString(), page, size));
                result.put("total", userMapper.findTeamToTimeAndAreaworkAll(searchMap.get("time").toString(), searchMap.get("areawork").toString()));
            }
            // time=null  and areawork=null
            else if (searchMap.get("areawork") == null && "".equals(searchMap.get("areawork")) && searchMap.get("time") == null && "".equals(searchMap.get("time"))) {
                result.put("rows", userMapper.findTeam(page, size));
                result.put("total", userMapper.findTeamAll());
            } else {
                result.put("rows", userMapper.findTeam(page, size));
                result.put("total", userMapper.findTeamAll());
            }
        }
        return result;
    }

    private Map<String, List<Map>> createTeamOutSelectExample(Map<String, Object> searchMap, int page, int size) {
//        String example;?
        Map<String, List<Map>> result = new HashMap<>();
        if (searchMap != null) {
            // 只有areawork条件
            if (searchMap.get("areawork") != null && !"".equals(searchMap.get("areawork")) && searchMap.get("time") == null && "".equals(searchMap.get("time"))) {
                result.put("rows", userMapper.findTeamOutToAreawork(searchMap.get("areawork").toString(), page, size));
                result.put("total", userMapper.findTeamOutToAreaworkAll(searchMap.get("areawork").toString()));
            }
            // time
            else if (searchMap.get("areawork") == null && "".equals(searchMap.get("areawork")) && searchMap.get("time") != null && !"".equals(searchMap.get("time"))) {
                result.put("rows", userMapper.findTeamOutToTime(searchMap.get("time").toString(), page, size));
                result.put("total", userMapper.findTeamOutToTimeAll(searchMap.get("time").toString()));
            }
            // time  and areawork
            else if (searchMap.get("areawork") != null && !"".equals(searchMap.get("areawork")) && searchMap.get("time") != null && !"".equals(searchMap.get("time"))) {
                result.put("rows", userMapper.findTeamOutToTimeAndAreawork(searchMap.get("time").toString(), searchMap.get("areawork").toString(), page, size));
                result.put("total", userMapper.findTeamOutToTimeAndAreaworkAll(searchMap.get("time").toString(), searchMap.get("areawork").toString()));
            }
            // time=null  and areawork=null
            else if (searchMap.get("areawork") == null && "".equals(searchMap.get("areawork")) && searchMap.get("time") == null && "".equals(searchMap.get("time"))) {
                result.put("rows", userMapper.findTeamOut(page, size));
                result.put("total", userMapper.findTeamOutAll());
            } else {
                result.put("rows", userMapper.findTeamOut(page, size));
                result.put("total", userMapper.findTeamOutAll());
            }
        }
        return result;
    }

    /**
     * 构建查询条件
     *
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null) {
            // username
            if (searchMap.get("username") != null && !"".equals(searchMap.get("username"))) {
                criteria.andLike("username", "%" + searchMap.get("username") + "%");
            }
            // password
            if (searchMap.get("password") != null && !"".equals(searchMap.get("password"))) {
                criteria.andLike("password", "%" + searchMap.get("password") + "%");
            }
            // name
            if (searchMap.get("name") != null && !"".equals(searchMap.get("name"))) {
                criteria.andLike("name", "%" + searchMap.get("name") + "%");
            }
            // department
            if (searchMap.get("department") != null && !"".equals(searchMap.get("department"))) {
                criteria.andLike("department", "%" + searchMap.get("department") + "%");
            }
            // professional
            if (searchMap.get("professional") != null && !"".equals(searchMap.get("professional"))) {
                criteria.andLike("professional", "%" + searchMap.get("professional") + "%");
            }
            // phone
            if (searchMap.get("phone") != null && !"".equals(searchMap.get("phone"))) {
                criteria.andLike("phone", "%" + searchMap.get("phone") + "%");
            }
            // email
            if (searchMap.get("email") != null && !"".equals(searchMap.get("email"))) {
                criteria.andLike("email", "%" + searchMap.get("email") + "%");
            }
            // 团队第几期入驻
            if (searchMap.get("time") != null && !"".equals(searchMap.get("time"))) {
                criteria.andLike("time", "%" + searchMap.get("time") + "%");
            }
            // 密加
            if (searchMap.get("salt") != null && !"".equals(searchMap.get("salt"))) {
                criteria.andLike("salt", "%" + searchMap.get("salt") + "%");
            }

            // tid
            if (searchMap.get("tid") != null) {
                criteria.andEqualTo("tid", searchMap.get("tid"));
            }
            // age
            if (searchMap.get("age") != null) {
                criteria.andEqualTo("age", searchMap.get("age"));
            }

        }
        return example;
    }

}
