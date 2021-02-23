package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.RemarksMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.Remarks;
import com.lkb.service.teammanager.RemarksService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class RemarksServiceImpl implements RemarksService {

    @Autowired
    private RemarksMapper remarksMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Remarks> findAll() {
        return remarksMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Remarks> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Remarks> remarkss = (Page<Remarks>) remarksMapper.selectAll();
        return new PageResult<Remarks>(remarkss.getTotal(),remarkss.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Remarks> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return remarksMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Remarks> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Remarks> remarkss = (Page<Remarks>) remarksMapper.selectByExample(example);
        return new PageResult<Remarks>(remarkss.getTotal(),remarkss.getResult());
    }

    /**
     * 根据Id查询
     * @param rid
     * @return
     */
    public Remarks findById(Integer rid) {
        return remarksMapper.selectByPrimaryKey(rid);
    }

    /**
     * 新增
     * @param remarks
     */
    public void add(Remarks remarks) {
        remarksMapper.insert(remarks);
    }

    /**
     * 修改
     * @param remarks
     */
    public void update(Remarks remarks) {
        remarksMapper.updateByPrimaryKeySelective(remarks);
    }
    public void updatefiles(String key,String val){
        remarksMapper.updatefiles(key,val);
    }
    /**
     *  删除
     * @param rid
     */
    public void delete(Integer rid) {
        remarksMapper.deleteByPrimaryKey(rid);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Remarks.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 入驻团队
            if(searchMap.get("rteam")!=null && !"".equals(searchMap.get("rteam"))){
                criteria.andLike("rteam","%"+searchMap.get("rteam")+"%");
            }
            // 团队总人数
            if(searchMap.get("totleTeam")!=null && !"".equals(searchMap.get("totleTeam"))){
                criteria.andLike("totleTeam","%"+searchMap.get("totleTeam")+"%");
            }
            // 已注册公司
            if(searchMap.get("rcompany")!=null && !"".equals(searchMap.get("rcompany"))){
                criteria.andLike("rcompany","%"+searchMap.get("rcompany")+"%");
            }
            // 两创团队在位情况未注册公司
            if(searchMap.get("noCompany")!=null && !"".equals(searchMap.get("noCompany"))){
                criteria.andLike("noCompany","%"+searchMap.get("noCompany")+"%");
            }
            // 两创团队在位情况已注册公司
            if(searchMap.get("yesCompany")!=null && !"".equals(searchMap.get("yesCompany"))){
                criteria.andLike("yesCompany","%"+searchMap.get("yesCompany")+"%");
            }
            // 两创团队在位情况
            if(searchMap.get("allCompany")!=null && !"".equals(searchMap.get("allCompany"))){
                criteria.andLike("allCompany","%"+searchMap.get("allCompany")+"%");
            }
            // 因项目停止、团队解散等原因而退出
            if(searchMap.get("outTeam1")!=null && !"".equals(searchMap.get("outTeam1"))){
                criteria.andLike("outTeam1","%"+searchMap.get("outTeam1")+"%");
            }
            // 已注册公司外出发展的
            if(searchMap.get("outTeam2")!=null && !"".equals(searchMap.get("outTeam2"))){
                criteria.andLike("outTeam2","%"+searchMap.get("outTeam2")+"%");
            }
            // 其他 
            if(searchMap.get("outTeam3")!=null && !"".equals(searchMap.get("outTeam3"))){
                criteria.andLike("outTeam3","%"+searchMap.get("outTeam3")+"%");
            }
            // 退出情况
            if(searchMap.get("outTeamAll")!=null && !"".equals(searchMap.get("outTeamAll"))){
                criteria.andLike("outTeamAll","%"+searchMap.get("outTeamAll")+"%");
            }
            // 注册公司仍在位
            if(searchMap.get("regCompany1")!=null && !"".equals(searchMap.get("regCompany1"))){
                criteria.andLike("regCompany1","%"+searchMap.get("regCompany1")+"%");
            }
            // 注册公司不在位
            if(searchMap.get("regCompany2")!=null && !"".equals(searchMap.get("regCompany2"))){
                criteria.andLike("regCompany2","%"+searchMap.get("regCompany2")+"%");
            }
            // 注册公司，但项目停止
            if(searchMap.get("regCompany3")!=null && !"".equals(searchMap.get("regCompany3"))){
                criteria.andLike("regCompany3","%"+searchMap.get("regCompany3")+"%");
            }
            // 公司注销
            if(searchMap.get("regCompany4")!=null && !"".equals(searchMap.get("regCompany4"))){
                criteria.andLike("regCompany4","%"+searchMap.get("regCompany4")+"%");
            }
            // 注册公司情况
            if(searchMap.get("regCompanyAll")!=null && !"".equals(searchMap.get("regCompanyAll"))){
                criteria.andLike("regCompanyAll","%"+searchMap.get("regCompanyAll")+"%");
            }
            // 相关专业创业
            if(searchMap.get("proEnt")!=null && !"".equals(searchMap.get("proEnt"))){
                criteria.andLike("proEnt","%"+searchMap.get("proEnt")+"%");
            }
            // 相关专业创业
            if(searchMap.get("soft")!=null && !"".equals(searchMap.get("soft"))){
                criteria.andLike("soft","%"+searchMap.get("soft")+"%");
            }
            // 相关专业创业-相关专业创业
            if(searchMap.get("softPro")!=null && !"".equals(searchMap.get("softPro"))){
                criteria.andLike("softPro","%"+searchMap.get("softPro")+"%");
            }

            // rid
            if(searchMap.get("rid")!=null ){
                criteria.andEqualTo("rid",searchMap.get("rid"));
            }

        }
        return example;
    }

}
