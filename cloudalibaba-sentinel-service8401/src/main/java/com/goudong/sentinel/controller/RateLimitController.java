package com.goudong.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.goudong.module.pojo.Result;
import com.goudong.sentinel.handler.MyHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author msi
 * @Date 2021-04-07 14:45
 * @Version 1.0
 */
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public Result byResource() {
        return Result.ofSuccess("按资源名称限流测试OK");
    }

    public Result handleException (BlockException exception) {
        return Result.ofFail("服务不可用\te:" + exception.getClass().getName());
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public Result byUrl() {
        return Result.ofSuccess("按资源url限流测试OK");
    }

    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler"
            , blockHandlerClass = MyHandler.class
            , blockHandler = "handlerException2")
    public Result customerBlockHandler() {
        return Result.ofSuccess("客户自定义");
    }
}
