package com.goudong.user.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述：
 *
 * @ClassName UserController
 * @Author msi
 * @Date 2021/2/9 18:11
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/hello")
    public String hello () {
        log.info("haha");
        JSON.toJSONString("hello");
        return "hello world";
    }
}
