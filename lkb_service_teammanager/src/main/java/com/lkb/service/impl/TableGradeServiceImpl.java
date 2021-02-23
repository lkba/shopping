package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.TableGradeMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.TableGrade;
import com.lkb.service.teammanager.TableGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import tk.mybatis.mapper.entity.Example;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TableGradeServiceImpl implements TableGradeService {

    @Autowired
    private TableGradeMapper tableGradeMapper;

    public Map<String,List<Map>> findPageGradeList(Map<String,Object> searchMap, int page, int size) throws UnsupportedEncodingException{
        Map<String, List<Map>> result = new HashMap<>();
        page = (page - 1) * size;
        if (searchMap != null) {
            if (searchMap.get("grade_date_id") != null && !"".equals(searchMap.get("grade_date_id"))) {
                result.put("rows", tableGradeMapper.findPageGradeList(searchMap.get("grade_date_id").toString(), page, size));
                result.put("total", tableGradeMapper.findPageGradeCount());
            }else {
                result.put("rows", tableGradeMapper.findPageGradeListSearch(page, size));
                result.put("total", tableGradeMapper.findPageGradeCount());
            }
        }

        return result;
    }
    /**
     * 返回全部记录
     * @return
     */
    public List<TableGrade> findAll() {
        return tableGradeMapper.selectAll();
    }

    public int getGradeCount(Map<String, Object> searchMap){
        Example example = createExample(searchMap);
        return tableGradeMapper.selectCountByExample(example);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<TableGrade> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<TableGrade> tableGrades = (Page<TableGrade>) tableGradeMapper.selectAll();
        return new PageResult<TableGrade>(tableGrades.getTotal(),tableGrades.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<TableGrade> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return tableGradeMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<TableGrade> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<TableGrade> tableGrades = (Page<TableGrade>) tableGradeMapper.selectByExample(example);
        return new PageResult<TableGrade>(tableGrades.getTotal(),tableGrades.getResult());
    }

    /**
     * 根据Id查询
     * @param gid
     * @return
     */
    public TableGrade findById(Integer gid) {
        return tableGradeMapper.selectByPrimaryKey(gid);
    }

    /**
     * 新增
     * @param tableGrade
     */
    public void add(TableGrade tableGrade) {
//        tableGradeMapper.insert(tableGrade);
        tableGradeMapper.insertSelective(tableGrade);
    }

    /**
     * 修改
     * @param tableGrade
     */
    public void update(TableGrade tableGrade) {
        tableGradeMapper.updateByPrimaryKeySelective(tableGrade);
    }

    /**
     *  删除
     * @param gid
     */
    public void delete(Integer gid) {
        tableGradeMapper.deleteByPrimaryKey(gid);
    }

    public void deleteTableGrades(Integer grade_date_id) {
        tableGradeMapper.deleteTableGrades(grade_date_id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(TableGrade.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // meeting
            if(searchMap.get("meeting")!=null && !"".equals(searchMap.get("meeting"))){
                criteria.andLike("meeting","%"+searchMap.get("meeting")+"%");
            }
            // report
            if(searchMap.get("report")!=null && !"".equals(searchMap.get("report"))){
                criteria.andLike("report","%"+searchMap.get("report")+"%");
            }
            // check
            if(searchMap.get("check")!=null && !"".equals(searchMap.get("check"))){
                criteria.andLike("check","%"+searchMap.get("check")+"%");
            }
            // studio_hea
            if(searchMap.get("studioHea")!=null && !"".equals(searchMap.get("studioHea"))){
                criteria.andLike("studioHea","%"+searchMap.get("studioHea")+"%");
            }
            // public_hea
            if(searchMap.get("publicHea")!=null && !"".equals(searchMap.get("publicHea"))){
                criteria.andLike("publicHea","%"+searchMap.get("publicHea")+"%");
            }
            // propagate
            if(searchMap.get("propagate")!=null && !"".equals(searchMap.get("propagate"))){
                criteria.andLike("propagate","%"+searchMap.get("propagate")+"%");
            }
            // pro_safe
            if(searchMap.get("proSafe")!=null && !"".equals(searchMap.get("proSafe"))){
                criteria.andLike("proSafe","%"+searchMap.get("proSafe")+"%");
            }
            // equip_safe
            if(searchMap.get("equipSafe")!=null && !"".equals(searchMap.get("equipSafe"))){
                criteria.andLike("equipSafe","%"+searchMap.get("equipSafe")+"%");
            }
            // operating
            if(searchMap.get("operating")!=null && !"".equals(searchMap.get("operating"))){
                criteria.andLike("operating","%"+searchMap.get("operating")+"%");
            }
            // culture
            if(searchMap.get("culture")!=null && !"".equals(searchMap.get("culture"))){
                criteria.andLike("culture","%"+searchMap.get("culture")+"%");
            }
            // control
            if(searchMap.get("control")!=null && !"".equals(searchMap.get("control"))){
                criteria.andLike("control","%"+searchMap.get("control")+"%");
            }
            // profit
            if(searchMap.get("profit")!=null && !"".equals(searchMap.get("profit"))){
                criteria.andLike("profit","%"+searchMap.get("profit")+"%");
            }
            // innovate
            if(searchMap.get("innovate")!=null && !"".equals(searchMap.get("innovate"))){
                criteria.andLike("innovate","%"+searchMap.get("innovate")+"%");
            }
            // ent_achi
            if(searchMap.get("entAchi")!=null && !"".equals(searchMap.get("entAchi"))){
                criteria.andLike("entAchi","%"+searchMap.get("entAchi")+"%");
            }
            // ent_opinion
            if(searchMap.get("entOpinion")!=null && !"".equals(searchMap.get("entOpinion"))){
                criteria.andLike("entOpinion","%"+searchMap.get("entOpinion")+"%");
            }
            // mana
            if(searchMap.get("mana")!=null && !"".equals(searchMap.get("mana"))){
                criteria.andLike("mana","%"+searchMap.get("mana")+"%");
            }
            // match
            if(searchMap.get("match")!=null && !"".equals(searchMap.get("match"))){
                criteria.andLike("match","%"+searchMap.get("match")+"%");
            }
            // total_score
            if(searchMap.get("totalScore")!=null && !"".equals(searchMap.get("totalScore"))){
                criteria.andLike("totalScore","%"+searchMap.get("totalScore")+"%");
            }
            // conclusion
            if(searchMap.get("conclusion")!=null && !"".equals(searchMap.get("conclusion"))){
                criteria.andLike("conclusion","%"+searchMap.get("conclusion")+"%");
            }
            // judge
            if(searchMap.get("judge")!=null && !"".equals(searchMap.get("judge"))){
                criteria.andLike("judge","%"+searchMap.get("judge")+"%");
            }

            // gid
            if(searchMap.get("gid")!=null ){
                criteria.andEqualTo("gid",searchMap.get("gid"));
            }
            // 评分分类的id
            if(searchMap.get("gradeDateId")!=null ){
                criteria.andEqualTo("gradeDateId",searchMap.get("gradeDateId"));
            }
            // 评分分类的id
            if(searchMap.get("isGrade")!=null ){
                criteria.andEqualTo("isGrade",searchMap.get("isGrade"));
            }
            // tid
            if(searchMap.get("tid")!=null ){
                criteria.andEqualTo("tid",searchMap.get("tid"));
            }

        }
        return example;
    }

}
