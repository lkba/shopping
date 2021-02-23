package com.lkb.controller.information;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.lkb.entity.PageResult;
import com.lkb.entity.Result;
import com.lkb.pojo.information.News;
import com.lkb.pojo.teammanager.User;
import com.lkb.service.information.NewsService;
import com.lkb.service.teammanager.UserService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Reference
    private NewsService newsService;

    @Reference
    private UserService userService;

    @GetMapping("/findAll")
    public List<News> findAll(){
        return newsService.findAll();
    }

    @PostMapping("/addNews")
    public Result  addNews(@RequestParam("content") String content,@RequestParam(value="checkList[]",required=true) List checkList) throws ParseException {
        JSONObject jsonObject = new JSONObject();
//        System.out.println("content:"+content+"   checkList:"+checkList);
//        newsService.addNews(content,checkList);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd");
        Date date=new Date();
        System.out.println("addNews"+checkList.size());
        if (checkList.size() != 0) {
            for (int i=0;i<checkList.size();i++) {
                System.out.println("addNews"+checkList.get(i));
                System.out.println(i+":"+Integer.valueOf(checkList.get(i).toString()));
                if (Integer.valueOf(checkList.get(i).toString())!=null||Integer.valueOf(checkList.get(i).toString())!=0){
                    Map<String,Object> map=new HashMap<>();
//                    map.put("tid",Integer.valueOf(list.get(i).toString()));
                    User user=userService.findById(Integer.valueOf(checkList.get(i).toString()));
                    System.out.println("user:"+user);
                    News news = new News();
                    news.setContent(content);
                    news.setTid(Integer.valueOf(checkList.get(i).toString()));
                    news.setIsRead("1");
                    news.setTeamName(user.getName());
                    news.setDate(simpleDateFormat.parse(simpleDateFormat.format(date)));
                    news.setType("2");
//                    newsMapper.insert(news);
//                    add(news);
                    newsService.add(news);
                }

            }
            jsonObject.put("flag",true );
        } else {
            jsonObject.put("flag",false );
        }
        return  new Result();
    }
    @GetMapping("/findPage")
    public PageResult<News> findPage(int page, int size){
        return newsService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<News> findList(@RequestBody Map<String,Object> searchMap){
        return newsService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<News> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  newsService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public News findById(Integer id){
        return newsService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody News news){
        newsService.add(news);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody News news){
        newsService.update(news);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer id){
        newsService.delete(id);
        return new Result();
    }

}
