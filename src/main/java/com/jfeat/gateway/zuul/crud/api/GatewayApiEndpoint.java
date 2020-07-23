package com.jfeat.gateway.zuul.crud.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.gateway.zuul.crud.services.domain.dao.QueryGatewayApiDao;
import com.jfeat.gateway.zuul.crud.services.domain.model.GatewayApiRecord;
import com.jfeat.gateway.zuul.crud.services.domain.service.GatewayApiService;
import com.jfeat.gateway.zuul.crud.services.gen.persistence.model.GatewayApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2020-05-25
 */
@RestController

@Api("GatewayApi")
@RequestMapping("/gw/crud/gatewayApis")
public class GatewayApiEndpoint {


    @Resource
    GatewayApiService gatewayApiService;

    @Resource
    QueryGatewayApiDao queryGatewayApiDao;

    // @BusinessLog(name = "GatewayApi", value = "create GatewayApi")
    @PostMapping
    @ApiOperation(value = "新建 GatewayApi", response = GatewayApi.class)
    public Tip createGatewayApi(@RequestBody GatewayApi entity) {

        Integer affected = 0;
        try {
            affected = gatewayApiService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    // @BusinessLog(name = "GatewayApi", value = "查看 GatewayApi")
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 GatewayApi", response = GatewayApi.class)
    public Tip getGatewayApi(@PathVariable Long id) {
        return SuccessTip.create(gatewayApiService.retrieveMaster(id));
    }

    // @BusinessLog(name = "GatewayApi", value = "update GatewayApi")
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 GatewayApi", response = GatewayApi.class)
    public Tip updateGatewayApi(@PathVariable Long id, @RequestBody GatewayApi entity) {
        entity.setId(id);
        return SuccessTip.create(gatewayApiService.updateMaster(entity));
    }

    // @BusinessLog(name = "GatewayApi", value = "delete GatewayApi")
    @DeleteMapping("/{id}")
    @ApiOperation("删除 GatewayApi")
    public Tip deleteGatewayApi(@PathVariable Long id) {
        return SuccessTip.create(gatewayApiService.deleteMaster(id));
    }

    // ø@BusinessLog(name = "GatewayApi", value = "查询列表 GatewayApi")
    @ApiOperation(value = "GatewayApi 列表信息", response = GatewayApiRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Long"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "path", dataType = "String"),
            @ApiImplicitParam(name = "serviceId", dataType = "String"),
            @ApiImplicitParam(name = "url", dataType = "String"),
            @ApiImplicitParam(name = "retryable", dataType = "Integer"),
            @ApiImplicitParam(name = "enabled", dataType = "Integer"),
            @ApiImplicitParam(name = "stripPrefix", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryGatewayApis(Page<GatewayApiRecord> page,
                                @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                @RequestParam(name = "search", required = false) String search,
                                @RequestParam(name = "id", required = false) Long id,
                                @RequestParam(name = "name", required = false) String name,
                                @RequestParam(name = "path", required = false) String path,
                                @RequestParam(name = "serviceId", required = false) String serviceId,
                                @RequestParam(name = "url", required = false) String url,
                                @RequestParam(name = "retryable", required = false) Integer retryable,
                                @RequestParam(name = "enabled", required = false) Integer enabled,
                                @RequestParam(name = "stripPrefix", required = false) Integer stripPrefix,
                                @RequestParam(name = "orderBy", required = false) String orderBy,
                                @RequestParam(name = "sort", required = false) String sort) {
        if (orderBy != null && orderBy.length() > 0) {
            if (sort != null && sort.length() > 0) {
                String pattern = "(ASC|DESC|asc|desc)";
                if (!sort.matches(pattern)) {
                    throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
                }
            } else {
                sort = "ASC";
            }
            orderBy = "`" + orderBy + "`" + " " + sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        GatewayApiRecord record = new GatewayApiRecord();
        record.setId(id);
        record.setName(name);
        record.setPath(path);
        record.setServiceId(serviceId);
        record.setUrl(url);
        record.setRetryable(retryable);
        record.setEnabled(enabled);
        record.setStripPrefix(stripPrefix);
        page.setRecords(queryGatewayApiDao.findGatewayApiPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
