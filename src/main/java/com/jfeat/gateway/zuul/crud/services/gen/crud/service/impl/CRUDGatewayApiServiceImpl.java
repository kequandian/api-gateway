package com.jfeat.gateway.zuul.crud.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.gateway.zuul.crud.services.gen.persistence.model.GatewayApi;
import com.jfeat.gateway.zuul.crud.services.gen.persistence.dao.GatewayApiMapper;
import com.jfeat.gateway.zuul.crud.services.gen.crud.service.CRUDGatewayApiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDGatewayApiService
 * @author Code Generator
 * @since 2020-05-25
 */

@Service
public class CRUDGatewayApiServiceImpl  extends CRUDServiceOnlyImpl<GatewayApi> implements CRUDGatewayApiService {





        @Resource
        protected GatewayApiMapper gatewayApiMapper;

        @Override
        protected BaseMapper<GatewayApi> getMasterMapper() {
                return gatewayApiMapper;
        }







}


