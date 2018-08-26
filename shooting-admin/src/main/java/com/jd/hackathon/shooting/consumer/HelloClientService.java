package com.jd.hackathon.shooting.consumer;

import com.jd.hackathon.shooting.consumer.impl.HelloClientServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by dubiaopei on 2018/8/27.
 */
@FeignClient(name = "eureka-client", fallback = HelloClientServiceImpl.class)
public interface HelloClientService {
    @GetMapping("/hello")
    List<String> consumer();

}
