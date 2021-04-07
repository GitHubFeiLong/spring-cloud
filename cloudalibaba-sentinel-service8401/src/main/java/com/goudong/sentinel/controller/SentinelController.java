package com.goudong.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author msi
 * @Date 2021-04-07 10:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/sentinel")
public class SentinelController {

    @GetMapping("/testA")
    public String testA () {
        return "--------testA";
    }
    @GetMapping("/testB")
    public String testB () {
        return "--------testB";
    }

    /**
     * testHotKey热点规则自定义名称
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("/testHotKey")
    @SentinelResource(
            value="testHotKey",
            blockHandler = "deal_testHotKey"
    )
    public String testHotkey (@RequestParam(value = "p1", required = false) String p1,
                              @RequestParam(value = "p2", required = false) String p2) {

        return "testHotKey";
    }

    /**
     * 兜底方法
     * @param p1
     * @param p2
     * @param exception
     * @return
     */
    public String deal_testHotKey (String p1, String p2, BlockException exception) {

        return "deal_testHotKey失败方法调用";
    }
}
