package com.goudong.user.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * 类描述：
 * 配置一些bean
 * @Author msi
 * @Date 2021-04-04 22:01
 * @Version 1.0
 */
@Configuration
public class ConfigBean {

    // 新版cloud 会报错 No instances available for XXXX
//    @Bean
////    @LoadBalanced // 客户端开启Ribbon负载均衡的工具
//    public RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }

    @Bean
//    @LoadBalanced // 客户端开启Ribbon负载均衡的工具
    public RestOperations restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
