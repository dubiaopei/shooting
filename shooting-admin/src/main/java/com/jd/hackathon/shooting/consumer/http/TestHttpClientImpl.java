package com.jd.hackathon.shooting.consumer.http;

import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by dubiaopei on 2018/8/27.
 */
public class TestHttpClientImpl implements TestHttpClient {

    @Override
    public String sayHiFromClientOne(@RequestParam(value = "name") String name) {
        return null;
    }
}
