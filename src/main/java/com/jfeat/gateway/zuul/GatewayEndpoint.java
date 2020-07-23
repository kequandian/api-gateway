package com.jfeat.gateway.zuul;

import com.jfeat.gateway.zuul.event.RefreshRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2020/5/25.
 *
 * @author Wen Hao
 */
@RestController
@RequestMapping("/gw")
public class GatewayEndpoint {

    @Autowired
    RefreshRouteService refreshRouteService;

    @RequestMapping("/refresh")
    public String refreshRoute(){
        refreshRouteService.refreshRoute();
        return "refreshRoute";
    }
}
