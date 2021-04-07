package com.goudong.nacos.controller;

import com.goudong.module.pojo.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author msi
 * @Date 2021-04-07 10:03
 * @Version 1.0
 */
@RefreshScope // 支持nacos的动态刷新功能
@RestController
@RequestMapping("/api/config")
public class NacosController {

    @Value("${config.info}")
    private String info;

    @GetMapping("/info")
    public Result demo1() {

        return Result.ofSuccess(info);
    }
}
