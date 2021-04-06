package com.goudong.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 编码配置路由网关
 * @Author msi
 * @Date 2021-04-06 14:53
 * @Version 1.0
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator (RouteLocatorBuilder routeLocatorBuilder) {

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("id",
                r-> r.path("/guonei").uri("http://news.baidu.com/guonei"))
                .build();
        return routes.build();
    }
}
