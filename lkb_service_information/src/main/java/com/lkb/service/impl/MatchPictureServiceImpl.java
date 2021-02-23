package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.MatchPictureMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.information.MatchPicture;
import com.lkb.service.information.MatchPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class MatchPictureServiceImpl implements MatchPictureService {

    @Autowired
    private MatchPictureMapper matchPictureMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<MatchPicture> findAll() {
        return matchPictureMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<MatchPicture> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<MatchPicture> matchPictures = (Page<MatchPicture>) matchPictureMapper.selectAll();
        return new PageResult<MatchPicture>(matchPictures.getTotal(),matchPictures.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<MatchPicture> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return matchPictureMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<MatchPicture> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<MatchPicture> matchPictures = (Page<MatchPicture>) matchPictureMapper.selectByExample(example);
        return new PageResult<MatchPicture>(matchPictures.getTotal(),matchPictures.getResult());
    }

    /**
     * 根据Id查询
     * @param pid
     * @return
     */
    public MatchPicture findById(Integer pid) {
        return matchPictureMapper.selectByPrimaryKey(pid);
    }

    /**
     * 新增
     * @param matchPicture
     */
    public void add(MatchPicture matchPicture) {
        matchPictureMapper.insertSelective(matchPicture);
    }

    /**
     * 修改
     * @param matchPicture
     */
    public void update(MatchPicture matchPicture) {
        matchPictureMapper.updateByPrimaryKeySelective(matchPicture);
    }

    /**
     *  删除
     * @param pid
     */
    public void delete(Integer pid) {

        matchPictureMapper.deleteByExample(pid);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(MatchPicture.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 路径id
            if(searchMap.get("thumb")!=null && !"".equals(searchMap.get("thumb"))){
                criteria.andLike("thumb","%"+searchMap.get("thumb")+"%");
            }
            // 照片描述
            if(searchMap.get("describe")!=null && !"".equals(searchMap.get("describe"))){
                criteria.andLike("describe","%"+searchMap.get("describe")+"%");
            }

            // pid
            if(searchMap.get("pid")!=null ){
                criteria.andEqualTo("pid",searchMap.get("pid"));
            }
            // 赛事的id
            if(searchMap.get("mid")!=null ){
                criteria.andEqualTo("mid",searchMap.get("mid"));
            }

        }
        return example;
    }

}
