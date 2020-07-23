package com.jfeat.gateway.consul;

import com.ecwid.consul.v1.ConsulClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created on 2020/5/25.
 *
 * @author Wen Hao
 */
// @RestController
// @RequestMapping("/consul")
public class ConsulEndpoint {

    @Resource
    private ConsulClient connsulClient;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/services")
    public Object foo() {
        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(service);

            System.out.println(instances);
        }
        return services;
    }
}
