package com.xuanwu.ai.controller;

import com.xuanwu.ai.model.User;
import com.xuanwu.ai.views.ResponseVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseVo<User> getUser(){

        User user = new User();
        user.setUserName("chengguanhui");
        user.setPassword("123456");

        return ResponseVo.success(user);
    }

}
