package com.jfeat.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created on 2020/5/25.
 *
 * @author Wen Hao
 */

@EnableZuulProxy
@SpringBootApplication
@MapperScan({"com.jfeat.gateway.**.dao", "com.jfeat.gateway.**.mapping"})
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
