package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.NewsManyMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.information.NewsMany;
import com.lkb.service.information.NewsManyService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class NewsManyServiceImpl implements NewsManyService {

    @Autowired
    private NewsManyMapper newsManyMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<NewsMany> findAll() {
        return newsManyMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<NewsMany> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<NewsMany> newsManys = (Page<NewsMany>) newsManyMapper.selectAll();
        return new PageResult<NewsMany>(newsManys.getTotal(),newsManys.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<NewsMany> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return newsManyMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<NewsMany> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<NewsMany> newsManys = (Page<NewsMany>) newsManyMapper.selectByExample(example);
        return new PageResult<NewsMany>(newsManys.getTotal(),newsManys.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public NewsMany findById(Integer id) {
        return newsManyMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param newsMany
     */
    public void add(NewsMany newsMany) {
        newsManyMapper.insert(newsMany);
    }

    /**
     * 修改
     * @param newsMany
     */
    public void update(NewsMany newsMany) {
        newsManyMapper.updateByPrimaryKeySelective(newsMany);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(Integer id) {
        newsManyMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(NewsMany.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // title
            if(searchMap.get("title")!=null && !"".equals(searchMap.get("title"))){
                criteria.andLike("title","%"+searchMap.get("title")+"%");
            }
            // content
            if(searchMap.get("content")!=null && !"".equals(searchMap.get("content"))){
                criteria.andLike("content","%"+searchMap.get("content")+"%");
            }

            // 发信息给多个团队
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }

        }
        return example;
    }

}
