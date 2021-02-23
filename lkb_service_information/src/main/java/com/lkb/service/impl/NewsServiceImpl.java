package com.lkb.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkb.dao.NewsMapper;
import com.lkb.entity.PageResult;
import com.lkb.pojo.information.News;
import com.lkb.pojo.teammanager.User;
import com.lkb.service.information.NewsService;
import com.lkb.service.teammanager.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    /**
     * 返回全部记录
     *
     * @return
     */
    public List<News> findAll() {
        return newsMapper.selectAll();
    }

    @Reference
    private UserService userService;

    public JSON addNews(String content, List list) throws ParseException {
        JSONObject jsonObject = new JSONObject();
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd");
//        Date date=new Date();
//        System.out.println("addNews"+list.size());
//        if (list.size() != 0) {
//            for (int i=0;i<list.size();i++) {
//                System.out.println("addNews"+list.get(i));
//                System.out.println(i+":"+Integer.valueOf(list.get(i).toString()));
//                if (Integer.valueOf(list.get(i).toString())!=null||Integer.valueOf(list.get(i).toString())!=0){
//                    Map<String,Object> map=new HashMap<>();
////                    map.put("tid",Integer.valueOf(list.get(i).toString()));
//                    User user=userService.findById(Integer.valueOf(list.get(i).toString()));
//                    System.out.println("user:"+user);
//                    News news = new News();
//                    news.setContent(content);
//                    news.setTid(Integer.valueOf(list.get(i).toString()));
//                    news.setIsRead("1");
//                    news.setTeamName(user.getName());
//                    news.setDate(simpleDateFormat.parse(simpleDateFormat.format(date)));
//                    news.setType("2");
//                    newsMapper.insert(news);
//                }
//
//            }
//            jsonObject.put("flag",true );
//        } else {
//            jsonObject.put("flag",false );
//        }
        return jsonObject;
    }

    /**
     * 分页查询
     *
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<News> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<News> newss = (Page<News>) newsMapper.selectAll();
        return new PageResult<News>(newss.getTotal(), newss.getResult());
    }

    /**
     * 条件查询
     *
     * @param searchMap 查询条件
     * @return
     */
    public List<News> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return newsMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     *
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<News> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page, size);
        Example example = createExample(searchMap);
        Page<News> newss = (Page<News>) newsMapper.selectByExample(example);
        return new PageResult<News>(newss.getTotal(), newss.getResult());
    }

    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    public News findById(Integer id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     *
     * @param news
     */
    public void add(News news) {
        newsMapper.insert(news);
    }

    /**
     * 修改
     *
     * @param news
     */
    public void update(News news) {
        newsMapper.updateByPrimaryKeySelective(news);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void delete(Integer id) {
        newsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     *
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap) {
        Example example = new Example(News.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null) {
            // title
            if (searchMap.get("title") != null && !"".equals(searchMap.get("title"))) {
                criteria.andLike("title", "%" + searchMap.get("title") + "%");
            }
            // content
            if (searchMap.get("content") != null && !"".equals(searchMap.get("content"))) {
                criteria.andLike("content", "%" + searchMap.get("content") + "%");
            }
            // team_name
            if (searchMap.get("teamName") != null && !"".equals(searchMap.get("teamName"))) {
                criteria.andLike("teamName", "%" + searchMap.get("teamName") + "%");
            }

            // id
            if (searchMap.get("id") != null) {
                criteria.andEqualTo("id", searchMap.get("id"));
            }
            // tid
            if (searchMap.get("tid") != null) {
                criteria.andEqualTo("tid", searchMap.get("tid"));
            }

        }
        return example;
    }

}
