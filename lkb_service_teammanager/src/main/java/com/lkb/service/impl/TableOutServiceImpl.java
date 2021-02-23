package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.BasicInforMapper;
import com.lkb.dao.TableOutMapper;
import com.lkb.dao.UserMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.teammanager.*;
import com.lkb.service.teammanager.TableOutService;
import com.lkb.service.teammanager.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class TableOutServiceImpl implements TableOutService {

    @Autowired
    private TableOutMapper tableOutMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BasicInforMapper basicInforMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<TableOut> findAll() {
        return tableOutMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<TableOut> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<TableOut> tableOuts = (Page<TableOut>) tableOutMapper.selectAll();
        return new PageResult<TableOut>(tableOuts.getTotal(),tableOuts.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<TableOut> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return tableOutMapper.selectByExample(example);
    }




    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */

    public PageResult<TableOut> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<TableOut> tableOuts = (Page<TableOut>) tableOutMapper.selectByExample(example);
        return new PageResult<TableOut>(tableOuts.getTotal(),tableOuts.getResult());
    }

    public List<TableOutUserBasic> findPageUserBaisc(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<TableOut> tableOuts = (Page<TableOut>) tableOutMapper.selectByExample(example);
        System.out.println(tableOuts.toString());
       PageResult<TableOut> tableOutPageResult= new PageResult<TableOut>(tableOuts.getTotal(),tableOuts.getResult());
        PageResult<TableOutUserBasic> tableOutUserBasics=new PageResult<>();
//        tableOutUserBasics.setTotal(tableOuts.getTotal());
        List<TableOutUserBasic> tableOutUserBasicList=new LinkedList<>();
        System.out.println(tableOutPageResult.toString());


        for (int i=0;i<tableOutPageResult.getTotal();i++){
            searchMap.put("tid",tableOutPageResult.getRows().get(i).getTid().toString());
            Example example2 = createExample(searchMap);
            User user=userMapper.selectOneByExample(example2);
            BasicInfor basicInfor=basicInforMapper.selectOneByExample(example2);
            TableOutUserBasic tableOutUserBasic=new TableOutUserBasic();
            tableOutUserBasic.setBasicInfor(basicInfor);
            tableOutUserBasic.setTableOut(tableOutPageResult.getRows().get(i));
            tableOutUserBasic.setUser(user);

            System.out.println(tableOutUserBasic.toString());
//
            tableOutUserBasicList.add(tableOutUserBasic);

        }

//        System.out.println(tableOutUserBasicList.toArray());
//        tableOutUserBasics.setRows(null);
//        tableOutUserBasics.setTotal(tableOutPageResult.getTotal());
        return tableOutUserBasicList;
    }

    /**
     * 根据Id查询
     * @param oid
     * @return
     */
    public TableOut findById(Integer oid) {
        return tableOutMapper.selectByPrimaryKey(oid);
    }

    /**
     * 新增
     * @param tableOut
     */
    public void add(TableOut tableOut) {
        tableOutMapper.insert(tableOut);
    }

    /**
     * 修改
     * @param tableOut
     */
    public void update(TableOut tableOut) {
        tableOutMapper.updateByPrimaryKeySelective(tableOut);
    }

    /**
     *  删除
     * @param oid
     */
    public void delete(Integer oid) {
        tableOutMapper.deleteByPrimaryKey(oid);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(TableOut.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // base_stiu
            if(searchMap.get("baseStiu")!=null && !"".equals(searchMap.get("baseStiu"))){
                criteria.andLike("baseStiu","%"+searchMap.get("baseStiu")+"%");
            }
            // out_reason
            if(searchMap.get("outReason")!=null && !"".equals(searchMap.get("outReason"))){
                criteria.andLike("outReason","%"+searchMap.get("outReason")+"%");
            }
            // idea
            if(searchMap.get("idea")!=null && !"".equals(searchMap.get("idea"))){
                criteria.andLike("idea","%"+searchMap.get("idea")+"%");
            }
            // proposer
            if(searchMap.get("proposer")!=null && !"".equals(searchMap.get("proposer"))){
                criteria.andLike("proposer","%"+searchMap.get("proposer")+"%");
            }
            // workarea
            if(searchMap.get("workarea")!=null && !"".equals(searchMap.get("workarea"))){
                criteria.andLike("workarea","%"+searchMap.get("workarea")+"%");
            }
            // account
            if(searchMap.get("account")!=null && !"".equals(searchMap.get("account"))){
                criteria.andLike("account","%"+searchMap.get("account")+"%");
            }
            // health
            if(searchMap.get("health")!=null && !"".equals(searchMap.get("health"))){
                criteria.andLike("health","%"+searchMap.get("health")+"%");
            }
            // equip
            if(searchMap.get("equip")!=null && !"".equals(searchMap.get("equip"))){
                criteria.andLike("equip","%"+searchMap.get("equip")+"%");
            }
            // admin_idea
            if(searchMap.get("adminIdea")!=null && !"".equals(searchMap.get("adminIdea"))){
                criteria.andLike("adminIdea","%"+searchMap.get("adminIdea")+"%");
            }

            // oid
            if(searchMap.get("oid")!=null ){
                criteria.andEqualTo("oid",searchMap.get("oid"));
            }
            // tid
            if(searchMap.get("tid")!=null ){
                criteria.andEqualTo("tid",searchMap.get("tid"));
            }

        }
        return example;
    }

}
