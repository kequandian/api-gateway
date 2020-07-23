package com.jfeat.gateway.zuul.crud.services.gen.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code Generator
 * @since 2020-05-25
 */
@TableName("t_gateway_api")
public class GatewayApi extends Model<GatewayApi> {

    @TableField(exist = false)
    private com.alibaba.fastjson.JSONObject extra;

    public com.alibaba.fastjson.JSONObject getExtra() {
        return extra;
    }
    public void setExtra(com.alibaba.fastjson.JSONObject extra) {
        this.extra = extra;
    }


    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	private String name;
	private String path;
	@TableField("service_id")
	private String serviceId;
	private String url;
	private Integer retryable;
	private Integer enabled;
	@TableField("strip_prefix")
	private Integer stripPrefix;


	public Long getId() {
		return id;
	}

	public GatewayApi setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public GatewayApi setName(String name) {
		this.name = name;
		return this;
	}

	public String getPath() {
		return path;
	}

	public GatewayApi setPath(String path) {
		this.path = path;
		return this;
	}

	public String getServiceId() {
		return serviceId;
	}

	public GatewayApi setServiceId(String serviceId) {
		this.serviceId = serviceId;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public GatewayApi setUrl(String url) {
		this.url = url;
		return this;
	}

	public Integer getRetryable() {
		return retryable;
	}

	public GatewayApi setRetryable(Integer retryable) {
		this.retryable = retryable;
		return this;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public GatewayApi setEnabled(Integer enabled) {
		this.enabled = enabled;
		return this;
	}

	public Integer getStripPrefix() {
		return stripPrefix;
	}

	public GatewayApi setStripPrefix(Integer stripPrefix) {
		this.stripPrefix = stripPrefix;
		return this;
	}

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String PATH = "path";

	public static final String SERVICE_ID = "service_id";

	public static final String URL = "url";

	public static final String RETRYABLE = "retryable";

	public static final String ENABLED = "enabled";

	public static final String STRIP_PREFIX = "strip_prefix";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "GatewayApi{" +
			"id=" + id +
			", name=" + name +
			", path=" + path +
			", serviceId=" + serviceId +
			", url=" + url +
			", retryable=" + retryable +
			", enabled=" + enabled +
			", stripPrefix=" + stripPrefix +
			"}";
	}
}
