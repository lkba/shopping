package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.EnterTimeMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.EnterTime;
import com.lkb.service.teammanager.EnterTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

@Service
public class EnterTimeServiceImpl implements EnterTimeService {

    @Autowired
    private EnterTimeMapper enterTimeMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<EnterTime> findAll() {
        return enterTimeMapper.selectAll();
    }

    /**
     * 查询期数  ，返回数组
     *
     */
    public String[] findTimes(){
        return enterTimeMapper.findTimes();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<EnterTime> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<EnterTime> enterTimes = (Page<EnterTime>) enterTimeMapper.selectAll();
        return new PageResult<EnterTime>(enterTimes.getTotal(),enterTimes.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<EnterTime> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return enterTimeMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<EnterTime> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<EnterTime> enterTimes = (Page<EnterTime>) enterTimeMapper.selectByExample(example);
        return new PageResult<EnterTime>(enterTimes.getTotal(),enterTimes.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public EnterTime findById(Integer id) {
        return enterTimeMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param enterTime
     */
    public void add(EnterTime enterTime) {
        enterTimeMapper.insert(enterTime);
    }

    /**
     * 修改
     * @param enterTime
     */
    public void update(EnterTime enterTime) {
        enterTimeMapper.updateByPrimaryKeySelective(enterTime);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(Integer id) {
        enterTimeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(EnterTime.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 第几期入驻的团队
            if(searchMap.get("time")!=null && !"".equals(searchMap.get("time"))){
                criteria.andLike("time","%"+searchMap.get("time")+"%");
            }

            // 入驻时间
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }

        }
        return example;
    }

}
