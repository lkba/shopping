package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.MatchCategoryMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.information.MatchCategory;
import com.lkb.service.information.MatchCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class MatchCategoryServiceImpl implements MatchCategoryService {

    @Autowired
    private MatchCategoryMapper matchCategoryMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<MatchCategory> findAll() {
        return matchCategoryMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<MatchCategory> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<MatchCategory> matchCategorys = (Page<MatchCategory>) matchCategoryMapper.selectAll();
        return new PageResult<MatchCategory>(matchCategorys.getTotal(),matchCategorys.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<MatchCategory> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return matchCategoryMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<MatchCategory> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<MatchCategory> matchCategorys = (Page<MatchCategory>) matchCategoryMapper.selectByExample(example);
        return new PageResult<MatchCategory>(matchCategorys.getTotal(),matchCategorys.getResult());
    }

    /**
     * 根据Id查询
     * @param cid
     * @return
     */
    public MatchCategory findById(Integer cid) {
        return matchCategoryMapper.selectByPrimaryKey(cid);
    }

    /**
     * 新增
     * @param matchCategory
     */
    public void add(MatchCategory matchCategory) {
        matchCategoryMapper.insertSelective(matchCategory);
    }

    /**
     * 修改
     * @param matchCategory
     */
    public void update(MatchCategory matchCategory) {
        matchCategoryMapper.updateByPrimaryKeySelective(matchCategory);
    }

    /**
     *  删除
     * @param cid
     */
    public void delete(Integer cid) {
        matchCategoryMapper.deleteByPrimaryKey(cid);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(MatchCategory.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 分类名称
            if(searchMap.get("cname")!=null && !"".equals(searchMap.get("cname"))){
                criteria.andLike("cname","%"+searchMap.get("cname")+"%");
            }

            // cid
            if(searchMap.get("cid")!=null ){
                criteria.andEqualTo("cid",searchMap.get("cid"));
            }
            // pid
            if(searchMap.get("pid")!=null ){
                criteria.andEqualTo("pid",searchMap.get("pid"));
            }

        }
        return example;
    }

}
