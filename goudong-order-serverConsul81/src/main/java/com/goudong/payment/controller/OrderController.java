package com.goudong.payment.controller;

import com.goudong.module.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 类描述：
 *
 * @Author msi
 * @Date 2021-04-05 15:20
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/demo1")
    public Result demo01(){
        String url = "http://goudong-payment-consul-server/api/payment/demo1";
        return restTemplate.getForObject(url, Result.class);
    }

}
