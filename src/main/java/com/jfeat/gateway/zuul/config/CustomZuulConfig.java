package com.jfeat.gateway.zuul.config;

import com.jfeat.gateway.zuul.CustomRouteLocator;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * Created on 2020/5/25.
 *
 * @author Wen Hao
 */
@Configuration
public class CustomZuulConfig {

    @Resource
    private ZuulProperties zuulProperties;

    @Resource
    private ServerProperties server;

    @Bean
    public CustomRouteLocator routeLocator() {
        CustomRouteLocator routeLocator = new CustomRouteLocator(this.server.getServletPrefix(), this.zuulProperties);
        return routeLocator;
    }
}
