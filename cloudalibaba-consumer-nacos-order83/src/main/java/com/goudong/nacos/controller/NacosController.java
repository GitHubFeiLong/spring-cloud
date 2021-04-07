package com.goudong.nacos.controller;

import com.goudong.module.pojo.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author msi
 * @Date 2021-04-07 10:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/nacos/order")
public class NacosController {

    @Value("${service-url.nacos-user-service}")
    private String server;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/demo1/{id}")
    public Result demo1(@PathVariable("id")Integer id) {
        return restTemplate.getForObject(server+"/api/nacos/payment/demo1/" + id, Result.class);
    }
}
