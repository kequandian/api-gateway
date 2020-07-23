package com.jfeat.gateway.zuul.crud.services.domain.dao;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.gateway.zuul.crud.services.domain.model.GatewayApiRecord;
import com.jfeat.gateway.zuul.crud.services.gen.persistence.model.GatewayApi;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2020-05-25
 */
public interface QueryGatewayApiDao extends BaseMapper<GatewayApi> {
    List<GatewayApiRecord> findGatewayApiPage(Page<GatewayApiRecord> page, @Param("record") GatewayApiRecord record,
                                              @Param("search") String search, @Param("orderBy") String orderBy,
                                              @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}