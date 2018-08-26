package com.jd.hackathon.shooting.controller;

import com.jd.hackathon.shooting.consumer.HelloClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dubiaopei on 2018/8/27.
 */
@RestController
public class HelloController {
    @Autowired
    HelloClientService helloClientService;

    @GetMapping("/consumer")
    public List<String> dc() {
        return helloClientService.consumer();
    }
}
