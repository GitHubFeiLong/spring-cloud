package com.goudong.nacos.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.goudong.module.pojo.Result;
import com.goudong.nacos.service.PaymentService;
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
    //@SentinelResource(value = "demo1", fallback = "fallback")
//    @SentinelResource(value = "demo1", blockHandler = "blockHandler")
    @SentinelResource(value = "demo1",
            blockHandler = "blockHandler",
            fallback = "fallback",
            exceptionsToIgnore = {IllegalArgumentException.class}
    )
    public Result demo1(@PathVariable("id")Integer id) {
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException 非法参数异常");
        } else if (id==5) {
            throw new NullPointerException("空指针异常");
        }
        return restTemplate.getForObject(server+"/api/nacos/payment/demo1/" + id, Result.class);
    }


    /**
     * 发生异常，回调函数
     * @param id
     * @param throwable
     * @return
     */
    public Result fallback (Integer id, Throwable throwable) {
        return Result.ofFail("fallback方法被调用,id:" + id + ", e:" + throwable.getMessage());
    }

    /**
     * Sentinel 配置的违规
     * @param id
     * @param exception
     * @return
     */
    public Result blockHandler (Integer id, BlockException exception) {
        return Result.ofFail("blockHandler方法被调用,id:" + id + ", e:" + exception.getMessage());
    }


    @Resource
    private PaymentService paymentService;

    @GetMapping("/demo2/{id}")
    public Result demo2(@PathVariable("id")Integer id){
        return paymentService.demo1(id);
    }

}

