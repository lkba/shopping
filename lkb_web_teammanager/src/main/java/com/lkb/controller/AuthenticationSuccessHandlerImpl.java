package com.lkb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.pojo.system.LoginLog;
import com.lkb.service.system.LoginLogService;
import com.lkb.util.WebUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    @Reference
    private LoginLogService loginLogService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("登录成功，记录日志");

        String loginName=authentication.getName();
        String ip=request.getRemoteAddr();

        LoginLog loginLog=new LoginLog();
        loginLog.setLoginName(loginName);//管理员名称
        loginLog.setIp(ip);//远程客户IP
        String agent=request.getHeader("user-agent");
        loginLog.setBrowserName(WebUtil.getBrowserName(agent));//浏览器名称
        loginLog.setLoginTime(new Date());//登录时间
        loginLog.setLocation(WebUtil.getCityByIP(ip));//地区

        loginLogService.add(loginLog);
        request.getRequestDispatcher("/main.html").forward(request,response);
    }
}
