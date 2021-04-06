package com.goudong.stream.controller;

import com.goudong.stream.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类描述：
 *
 * @Author msi
 * @Date 2021-04-06 21:20
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/stream")
public class StreamController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/demo1")
    public String demo1() {
        return iMessageProvider.send();
    }
}
