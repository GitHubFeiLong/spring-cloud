package com.goudong.payment.controller;

import com.goudong.module.pojo.Result;
import com.goudong.payment.lib.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

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

    //@Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/demo1")
    public Result demo01(){
        String url = "http://GOUDONG-PAYMENT-SERVER/api/payment/demo1";
        return restTemplate.getForObject(url, Result.class);
    }

    /**
     * getForEntity包含Http响应头响应码等详细信息
     * @return
     */
    @GetMapping("/demo2")
    public Result demo02(){
        String url = "http://GOUDONG-PAYMENT-SERVER/api/payment/demo1";
        ResponseEntity<Result> forEntity = restTemplate.getForEntity(url, Result.class);
        return Result.ofSuccess(forEntity);
    }

    @GetMapping("/demo3")
    public Result<String> get() {
        List<ServiceInstance> instances = discoveryClient.getInstances("GOUDONG-PAYMENT-SERVER");
        if (instances == null || instances.isEmpty()) {
            return null;
        }

        ServiceInstance instance = loadBalancer.instance(instances);
        String uri = instance.getUri().toString();
        return Result.ofSuccess(restTemplate.getForObject(uri + "/api/payment/demo1", String.class));
    }

    /**
     * zipkin
     * @return
     */
    @GetMapping("/demo4")
    public Result demo4 () {
        return restTemplate.getForObject("http://GOUDONG-PAYMENT-SERVER/api/payment/demo3", Result.class);
    }
}
