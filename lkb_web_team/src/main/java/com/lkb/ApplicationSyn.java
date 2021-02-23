package com.lkb;

import com.lkb.constant.WebSocketConstant;
import com.lkb.handler.WebSocketChannelHandler;
import com.lkb.service.WebSocketInfoService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 应用启动类
 * @Date 2018-05-07
 * @Time 20:55
 */

//@Component
public class ApplicationSyn   {
//    public static void main(String[] args) {
        //两个线程组
//    @Scheduled(cron = "10,12,16-20 * * * * ?")
//    public void ApplicationTest (){
//        EventLoopGroup bossGroup = new NioEventLoopGroup();
//        EventLoopGroup workGroup = new NioEventLoopGroup();
//        try {
//            ServerBootstrap b = new ServerBootstrap();
//            b.group(bossGroup, workGroup);
//            b.channel(NioServerSocketChannel.class);
//            b.childHandler(new WebSocketChannelHandler());
//            System.out.println("服务端开启等待客户端连接....");
//            Channel ch = b.bind(WebSocketConstant.WEB_SOCKET_PORT).sync().channel();
//
//            //创建一个定长线程池，支持定时及周期性任务执行
//            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
//            WebSocketInfoService webSocketInfoService = new WebSocketInfoService();
//            //定时任务:扫描所有的Channel，关闭失效的Channel
//            executorService.scheduleAtFixedRate(webSocketInfoService::scanNotActiveChannel,
//                    3, 60, TimeUnit.SECONDS);
//
//            //定时任务:向所有客户端发送Ping消息
//            executorService.scheduleAtFixedRate(webSocketInfoService::sendPing,
//                    3, 50, TimeUnit.SECONDS);
//
//            ch.closeFuture().sync();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            //退出程序
//            bossGroup.shutdownGracefully();
//            workGroup.shutdownGracefully();
//        }
//    }

//    }
}
