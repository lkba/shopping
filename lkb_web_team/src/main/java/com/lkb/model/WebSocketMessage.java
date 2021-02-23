package com.lkb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description
 * @Date 2018-05-12
 * @Time 18:50
 */
@AllArgsConstructor
//@NoArgsConstructor
@Data
public class WebSocketMessage {
    private Integer code;
    /**
     * 发送人信息
     */
    private User user;
    /**
     * 接收人 id
     */
    private String receiverId;
    private String time;
    private String message;
    /**
     * 可以存放在线人数，在线用户列表，code等
     */
    private Map<String, Object> body = new HashMap<>();

    public WebSocketMessage(Integer code, String message, String time) {
        this.code = code;
        this.time = time;
        this.message = message;
    }

    public WebSocketMessage(Integer code, String message, User user,
                            String receiverId, String time) {
        this.code = code;
        this.user = user;
        this.receiverId = receiverId;
        this.time = time;
        this.message = message;
    }

    public WebSocketMessage() {

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }
}
