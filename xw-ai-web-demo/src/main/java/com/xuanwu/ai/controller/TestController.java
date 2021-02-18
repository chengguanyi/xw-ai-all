package com.xuanwu.ai.controller;

import com.xuanwu.ai.model.User;
import com.xuanwu.ai.views.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseVo<User> getUser(@Validated @RequestParam("name") String name){

        log.info("name:{}",name);
        User user = new User();
        user.setUserName("chengguanhui");
        user.setPassword("123456");

        return ResponseVo.success(user);
    }

}
