package com.goudong.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 类描述：
 *
 * @Author msi
 * @Date 2021-04-05 15:17
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient // 开启服务发现
public class PaymentApplicationConsul8010 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplicationConsul8010.class, args);
    }
}
