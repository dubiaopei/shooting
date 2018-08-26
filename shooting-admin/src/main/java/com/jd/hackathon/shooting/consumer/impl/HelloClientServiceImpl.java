package com.jd.hackathon.shooting.consumer.impl;

import com.jd.hackathon.shooting.consumer.HelloClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by dubiaopei on 2018/8/27.
 */
@Component
public class HelloClientServiceImpl implements HelloClientService {

    @Autowired
    private DiscoveryClient client;

    @Override
    public List<String>  consumer() {
        List<String> list = client.getServices();
        System.out.println("==========="+list);

        List<ServiceInstance> srvList = client.getInstances("SHOOTING-CONFIGSERVICE");
        for(ServiceInstance element : srvList) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+
                    "\t"+element.getUri() + "\t"+element.getMetadata());
        }
        return list;
    }

}
