package com.goudong.comsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author msi
 * @Date 2021-04-06 14:01
 * @Version 1.0
 */
@SpringBootApplication
@EnableHystrixDashboard // 开启hystrix仪表盘
public class HystrixDashboardApplication9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication9001.class, args);
    }

}
