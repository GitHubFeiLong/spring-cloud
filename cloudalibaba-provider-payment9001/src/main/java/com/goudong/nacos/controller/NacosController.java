package com.goudong.nacos.controller;

import com.goudong.module.pojo.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author msi
 * @Date 2021-04-07 10:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/nacos/payment")
public class NacosController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/demo1/{id}")
    public Result demo1(@PathVariable("id")Integer id) {

        return Result.ofSuccess("nacos registry server port :" + port + "\t id:" + id);
    }
}
