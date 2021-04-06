package com.goudong.controller;

import com.goudong.module.pojo.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author msi
 * @Date 2021-04-06 16:21
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/config-client")
@RefreshScope // 2.配置刷新能力; 3.然后使用post请求刷新 `curl -X POST "http://localhost:3355/actuator/refresh"`
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("info")
    public Result getInfo () {
        return Result.ofSuccess(configInfo);
    }
}
