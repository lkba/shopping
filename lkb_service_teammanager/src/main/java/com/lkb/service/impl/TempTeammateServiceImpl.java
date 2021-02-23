package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.TempTeammateMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.TempTeammate;
import com.lkb.service.teammanager.TempTeammateService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class TempTeammateServiceImpl implements TempTeammateService {

    @Autowired
    private TempTeammateMapper tempTeammateMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<TempTeammate> findAll() {
        return tempTeammateMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<TempTeammate> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<TempTeammate> tempTeammates = (Page<TempTeammate>) tempTeammateMapper.selectAll();
        return new PageResult<TempTeammate>(tempTeammates.getTotal(),tempTeammates.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<TempTeammate> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return tempTeammateMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<TempTeammate> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<TempTeammate> tempTeammates = (Page<TempTeammate>) tempTeammateMapper.selectByExample(example);
        return new PageResult<TempTeammate>(tempTeammates.getTotal(),tempTeammates.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public TempTeammate findById(Integer id) {
        return tempTeammateMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param tempTeammate
     */
    public void add(TempTeammate tempTeammate) {
        tempTeammateMapper.insert(tempTeammate);
    }

    /**
     * 修改
     * @param tempTeammate
     */
    public void update(TempTeammate tempTeammate) {
        tempTeammateMapper.updateByPrimaryKeySelective(tempTeammate);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(Integer id) {
        tempTeammateMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(TempTeammate.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // dname
            if(searchMap.get("dname")!=null && !"".equals(searchMap.get("dname"))){
                criteria.andLike("dname","%"+searchMap.get("dname")+"%");
            }
            // ddepartment
            if(searchMap.get("ddepartment")!=null && !"".equals(searchMap.get("ddepartment"))){
                criteria.andLike("ddepartment","%"+searchMap.get("ddepartment")+"%");
            }
            // dprofessional
            if(searchMap.get("dprofessional")!=null && !"".equals(searchMap.get("dprofessional"))){
                criteria.andLike("dprofessional","%"+searchMap.get("dprofessional")+"%");
            }
            // dphone
            if(searchMap.get("dphone")!=null && !"".equals(searchMap.get("dphone"))){
                criteria.andLike("dphone","%"+searchMap.get("dphone")+"%");
            }
            // demail
            if(searchMap.get("demail")!=null && !"".equals(searchMap.get("demail"))){
                criteria.andLike("demail","%"+searchMap.get("demail")+"%");
            }
            // tpid
            if(searchMap.get("tpid")!=null && !"".equals(searchMap.get("tpid"))){
                criteria.andLike("tpid","%"+searchMap.get("tpid")+"%");
            }

            // id
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }

        }
        return example;
    }

}
