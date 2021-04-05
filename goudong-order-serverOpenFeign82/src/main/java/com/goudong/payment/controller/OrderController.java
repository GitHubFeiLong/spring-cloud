package com.goudong.payment.controller;

import com.goudong.module.pojo.Result;
import com.goudong.payment.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private PaymentService paymentService;

    @GetMapping("/demo1")
    public Result demo01(){
        return paymentService.demo1();
    }

}
