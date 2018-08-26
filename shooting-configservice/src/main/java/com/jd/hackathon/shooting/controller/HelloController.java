package com.jd.hackathon.shooting.controller;

import com.jd.hackathon.shooting.service.HelloService;
import org.bouncycastle.util.test.TestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by dubiaopei on 2018/8/26.
 */
@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    private final String REST_URL_PREFIX = "test";

    @Autowired
    private HelloService helloService;

    @Autowired
    private DiscoveryClient client;

    RestTemplate restTemplate = new RestTemplate();

    @PostConstruct
    private void postConstruct() {
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
    }


    @RequestMapping(value = "/hello/discovery", method = RequestMethod.GET)
    public Object  index() {
        List<String> list = client.getServices();
        System.out.println("==========="+list);

        List<ServiceInstance> srvList = client.getInstances("SHOOTING-CONFIGSERVICE");
        for(ServiceInstance element : srvList) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+
                    "\t"+element.getUri());
        }
        return this.client;
    }

    @RequestMapping(value="/consumer/hello/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/hello/discovery", Object.class);
      }


    }
