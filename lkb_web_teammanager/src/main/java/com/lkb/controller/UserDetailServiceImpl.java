package com.lkb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.pojo.system.Admin;
import com.lkb.service.system.AdminService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDetailServiceImpl implements UserDetailsService {


    @Reference
    private AdminService adminService;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("经过了UserDetailServiceImpl");
        System.out.println(s);

        Map map=new HashMap<>();
        map.put("loginName",s);
        map.put("status","1");
        List<Admin> list = adminService.findList(map);
        System.out.println(list.size()+"o");
        if(list.size()==0){
            System.out.println(0);
            System.out.println(list.get(0).getLoginName()+list.get(0).getPassword());
            return null;
        }
        //实际项目中应该从数据库中提取用户的角色列表
        List<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>();
        grantedAuthorities.add( new SimpleGrantedAuthority("ROLE_ADMIN"));
        System.out.println(list.get(0).getPassword());
        return new User(s,list.get(0).getPassword(),grantedAuthorities);
    }
}
