package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.TableSelfDateMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.*;
import com.lkb.pojo.teammanager.TableSelfDate;
import com.lkb.service.teammanager.TableGradeService;
import com.lkb.service.teammanager.TableSelfDateService;
import com.lkb.service.teammanager.TableSelfService;
import com.lkb.service.teammanager.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class TableSelfDateServiceImpl implements TableSelfDateService {

    @Autowired
    private TableSelfDateMapper tableSelfDateMapper;


    @Autowired
    TableSelfService tableSelfService;
    @Autowired
    UserService userService;

//    @Autowired
//    TableGradeService tableSelfService;
    /**
     * 新增
     *
     * @param tableSelfDate
     */
    public JSON add(String tableSelfDate) throws ParseException {
        JSONObject jsonObjec = new JSONObject();
        String pattern = "\\d{4}(\\-|\\/|.)\\d{1,2}\\1\\d{1,2}";
        //  应收日期 2019/1/1  2019-01-02  2019.02.02  20190909
        boolean isMatchDate1 = Pattern.matches(pattern, tableSelfDate);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    System.out.println(sdf.format(date));
        if (isMatchDate1) {
            List<TableSelfDate> tableSelfDateList = tableSelfDateMapper.selectAll();
            for (TableSelfDate tableSelfDate1 : tableSelfDateList) {
                if (tableSelfDate.equals(sdf.format(tableSelfDate1.getSelfDate()))) {
                    jsonObjec.put("flag", "时间已经存在");
                    return jsonObjec;
                }
            }

//            if (tableGradeDate.equals(sdf.format(tableGradeDate1.getGradeDate()))) {
//                jsonObjec.put("flag", "时间已经存在");
//                return jsonObjec;
//            }

//            添加时间
            TableSelfDate tableSelfDateAdd = new TableSelfDate();
            tableSelfDateAdd.setSelfDate(sdf.parse(tableSelfDate));
            tableSelfDateAdd.setTid(0);
            Integer rel = tableSelfDateMapper.insert(tableSelfDateAdd);
            if (rel != 0) {
                //获取最后一个表格
                List<TableSelfDate> TableSelfDateLast = tableSelfDateMapper.selectAsc();

                Map<String, Object> searchMap = new HashMap<>();
                searchMap.put("is_out", "1");
                searchMap.put("is_pass", "1");
                List<User> userList = userService.findList(searchMap);

                //增加自查表格
                for (User user : userList) {
                    TableSelf tableSelf = new TableSelf();
                    tableSelf.setSelfDateId(Integer.valueOf(TableSelfDateLast.get(0).getId().toString()));
                    tableSelf.setTid(user.getTid());
                    tableSelf.setDate(sdf.parse(tableSelfDate));
                    tableSelfService.add(tableSelf);
                }

                jsonObjec.put("flag","添加成功");
            } else {
                jsonObjec.put("flag", "增加评分表格失败");
            }
        } else {
            jsonObjec.put("flag", "时间格式错误");
        }
        return jsonObjec;
    }
    public JSON addSelfTab(){
        JSONObject json=new JSONObject();
        //循环出提交情况
//        public List<Map> selectAscLM();
        List<Map> listMap=tableSelfDateMapper.selectAscLM();

//        System.out.println("grade_date"+listMap.get(0).get("grade_date"));
        List<Map> mapList=new LinkedList<>();
        for(Map tableSelfDateMap:listMap){
            Map<String,Object> mapSearch=new HashMap<>();
            Map<String,Object> mapResult=new HashMap<>();
            mapResult.put("self_date",tableSelfDateMap.get("self_date"));

            mapResult.put("id",tableSelfDateMap.get("id"));
            mapSearch.put("selfDateId",tableSelfDateMap.get("id"));

            mapResult.put("self_date_all",tableSelfService.getSelfCount(mapSearch));
//                tableSelfService.getGradeCount(mapSearch);

            mapSearch.put("isSelf","1");
            mapResult.put("self_date_1",tableSelfService.getSelfCount(mapSearch));
//                    tableSelfService.getGradeCount(mapSearch);

            mapSearch.put("isSelf","0");
            mapResult.put("self_date_0",tableSelfService.getSelfCount(mapSearch));

            mapSearch.put("isSub","0");
            mapSearch.put("isSelf","1");
            mapResult.put("is_sub",tableSelfService.getSubCount(mapSearch));


//                    tableSelfService.getGradeCount(mapSearch);

            mapList.add(mapResult);

            json.put("self_date_result",mapList);
        }
        return json;
    }
    /**
     * 返回全部记录
     * @return
     */
    public List<TableSelfDate> findAll() {
        return tableSelfDateMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<TableSelfDate> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<TableSelfDate> tableSelfDates = (Page<TableSelfDate>) tableSelfDateMapper.selectAll();
        return new PageResult<TableSelfDate>(tableSelfDates.getTotal(),tableSelfDates.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<TableSelfDate> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return tableSelfDateMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<TableSelfDate> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<TableSelfDate> tableSelfDates = (Page<TableSelfDate>) tableSelfDateMapper.selectByExample(example);
        return new PageResult<TableSelfDate>(tableSelfDates.getTotal(),tableSelfDates.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public TableSelfDate findById(Integer id) {
        return tableSelfDateMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param tableSelfDate
     */
    public void add(TableSelfDate tableSelfDate) {
        tableSelfDateMapper.insert(tableSelfDate);
    }

    /**
     * 修改
     * @param tableSelfDate
     */
    public void update(TableSelfDate tableSelfDate) {
        tableSelfDateMapper.updateByPrimaryKeySelective(tableSelfDate);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(Integer id) {
        tableSelfDateMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(TableSelfDate.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){

            // 评分表时间分类
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }
            // tid
            if(searchMap.get("tid")!=null ){
                criteria.andEqualTo("tid",searchMap.get("tid"));
            }

        }
        return example;
    }

}
