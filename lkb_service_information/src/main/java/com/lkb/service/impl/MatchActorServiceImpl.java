package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.MatchActorMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.information.MatchActor;
import com.lkb.service.information.MatchActorService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class MatchActorServiceImpl implements MatchActorService {

    @Autowired
    private MatchActorMapper matchActorMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<MatchActor> findAll() {
        return matchActorMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<MatchActor> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<MatchActor> matchActors = (Page<MatchActor>) matchActorMapper.selectAll();
        return new PageResult<MatchActor>(matchActors.getTotal(),matchActors.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<MatchActor> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return matchActorMapper.selectByExample(example);
    }
    public Integer findActorCount(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return matchActorMapper.selectCountByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<MatchActor> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<MatchActor> matchActors = (Page<MatchActor>) matchActorMapper.selectByExample(example);
        return new PageResult<MatchActor>(matchActors.getTotal(),matchActors.getResult());
    }

    /**
     * 根据Id查询
     * @param
     * @return
     */
    public MatchActor findById(Integer maId) {
        return matchActorMapper.selectByPrimaryKey(maId);
    }

    /**
     * 新增
     * @param matchActor
     */
    public void add(MatchActor matchActor) {
        matchActorMapper.insert(matchActor);
    }

    /**
     * 修改
     * @param matchActor
     */
    public void update(MatchActor matchActor) {
        matchActorMapper.updateByPrimaryKeySelective(matchActor);
    }

    /**
     *  删除
     * @param
     */
    public void delete(Integer maId) {
        matchActorMapper.deleteByExample(maId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(MatchActor.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 团队名称
            if(searchMap.get("tname")!=null && !"".equals(searchMap.get("tname"))){
                criteria.andLike("tname","%"+searchMap.get("tname")+"%");
            }

            // ma_id
            if(searchMap.get("maId")!=null ){
                criteria.andEqualTo("maId",searchMap.get("maId"));
            }
            // 队团id
            if(searchMap.get("tid")!=null ){
                criteria.andEqualTo("tid",searchMap.get("tid"));
            }
            // 事赛id
            if(searchMap.get("mid")!=null ){
                criteria.andEqualTo("mid",searchMap.get("mid"));
            }

        }
        return example;
    }

}
