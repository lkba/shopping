package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.UserTempMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.UserTemp;
import com.lkb.service.teammanager.UserTempService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class UserTempServiceImpl implements UserTempService {

    @Autowired
    private UserTempMapper userTempMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<UserTemp> findAll() {
        return userTempMapper.selectAll();
    }



    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<UserTemp> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<UserTemp> userTemps = (Page<UserTemp>) userTempMapper.selectAll();
        return new PageResult<UserTemp>(userTemps.getTotal(),userTemps.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<UserTemp> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return userTempMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<UserTemp> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<UserTemp> userTemps = (Page<UserTemp>) userTempMapper.selectByExample(example);
        return new PageResult<UserTemp>(userTemps.getTotal(),userTemps.getResult());
    }

    /**
     * 根据Id查询
     * @param tid
     * @return
     */
    public UserTemp findById(Integer tid) {
        return userTempMapper.selectByPrimaryKey(tid);
    }

    /**
     * 新增
     * @param userTemp
     */
    public void add(UserTemp userTemp) {
        userTempMapper.insert(userTemp);
    }

    /**
     * 修改
     * @param userTemp
     */
    public void update(UserTemp userTemp) {
        userTempMapper.updateByPrimaryKeySelective(userTemp);
    }

    /**
     *  删除
     * @param tid
     */
    public void delete(Integer tid) {
        userTempMapper.deleteByPrimaryKey(tid);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(UserTemp.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // username
            if(searchMap.get("username")!=null && !"".equals(searchMap.get("username"))){
                criteria.andLike("username","%"+searchMap.get("username")+"%");
            }
            // password
            if(searchMap.get("password")!=null && !"".equals(searchMap.get("password"))){
                criteria.andLike("password","%"+searchMap.get("password")+"%");
            }
            // name
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
            }
            // sex
            if(searchMap.get("sex")!=null && !"".equals(searchMap.get("sex"))){
                criteria.andLike("sex","%"+searchMap.get("sex")+"%");
            }
            // department
            if(searchMap.get("department")!=null && !"".equals(searchMap.get("department"))){
                criteria.andLike("department","%"+searchMap.get("department")+"%");
            }
            // professional
            if(searchMap.get("professional")!=null && !"".equals(searchMap.get("professional"))){
                criteria.andLike("professional","%"+searchMap.get("professional")+"%");
            }
            // phone
            if(searchMap.get("phone")!=null && !"".equals(searchMap.get("phone"))){
                criteria.andLike("phone","%"+searchMap.get("phone")+"%");
            }
            // email
            if(searchMap.get("email")!=null && !"".equals(searchMap.get("email"))){
                criteria.andLike("email","%"+searchMap.get("email")+"%");
            }

            // tid
            if(searchMap.get("tid")!=null ){
                criteria.andEqualTo("tid",searchMap.get("tid"));
            }
            // age
            if(searchMap.get("age")!=null ){
                criteria.andEqualTo("age",searchMap.get("age"));
            }

        }
        return example;
    }

}
