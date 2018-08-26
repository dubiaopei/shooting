package com.jd.hackathon.shooting.controller;

import com.jd.hackathon.shooting.consumer.TestfeginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by dubiaopei on 2018/8/27.
 */
@RestController
public class TestfeginController {

    @Autowired
    private TestfeginClient testfeginClient;

    @GetMapping("test/{name}")
    public String dc(@PathVariable("name") String name) {
        return testfeginClient.sayHiFromClientOne(name);
    }
}
