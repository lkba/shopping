package com.lkb.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.NoticeMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.information.Notice;
import com.lkb.service.information.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Notice> findAll() {
        return noticeMapper.selectAll();
    }

    public List<Map> findNoticeOnReleaseTimeDesc(){
        return noticeMapper.findNoticeOnReleaseTimeDesc();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Notice> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Notice> notices = (Page<Notice>) noticeMapper.selectAll();
        return new PageResult<Notice>(notices.getTotal(),notices.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Notice> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return noticeMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Notice> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Notice> notices = (Page<Notice>) noticeMapper.selectByExample(example);
        return new PageResult<Notice>(notices.getTotal(),notices.getResult());
    }

    /**
     * 根据Id查询
     * @param nid
     * @return
     */
    public Notice findById(Integer nid) {
        return noticeMapper.selectByPrimaryKey(nid);
    }

    /**
     * 新增
     * @param notice
     */
    public void add(Notice notice) {
        noticeMapper.insert(notice);
    }

    /**
     * 修改
     * @param notice
     */
    public void update(Notice notice) {
        noticeMapper.updateByPrimaryKeySelective(notice);
    }

    /**
     *  删除
     * @param nid
     */
    public void delete(Integer nid) {
        noticeMapper.deleteByPrimaryKey(nid);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Notice.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // ntitle
            if(searchMap.get("ntitle")!=null && !"".equals(searchMap.get("ntitle"))){
                criteria.andLike("ntitle","%"+searchMap.get("ntitle")+"%");
            }
            // ncontent
            if(searchMap.get("ncontent")!=null && !"".equals(searchMap.get("ncontent"))){
                criteria.andLike("ncontent","%"+searchMap.get("ncontent")+"%");
            }
            // 附带文件
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
