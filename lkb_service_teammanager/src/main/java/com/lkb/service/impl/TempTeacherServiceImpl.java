package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.TempTeacherMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.TempTeacher;
import com.lkb.service.teammanager.TempTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class TempTeacherServiceImpl implements TempTeacherService {

    @Autowired
    private TempTeacherMapper tempTeacherMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<TempTeacher> findAll() {
        return tempTeacherMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<TempTeacher> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<TempTeacher> tempTeachers = (Page<TempTeacher>) tempTeacherMapper.selectAll();
        return new PageResult<TempTeacher>(tempTeachers.getTotal(),tempTeachers.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<TempTeacher> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return tempTeacherMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<TempTeacher> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<TempTeacher> tempTeachers = (Page<TempTeacher>) tempTeacherMapper.selectByExample(example);
        return new PageResult<TempTeacher>(tempTeachers.getTotal(),tempTeachers.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public TempTeacher findById(Integer id) {
        return tempTeacherMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param tempTeacher
     */
    public void add(TempTeacher tempTeacher) {
        tempTeacherMapper.insert(tempTeacher);
    }

    /**
     * 修改
     * @param tempTeacher
     */
    public void update(TempTeacher tempTeacher) {
        tempTeacherMapper.updateByPrimaryKeySelective(tempTeacher);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(Integer id) {
        tempTeacherMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(TempTeacher.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 导师姓名
            if(searchMap.get("tname")!=null && !"".equals(searchMap.get("tname"))){
                criteria.andLike("tname","%"+searchMap.get("tname")+"%");
            }
            // 师导系别
            if(searchMap.get("tdepartment")!=null && !"".equals(searchMap.get("tdepartment"))){
                criteria.andLike("tdepartment","%"+searchMap.get("tdepartment")+"%");
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
            // 临时id
            if(searchMap.get("tpid")!=null ){
                criteria.andEqualTo("tpid",searchMap.get("tpid"));
            }

        }
        return example;
    }

}
