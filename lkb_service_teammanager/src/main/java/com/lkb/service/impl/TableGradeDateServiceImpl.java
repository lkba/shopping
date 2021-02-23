package com.lkb.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.TableGradeDateMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.TableGrade;
import com.lkb.pojo.teammanager.TableGradeDate;
import com.lkb.pojo.teammanager.User;
import com.lkb.service.teammanager.TableGradeDateService;
import com.lkb.service.teammanager.TableGradeService;
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
public class TableGradeDateServiceImpl implements TableGradeDateService {

    @Autowired
    private TableGradeDateMapper tableGradeDateMapper;

    /**
     * 返回全部记录
     *
     * @return
     */
    public List<TableGradeDate> findAll() {
        return tableGradeDateMapper.selectAll();
    }

    /**
     * 分页查询
     *
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<TableGradeDate> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<TableGradeDate> tableGradeDates = (Page<TableGradeDate>) tableGradeDateMapper.selectAll();
        return new PageResult<TableGradeDate>(tableGradeDates.getTotal(), tableGradeDates.getResult());
    }

    /**
     * 条件查询
     *
     * @param searchMap 查询条件
     * @return
     */
    public List<TableGradeDate> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return tableGradeDateMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     *
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<TableGradeDate> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page, size);
        Example example = createExample(searchMap);
        Page<TableGradeDate> tableGradeDates = (Page<TableGradeDate>) tableGradeDateMapper.selectByExample(example);
        return new PageResult<TableGradeDate>(tableGradeDates.getTotal(), tableGradeDates.getResult());
    }

    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    public TableGradeDate findById(Integer id) {
        return tableGradeDateMapper.selectByPrimaryKey(id);
    }

    @Autowired
    UserService userService;

    @Autowired
    TableGradeService tableGradeService;

    /**
     * 新增
     *
     * @param tableGradeDate
     */
    public JSON add(String tableGradeDate) throws ParseException {
        JSONObject jsonObjec = new JSONObject();
        String pattern = "\\d{4}(\\-|\\/|.)\\d{1,2}\\1\\d{1,2}";
        //  应收日期 2019/1/1  2019-01-02  2019.02.02  20190909
        boolean isMatchDate1 = Pattern.matches(pattern, tableGradeDate);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    System.out.println(sdf.format(date));
        if (isMatchDate1) {
            List<TableGradeDate> tableGradeDateList = tableGradeDateMapper.selectAll();
            for (TableGradeDate tableGradeDate1 : tableGradeDateList) {
//                System.out.println(sdf.format(  sdf.parse(tableGradeDate)));
                System.out.println(sdf.format(tableGradeDate1.getGradeDate()));

                if (tableGradeDate.equals(sdf.format(tableGradeDate1.getGradeDate()))) {
                    jsonObjec.put("flag", "时间已经存在");
                    return jsonObjec;
                }
            }

//            添加时间
            TableGradeDate tableGradeDateAdd = new TableGradeDate();
            tableGradeDateAdd.setGradeDate(sdf.parse(tableGradeDate));
            tableGradeDateAdd.setTid(0);
            Integer rel = tableGradeDateMapper.insert(tableGradeDateAdd);
            if (rel != 0) {
                //获取最后一个表格
                List<TableGradeDate> TableGradeDateLast = tableGradeDateMapper.selectAsc();

                Map<String, Object> searchMap = new HashMap<>();
                searchMap.put("is_out", "1");
                searchMap.put("is_pass", "1");
                List<User> userList = userService.findList(searchMap);

                //增加评分表格
                for (User user : userList) {
                    TableGrade tableGrade = new TableGrade();
                    tableGrade.setGradeDateId(Integer.valueOf(TableGradeDateLast.get(0).getId().toString()));
                    tableGrade.setTid(user.getTid());
                    tableGrade.setDate(sdf.parse(tableGradeDate));
                    tableGradeService.add(tableGrade);
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
    public JSON addGTab(){
        JSONObject json=new JSONObject();
        //循环出提交情况
//        public List<Map> selectAscLM();
        List<Map> listMap=tableGradeDateMapper.selectAscLM();

//        System.out.println("grade_date"+listMap.get(0).get("grade_date"));
        List<Map> mapList=new LinkedList<>();
        for(Map tableGradeDateMap:listMap){
            Map<String,Object> mapSearch=new HashMap<>();
            Map<String,Object> mapResult=new HashMap<>();
            mapResult.put("grade_date",tableGradeDateMap.get("grade_date"));

            mapResult.put("id",tableGradeDateMap.get("id"));
            mapSearch.put("gradeDateId",tableGradeDateMap.get("id"));

            mapResult.put("grade_date_all",tableGradeService.getGradeCount(mapSearch));
//                tableGradeService.getGradeCount(mapSearch);

            mapSearch.put("isGrade","1");
            mapResult.put("grade_date_1",tableGradeService.getGradeCount(mapSearch));
//                    tableGradeService.getGradeCount(mapSearch);

            mapSearch.put("isGrade","0");
            mapResult.put("grade_date_0",tableGradeService.getGradeCount(mapSearch));
//                    tableGradeService.getGradeCount(mapSearch);

            mapList.add(mapResult);

            json.put("grade_date_result",mapList);
        }
        return json;
    }
    /**
     * 修改
     *
     * @param tableGradeDate
     */
    public void update(TableGradeDate tableGradeDate) {
        tableGradeDateMapper.updateByPrimaryKeySelective(tableGradeDate);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void delete(Integer id) {
        tableGradeDateMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     *
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap) {
        Example example = new Example(TableGradeDate.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null) {

            // 评分表时间分类
            if (searchMap.get("id") != null) {
                criteria.andEqualTo("id", searchMap.get("id"));
            }
            // tid
            if (searchMap.get("tid") != null) {
                criteria.andEqualTo("tid", searchMap.get("tid"));
            }

        }
        return example;
    }

}
