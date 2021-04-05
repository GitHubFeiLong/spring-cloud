package com.goudong.payment.lib;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 接口描述：
 *
 * @Author msi
 * @Date 2021-04-05 20:20
 * @Version 1.0
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
