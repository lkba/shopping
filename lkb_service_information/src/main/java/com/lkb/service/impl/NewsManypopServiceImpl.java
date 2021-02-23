package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.NewsManypopMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.information.NewsManypop;
import com.lkb.service.information.NewsManypopService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class NewsManypopServiceImpl implements NewsManypopService {

    @Autowired
    private NewsManypopMapper newsManypopMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<NewsManypop> findAll() {
        return newsManypopMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<NewsManypop> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<NewsManypop> newsManypops = (Page<NewsManypop>) newsManypopMapper.selectAll();
        return new PageResult<NewsManypop>(newsManypops.getTotal(),newsManypops.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<NewsManypop> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return newsManypopMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<NewsManypop> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<NewsManypop> newsManypops = (Page<NewsManypop>) newsManypopMapper.selectByExample(example);
        return new PageResult<NewsManypop>(newsManypops.getTotal(),newsManypops.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public NewsManypop findById(Integer id) {
        return newsManypopMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param newsManypop
     */
    public void add(NewsManypop newsManypop) {
        newsManypopMapper.insert(newsManypop);
    }

    /**
     * 修改
     * @param newsManypop
     */
    public void update(NewsManypop newsManypop) {
        newsManypopMapper.updateByPrimaryKeySelective(newsManypop);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(Integer id) {
        newsManypopMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(NewsManypop.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){

            // 发信息给多个团队
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }
            // tid
            if(searchMap.get("tid")!=null ){
                criteria.andEqualTo("tid",searchMap.get("tid"));
            }
            // 新闻id
            if(searchMap.get("nid")!=null ){
                criteria.andEqualTo("nid",searchMap.get("nid"));
            }

        }
        return example;
    }

}
