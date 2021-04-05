package com.goudong.payment.service;

import com.goudong.module.pojo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 类描述：
 *
 * @Author msi
 * @Date 2021-04-05 20:49
 * @Version 1.0
 */
@Component
@FeignClient(value = "GOUDONG-PAYMENT-SERVER")
public interface PaymentService {

    @GetMapping("/api/payment/demo1")
    Result demo1();
}
