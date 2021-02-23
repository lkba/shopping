package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.TeammateMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.Teammate;
import com.lkb.service.teammanager.TeammateService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeammateServiceImpl implements TeammateService {

    @Autowired
    private TeammateMapper teammateMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Teammate> findAll() {
        return teammateMapper.selectAll();
    }

    public Map findCount(){

        Map map=new HashMap();
        map.put("teammate",teammateMapper.findTeammateCount().get("teammates"));
        map.put("user",teammateMapper.findUserCount().get("users"));
        map.put("registered",teammateMapper.findRegisteredCount().get("basicInfors"));
        map.put("registeredIn",teammateMapper.findRegisteredInCount().get("registeredIn"));
        map.put("registeredOut",teammateMapper.findRegisteredOutCount().get("registeredOut"));
        map.put("registeredAll",teammateMapper.findRegisteredAllCount().get("registeredAll"));
        return map;
    }
    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Teammate> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Teammate> teammates = (Page<Teammate>) teammateMapper.selectAll();
        return new PageResult<Teammate>(teammates.getTotal(),teammates.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Teammate> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return teammateMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Teammate> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Teammate> teammates = (Page<Teammate>) teammateMapper.selectByExample(example);
        return new PageResult<Teammate>(teammates.getTotal(),teammates.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public Teammate findById(Integer id) {
        return teammateMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param teammate
     */
    public void add(Teammate teammate) {
        teammateMapper.insert(teammate);
    }

    /**
     * 修改
     * @param teammate
     */
    public void update(Teammate teammate) {
        teammateMapper.updateByPrimaryKeySelective(teammate);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(Integer id) {
        teammateMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Teammate.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
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
            // tid
            if(searchMap.get("tid")!=null && !"".equals(searchMap.get("tid"))){
                criteria.andLike("tid","%"+searchMap.get("tid")+"%");
            }

            // id
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }

        }
        return example;
    }

}
