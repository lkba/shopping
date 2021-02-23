package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.BasicInforMapper;
import com.lkb.dao.TeacherMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.Teacher;
import com.lkb.service.teammanager.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private BasicInforMapper basicInforMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Teacher> findAll() {
        return teacherMapper.selectAll();
    }

    /**
     * 返回全部记录
     * @return
     */
    public List<Map> getTeachers(Map<String,Object> searchMap) {
        //得到所有老师名
        List<Map> listTeacherNames=new LinkedList<>();
        if (searchMap.get("name")!=null){
//            System.out.println(searchMap.get("name"));
            listTeacherNames=teacherMapper.getAllTeacherNameONSearch(String.valueOf(searchMap.get("name")));
//            System.out.println(listTeacherNames);
        }else {
            listTeacherNames=teacherMapper.getAllTeacherName();
        }

//        List<Map> lists=new LinkedList<>();

        //教师在的团队
        for(int i=0;i<listTeacherNames.size();i++){
            if (listTeacherNames.get(i).get("name")!=null){
                List<Map> listTid=teacherMapper.getAllTeacherTid(String.valueOf(listTeacherNames.get(i).get("name")));
                for (int y=0;y<listTid.size();y++){
                    if (listTeacherNames.get(i).get("team")!=null){
                        listTeacherNames.get(i).put("team",listTeacherNames.get(i).get("team")+"，"+basicInforMapper.getAllTeamName(String.valueOf(listTid.get(y).get("tid"))).get(0).get("team"));
                    }else {
                        listTeacherNames.get(i).put("team",basicInforMapper.getAllTeamName(String.valueOf(listTid.get(y).get("tid"))).get(0).get("team"));
                    }
                }
            }
        }
        return listTeacherNames;
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Teacher> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Teacher> teachers = (Page<Teacher>) teacherMapper.selectAll();
        return new PageResult<Teacher>(teachers.getTotal(),teachers.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Teacher> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return teacherMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Teacher> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Teacher> teachers = (Page<Teacher>) teacherMapper.selectByExample(example);
        return new PageResult<Teacher>(teachers.getTotal(),teachers.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public Teacher findById(Integer id) {
        return teacherMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param teacher
     */
    public void add(Teacher teacher) {
        teacherMapper.insert(teacher);
    }

    /**
     * 修改
     * @param teacher
     */
    public void update(Teacher teacher) {
        teacherMapper.updateByPrimaryKeySelective(teacher);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(Integer id) {
        teacherMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Teacher.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 导师姓名
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
            }
            // phone
            if(searchMap.get("phone")!=null && !"".equals(searchMap.get("phone"))){
                criteria.andLike("phone","%"+searchMap.get("phone")+"%");
            }
            // 师导系别
            if(searchMap.get("department")!=null && !"".equals(searchMap.get("department"))){
                criteria.andLike("department","%"+searchMap.get("department")+"%");
            }
            // 师导职务
            if(searchMap.get("position")!=null && !"".equals(searchMap.get("position"))){
                criteria.andLike("position","%"+searchMap.get("position")+"%");
            }
            // 责负的领域
            if(searchMap.get("field")!=null && !"".equals(searchMap.get("field"))){
                criteria.andLike("field","%"+searchMap.get("field")+"%");
            }

            // id
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }
            // 团队id
            if(searchMap.get("tid")!=null ){
                criteria.andEqualTo("tid",searchMap.get("tid"));
            }

        }
        return example;
    }

}
