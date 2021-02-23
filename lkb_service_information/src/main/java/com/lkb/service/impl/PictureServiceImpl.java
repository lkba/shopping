package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.PictureMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.information.Picture;
import com.lkb.service.information.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureMapper pictureMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Picture> findAll() {
        return pictureMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Picture> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Picture> pictures = (Page<Picture>) pictureMapper.selectAll();
        return new PageResult<Picture>(pictures.getTotal(),pictures.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Picture> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return pictureMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Picture> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Picture> pictures = (Page<Picture>) pictureMapper.selectByExample(example);
        return new PageResult<Picture>(pictures.getTotal(),pictures.getResult());
    }

    /**
     * 根据Id查询
     * @param nid
     * @return
     */
    public Picture findById(Integer nid) {
        return pictureMapper.selectByPrimaryKey(nid);
    }

    /**
     * 新增
     * @param picture
     */
    public void add(Picture picture) {
        pictureMapper.insert(picture);
    }

    /**
     * 修改
     * @param picture
     */
    public void update(Picture picture) {
        pictureMapper.updateByPrimaryKeySelective(picture);
    }

    /**
     *  删除
     * @param nid
     */
    public void delete(Integer nid) {
        pictureMapper.deleteByPrimaryKey(nid);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Picture.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // title
            if(searchMap.get("title")!=null && !"".equals(searchMap.get("title"))){
                criteria.andLike("title","%"+searchMap.get("title")+"%");
            }
            // url
            if(searchMap.get("url")!=null && !"".equals(searchMap.get("url"))){
                criteria.andLike("url","%"+searchMap.get("url")+"%");
            }
            // 图片的位置
            if(searchMap.get("appendix")!=null && !"".equals(searchMap.get("appendix"))){
                criteria.andLike("appendix","%"+searchMap.get("appendix")+"%");
            }

            // nid
            if(searchMap.get("nid")!=null ){
                criteria.andEqualTo("nid",searchMap.get("nid"));
            }

        }
        return example;
    }

}
