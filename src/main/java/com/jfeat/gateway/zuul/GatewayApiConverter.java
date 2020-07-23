package com.jfeat.gateway.zuul;

import com.jfeat.gateway.zuul.crud.services.gen.persistence.model.GatewayApi;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

/**
 * Created on 2020/5/25.
 *
 * @author Wen Hao
 */
public class GatewayApiConverter {

    public static ZuulProperties.ZuulRoute convert(GatewayApi gatewayApi) {

        String name = gatewayApi.getName();
        String path = gatewayApi.getPath();
        String serviceId = gatewayApi.getServiceId();
        String url = gatewayApi.getUrl();
        Integer retryable = gatewayApi.getRetryable();
        Integer stripPrefix = gatewayApi.getStripPrefix();

        ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();
        zuulRoute.setId(name);
        zuulRoute.setPath(path);
        zuulRoute.setServiceId(serviceId);
        zuulRoute.setUrl(url);
        zuulRoute.setRetryable(retryable == 1 ? Boolean.TRUE : Boolean.FALSE);
        zuulRoute.setStripPrefix(stripPrefix == 1 ? Boolean.TRUE : Boolean.FALSE);
        return zuulRoute;
    }
}
