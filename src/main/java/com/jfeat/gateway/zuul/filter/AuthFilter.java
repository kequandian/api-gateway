package com.jfeat.gateway.zuul.filter;

import com.netflix.zuul.ZuulFilter;

import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.pre.PreDecorationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2020/5/25.
 *
 * @author Wen Hao
 */
@Component
public class AuthFilter extends ZuulFilter {

    private final static Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
        // return PreDecorationFilter.FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        System.out.println("zuul过滤器...");
        // 向header中添加鉴权令牌
        RequestContext requestContext = RequestContext.getCurrentContext();

        // 获取header
        HttpServletRequest request = requestContext.getRequest();
        String authorization = request.getHeader("Authorization");
        if(authorization != null) {
            System.out.println("authorization: " + authorization);
            requestContext.addZuulRequestHeader("Authorization", authorization);
        }
        return null;
    }
}
