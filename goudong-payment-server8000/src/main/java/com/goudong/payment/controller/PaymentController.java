package com.goudong.payment.controller;

import com.goudong.module.pojo.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 类描述：
 *
 * @Author msi
 * @Date 2021-04-05 15:20
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/demo1")
    public Result demo1() {
        return Result.ofSuccess(serverPort +" : PaymentController demo1 方法 ");
    }

    @GetMapping("/demo2")
    public Result demo2() {
        int timenum = 2;
        try {
            TimeUnit.SECONDS.sleep(timenum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Result.ofSuccess(serverPort + "线程池：" + Thread.currentThread().getName() + "demo1 耗时 "+timenum+"秒钟");
    }

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/discovery")
    public Result discovery () {
        List<String> services = discoveryClient.getServices();

        List<ServiceInstance> instances = discoveryClient.getInstances("GOUDONG-PAYMENT-SERVER");
        Map<String, Object> map = new HashMap<>();
        map.put("services", services);
        map.put("instances", instances);

        return Result.ofSuccess(map);
    }

    /**
     * 测试feign 超时
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/timeout")
    public Result timeout () throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);

        return Result.ofSuccess();
    }

}
