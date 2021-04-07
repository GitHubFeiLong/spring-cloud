package com.goudong.nacos.service;

import com.goudong.module.pojo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author msi
 * @Date 2021-04-07 15:58
 * @Version 1.0
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentServiceImpl.class)
public interface PaymentService {

    @GetMapping("/demo1/{id}")
    Result demo1(@PathVariable("id")Integer id);
}
