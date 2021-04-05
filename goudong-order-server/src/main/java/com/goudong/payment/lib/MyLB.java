package com.goudong.payment.lib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类描述：
 *
 * @Author msi
 * @Date 2021-04-05 20:22
 * @Version 1.0
 */
@Slf4j
@Component
public class MyLB implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while(!this.atomicInteger.compareAndSet(current, next));

        log.info("第几次访问next : {}", next);

        return next;
    }
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index =  getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
