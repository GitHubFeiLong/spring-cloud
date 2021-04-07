package com.goudong.payment.controller;

import com.goudong.module.pojo.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 测试zipkin
     * @return
     */
    @GetMapping("/demo3")
    public Result demo3 () {
        return Result.ofSuccess();
    }

}
