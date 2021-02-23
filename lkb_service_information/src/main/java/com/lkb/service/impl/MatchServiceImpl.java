package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.MatchMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.information.Match;
import com.lkb.service.information.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchMapper matchMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Match> findAll() {
        return matchMapper.selectAll();
    }

    public List<Map> findMatchOnReleaseTimeDesc(){
        return matchMapper.findMatchOnReleaseTimeDesc();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Match> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Match> matchs = (Page<Match>) matchMapper.selectAll();
        return new PageResult<Match>(matchs.getTotal(),matchs.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Match> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return matchMapper.selectByExample(example);
    }
    public Integer findMacthLast() {
        Integer id = matchMapper.findMatchDesc().get(0).getId();
        return id;
    }
    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Match> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Match> matchs = (Page<Match>) matchMapper.selectByExample(example);
        return new PageResult<Match>(matchs.getTotal(),matchs.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public Match findById(Integer id) {
        return matchMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param match
     */
    public void add(Match match) {
        match.setDate(new Date());
        matchMapper.insertSelective(match);
    }

    /**
     * 修改
     * @param match
     */
    public void update(Match match) {
        matchMapper.updateByPrimaryKeySelective(match);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(Integer id) {
        matchMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Match.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // title
            if(searchMap.get("title")!=null && !"".equals(searchMap.get("title"))){
                criteria.andLike("title","%"+searchMap.get("title")+"%");
            }
            // 举办方
            if(searchMap.get("host")!=null && !"".equals(searchMap.get("host"))){
                criteria.andLike("host","%"+searchMap.get("host")+"%");
            }
            // host_time
            if(searchMap.get("hostTime")!=null && !"".equals(searchMap.get("hostTime"))){
                criteria.andLike("hostTime","%"+searchMap.get("hostTime")+"%");
            }
            // host_place
            if(searchMap.get("hostPlace")!=null && !"".equals(searchMap.get("hostPlace"))){
                criteria.andLike("hostPlace","%"+searchMap.get("hostPlace")+"%");
            }
            // 第几届比赛
            if(searchMap.get("period")!=null && !"".equals(searchMap.get("period"))){
                criteria.andLike("period","%"+searchMap.get("period")+"%");
            }
            // content
            if(searchMap.get("content")!=null && !"".equals(searchMap.get("content"))){
                criteria.andLike("content","%"+searchMap.get("content")+"%");
            }
            // 参加团队数量
            if(searchMap.get("peoples")!=null && !"".equals(searchMap.get("peoples"))){
                criteria.andLike("peoples","%"+searchMap.get("peoples")+"%");
            }

            // id
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }
            // 团队id
            if(searchMap.get("tid")!=null ){
                criteria.andEqualTo("tid",searchMap.get("tid"));
            }
            // 分类id
            if(searchMap.get("cid")!=null ){
                criteria.andEqualTo("cid",searchMap.get("cid"));
            }

        }
        return example;
    }

}
