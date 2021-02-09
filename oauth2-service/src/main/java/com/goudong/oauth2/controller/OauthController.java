package com.goudong.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述：
 *
 * @ClassName OauthController
 * @Author msi
 * @Date 2021/2/9 19:24
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/oauth")
public class OauthController {
    @GetMapping("/hello")
    public String hello () {
        return "hello";
    }
}
