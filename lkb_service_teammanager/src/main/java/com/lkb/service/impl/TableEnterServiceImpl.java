package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.TableEnterMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.TableEnter;
import com.lkb.service.teammanager.TableEnterService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class TableEnterServiceImpl implements TableEnterService {

    @Autowired
    private TableEnterMapper tableEnterMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<TableEnter> findAll() {
        return tableEnterMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<TableEnter> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<TableEnter> tableEnters = (Page<TableEnter>) tableEnterMapper.selectAll();
        return new PageResult<TableEnter>(tableEnters.getTotal(),tableEnters.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<TableEnter> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return tableEnterMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<TableEnter> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<TableEnter> tableEnters = (Page<TableEnter>) tableEnterMapper.selectByExample(example);
        return new PageResult<TableEnter>(tableEnters.getTotal(),tableEnters.getResult());
    }

    /**
     * 根据Id查询
     * @param eid
     * @return
     */
    public TableEnter findById(Integer eid) {
        return tableEnterMapper.selectByPrimaryKey(eid);
    }

    /**
     * 新增
     * @param tableEnter
     */
    public void add(TableEnter tableEnter) {
        tableEnterMapper.insert(tableEnter);
    }

    /**
     * 修改
     * @param tableEnter
     */
    public void update(TableEnter tableEnter) {
        tableEnterMapper.updateByPrimaryKeySelective(tableEnter);
    }

    /**
     *  删除
     * @param eid
     */
    public void delete(Integer eid) {
        tableEnterMapper.deleteByPrimaryKey(eid);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(TableEnter.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // money
            if(searchMap.get("money")!=null && !"".equals(searchMap.get("money"))){
                criteria.andLike("money","%"+searchMap.get("money")+"%");
            }
            // 第几期入驻
            if(searchMap.get("enterTime")!=null && !"".equals(searchMap.get("enterTime"))){
                criteria.andLike("enterTime","%"+searchMap.get("enterTime")+"%");
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
            // data
            if(searchMap.get("data")!=null && !"".equals(searchMap.get("data"))){
                criteria.andLike("data","%"+searchMap.get("data")+"%");
            }
            // department_idea
            if(searchMap.get("departmentIdea")!=null && !"".equals(searchMap.get("departmentIdea"))){
                criteria.andLike("departmentIdea","%"+searchMap.get("departmentIdea")+"%");
            }

            // eid
            if(searchMap.get("eid")!=null ){
                criteria.andEqualTo("eid",searchMap.get("eid"));
            }
            // persons
            if(searchMap.get("persons")!=null ){
                criteria.andEqualTo("persons",searchMap.get("persons"));
            }
            // tid
            if(searchMap.get("tid")!=null ){
                criteria.andEqualTo("tid",searchMap.get("tid"));
            }

        }
        return example;
    }

}
