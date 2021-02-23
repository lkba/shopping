package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.TableSelfMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.TableSelf;
import com.lkb.service.teammanager.TableSelfService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TableSelfServiceImpl implements TableSelfService {

    @Autowired
    private TableSelfMapper tableSelfMapper;

    public Map<String,List<Map>> findPageSelfList(Map<String,Object> searchMap, int page, int size) throws UnsupportedEncodingException {
        Map<String, List<Map>> result = new HashMap<>();
        page = (page - 1) * size;
        if (searchMap != null) {
            if (searchMap.get("self_date_id") != null && !"".equals(searchMap.get("self_date_id"))) {
                result.put("rows", tableSelfMapper.findPageSelfList(searchMap.get("self_date_id").toString(), page, size));
                result.put("total", tableSelfMapper.findPageSelfCount());
            }else {
                result.put("rows", tableSelfMapper.findPageSelfListSearch(page, size));
                result.put("total", tableSelfMapper.findPageSelfCount());
            }
        }

        return result;
    }

    public int getSelfCount(Map<String, Object> searchMap){
        Example example = createExample(searchMap);
        return tableSelfMapper.selectCountByExample(example);
    }  
    public int getSubCount(Map<String, Object> searchMap){
        Example example = createExample(searchMap);
        return tableSelfMapper.selectCountByExample(example);
    }
    /**
     * 返回全部记录
     * @return
     */
    public List<TableSelf> findAll() {
        return tableSelfMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<TableSelf> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<TableSelf> tableSelfs = (Page<TableSelf>) tableSelfMapper.selectAll();
        return new PageResult<TableSelf>(tableSelfs.getTotal(),tableSelfs.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<TableSelf> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return tableSelfMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<TableSelf> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<TableSelf> tableSelfs = (Page<TableSelf>) tableSelfMapper.selectByExample(example);
        return new PageResult<TableSelf>(tableSelfs.getTotal(),tableSelfs.getResult());
    }

    /**
     * 根据Id查询
     * @param sid
     * @return
     */
    public TableSelf findById(Integer sid) {
        return tableSelfMapper.selectByPrimaryKey(sid);
    }

    /**
     * 新增
     * @param tableSelf
     */
    public void add(TableSelf tableSelf) {
        tableSelfMapper.insertSelective(tableSelf);
    }

    /**
     * 修改
     * @param tableSelf
     */
    public void update(TableSelf tableSelf) {
        tableSelfMapper.updateByPrimaryKeySelective(tableSelf);
    }

    /**
     *  删除
     * @param sid
     */
    public void delete(Integer sid) {
        tableSelfMapper.deleteByPrimaryKey(sid);
    }
    public void deleteTableSelfs(Integer self_date_id) {
        tableSelfMapper.deleteTableSelfs(self_date_id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(TableSelf.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // situation
            if(searchMap.get("situation")!=null && !"".equals(searchMap.get("situation"))){
                criteria.andLike("situation","%"+searchMap.get("situation")+"%");
            }
            // progress
            if(searchMap.get("progress")!=null && !"".equals(searchMap.get("progress"))){
                criteria.andLike("progress","%"+searchMap.get("progress")+"%");
            }
            // plan
            if(searchMap.get("plan")!=null && !"".equals(searchMap.get("plan"))){
                criteria.andLike("plan","%"+searchMap.get("plan")+"%");
            }
            // prize
            if(searchMap.get("prize")!=null && !"".equals(searchMap.get("prize"))){
                criteria.andLike("prize","%"+searchMap.get("prize")+"%");
            }
            // admin_idea
            if(searchMap.get("adminIdea")!=null && !"".equals(searchMap.get("adminIdea"))){
                criteria.andLike("adminIdea","%"+searchMap.get("adminIdea")+"%");
            }
            // hatch
            if(searchMap.get("hatch")!=null && !"".equals(searchMap.get("hatch"))){
                criteria.andLike("hatch","%"+searchMap.get("hatch")+"%");
            }
            // department_idea
            if(searchMap.get("departmentIdea")!=null && !"".equals(searchMap.get("departmentIdea"))){
                criteria.andLike("departmentIdea","%"+searchMap.get("departmentIdea")+"%");
            }

            // sid
            if(searchMap.get("sid")!=null ){
                criteria.andEqualTo("sid",searchMap.get("sid"));
            }
            // self_date_id
            if(searchMap.get("selfDateId")!=null ){
                criteria.andEqualTo("selfDateId",searchMap.get("selfDateId"));
            }// self_date_id
            if(searchMap.get("isSelf")!=null ){
                criteria.andEqualTo("isSelf",searchMap.get("isSelf"));
            }
            if(searchMap.get("isSub")!=null ){
                criteria.andEqualTo("isSub",searchMap.get("isSub"));
            }
            // tid
            if(searchMap.get("tid")!=null ){
                criteria.andEqualTo("tid",searchMap.get("tid"));
            }

        }
        return example;
    }

}
