package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.TempInfoMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.TempInfo;
import com.lkb.service.teammanager.TempInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class TempInfoServiceImpl implements TempInfoService {

    @Autowired
    private TempInfoMapper tempInfoMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<TempInfo> findAll() {
        return tempInfoMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<TempInfo> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<TempInfo> tempInfos = (Page<TempInfo>) tempInfoMapper.selectAll();
        return new PageResult<TempInfo>(tempInfos.getTotal(),tempInfos.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<TempInfo> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return tempInfoMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<TempInfo> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<TempInfo> tempInfos = (Page<TempInfo>) tempInfoMapper.selectByExample(example);
        return new PageResult<TempInfo>(tempInfos.getTotal(),tempInfos.getResult());
    }

    /**
     * 根据Id查询
     * @param tpid
     * @return
     */
    public TempInfo findById(Integer tpid) {
        return tempInfoMapper.selectByPrimaryKey(tpid);
    }

    /**
     * 新增
     * @param tempInfo
     */
    public void add(TempInfo tempInfo) {
        tempInfoMapper.insert(tempInfo);
    }

    /**
     * 修改
     * @param tempInfo
     */
    public void update(TempInfo tempInfo) {
        tempInfoMapper.updateByPrimaryKeySelective(tempInfo);
    }

    /**
     *  删除
     * @param tpid
     */
    public void delete(Integer tpid) {
        tempInfoMapper.deleteByPrimaryKey(tpid);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(TempInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // team
            if(searchMap.get("team")!=null && !"".equals(searchMap.get("team"))){
                criteria.andLike("team","%"+searchMap.get("team")+"%");
            }
            // project
            if(searchMap.get("project")!=null && !"".equals(searchMap.get("project"))){
                criteria.andLike("project","%"+searchMap.get("project")+"%");
            }
            // money
            if(searchMap.get("money")!=null && !"".equals(searchMap.get("money"))){
                criteria.andLike("money","%"+searchMap.get("money")+"%");
            }
            // business_scope
            if(searchMap.get("businessScope")!=null && !"".equals(searchMap.get("businessScope"))){
                criteria.andLike("businessScope","%"+searchMap.get("businessScope")+"%");
            }
            // name
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
            }
            // department
            if(searchMap.get("department")!=null && !"".equals(searchMap.get("department"))){
                criteria.andLike("department","%"+searchMap.get("department")+"%");
            }
            // professional
            if(searchMap.get("professional")!=null && !"".equals(searchMap.get("professional"))){
                criteria.andLike("professional","%"+searchMap.get("professional")+"%");
            }
            // phone
            if(searchMap.get("phone")!=null && !"".equals(searchMap.get("phone"))){
                criteria.andLike("phone","%"+searchMap.get("phone")+"%");
            }
            // email
            if(searchMap.get("email")!=null && !"".equals(searchMap.get("email"))){
                criteria.andLike("email","%"+searchMap.get("email")+"%");
            }
            // fund
            if(searchMap.get("fund")!=null && !"".equals(searchMap.get("fund"))){
                criteria.andLike("fund","%"+searchMap.get("fund")+"%");
            }
            // form
            if(searchMap.get("form")!=null && !"".equals(searchMap.get("form"))){
                criteria.andLike("form","%"+searchMap.get("form")+"%");
            }
            // thinking
            if(searchMap.get("thinking")!=null && !"".equals(searchMap.get("thinking"))){
                criteria.andLike("thinking","%"+searchMap.get("thinking")+"%");
            }
            // effect
            if(searchMap.get("effect")!=null && !"".equals(searchMap.get("effect"))){
                criteria.andLike("effect","%"+searchMap.get("effect")+"%");
            }
            // abstract
            if(searchMap.get("abstract")!=null && !"".equals(searchMap.get("abstract"))){
                criteria.andLike("abstract","%"+searchMap.get("abstract")+"%");
            }
            // character
            if(searchMap.get("character")!=null && !"".equals(searchMap.get("character"))){
                criteria.andLike("character","%"+searchMap.get("character")+"%");
            }
            // feasibility
            if(searchMap.get("feasibility")!=null && !"".equals(searchMap.get("feasibility"))){
                criteria.andLike("feasibility","%"+searchMap.get("feasibility")+"%");
            }
            // explain
            if(searchMap.get("explain")!=null && !"".equals(searchMap.get("explain"))){
                criteria.andLike("explain","%"+searchMap.get("explain")+"%");
            }
            // prospectus
            if(searchMap.get("prospectus")!=null && !"".equals(searchMap.get("prospectus"))){
                criteria.andLike("prospectus","%"+searchMap.get("prospectus")+"%");
            }

            // tpid
            if(searchMap.get("tpid")!=null ){
                criteria.andEqualTo("tpid",searchMap.get("tpid"));
            }
            // age
            if(searchMap.get("age")!=null ){
                criteria.andEqualTo("age",searchMap.get("age"));
            }
            // persons
            if(searchMap.get("persons")!=null ){
                criteria.andEqualTo("persons",searchMap.get("persons"));
            }

        }
        return example;
    }

}
