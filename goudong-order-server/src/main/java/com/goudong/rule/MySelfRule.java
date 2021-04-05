package com.goudong.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类描述：
 * 配置ribbon负载均衡规则
 * @Author msi
 * @Date 2021-04-05 20:03
 * @Version 1.0
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule () {
        return new RandomRule();
    }
}
