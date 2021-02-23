package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.BasicInforMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.BasicInfor;
import com.lkb.pojo.teammanager.EnterTime;
import com.lkb.service.teammanager.BasicInforService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BasicInforServiceImpl implements BasicInforService {

    @Autowired
    private BasicInforMapper basicInforMapper;


    public JSON updateMoney(Integer tid, String money){
        JSONObject jsonObject=new JSONObject();
System.out.println(tid+":"+money);
        Map<String, Object> searchMap=new HashMap<String, Object>();
        searchMap.put("tid",tid);
        Example example = createExample(searchMap);
        List<BasicInfor> basicInforList=basicInforMapper.selectByExample(example);
//        Example example = createExample(searchMap);
//        return enterTimeMapper.selectByExample(example);

        if (!basicInforList.isEmpty()) {
            basicInforList.get(0).setReMoney(money);
            basicInforMapper.updateByPrimaryKeySelective(basicInforList.get(0));
            jsonObject.put("flag",true);

        }else {
            jsonObject.put("flag", false);
        }


        return jsonObject;
    }


    /**
     * 返回全部记录
     * @return
     */
    public List<BasicInfor> findAll() {
        return basicInforMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<BasicInfor> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<BasicInfor> basicInfors = (Page<BasicInfor>) basicInforMapper.selectAll();
        return new PageResult<BasicInfor>(basicInfors.getTotal(),basicInfors.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<BasicInfor> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return basicInforMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<BasicInfor> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<BasicInfor> basicInfors = (Page<BasicInfor>) basicInforMapper.selectByExample(example);
        return new PageResult<BasicInfor>(basicInfors.getTotal(),basicInfors.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public BasicInfor findById(Integer id) {
        return basicInforMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param basicInfor
     */
    public void add(BasicInfor basicInfor) {
        basicInforMapper.insert(basicInfor);
    }

    /**
     * 修改
     * @param basicInfor
     */
    public void update(BasicInfor basicInfor) {
        basicInforMapper.updateByPrimaryKeySelective(basicInfor);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(Integer id) {
        basicInforMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(BasicInfor.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // logo
            if(searchMap.get("logo")!=null && !"".equals(searchMap.get("logo"))){
                criteria.andLike("logo","%"+searchMap.get("logo")+"%");
            }
            // team
            if(searchMap.get("team")!=null && !"".equals(searchMap.get("team"))){
                criteria.andLike("team","%"+searchMap.get("team")+"%");
            }
            // project
            if(searchMap.get("project")!=null && !"".equals(searchMap.get("project"))){
                criteria.andLike("project","%"+searchMap.get("project")+"%");
            }
            // 教师备注注册金额
            if(searchMap.get("reMoney")!=null && !"".equals(searchMap.get("reMoney"))){
                criteria.andLike("reMoney","%"+searchMap.get("reMoney")+"%");
            }
            // money
            if(searchMap.get("money")!=null && !"".equals(searchMap.get("money"))){
                criteria.andLike("money","%"+searchMap.get("money")+"%");
            }
            // business_scope
            if(searchMap.get("businessScope")!=null && !"".equals(searchMap.get("businessScope"))){
                criteria.andLike("businessScope","%"+searchMap.get("businessScope")+"%");
            }

            // id
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }
            // tid
            if(searchMap.get("tid")!=null ){
                criteria.andEqualTo("tid",searchMap.get("tid"));
            }

        }
        return example;
    }

}
