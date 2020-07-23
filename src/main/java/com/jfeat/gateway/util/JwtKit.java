package com.jfeat.gateway.util;

import io.jsonwebtoken.Claims;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created on 2020/5/25.
 *
 * @author Wen Hao
 */
public class JwtKit {
    public static final String USER_ID = "userId";
    public static final String ORG_ID = "orgId";
    public static final String ACCOUNT = "account";
    public static final String ISSUED_AT = "issuedAt";

    public JwtKit() {
    }

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static void setData(Claims claims) {
        setData(getRequest(), claims);
    }

    public static Date getIssuedAt() {
        return getIssuedAt(getRequest());
    }

    public static void setIssuedAt(Object issuedAt) {
        setIssuedAt(getRequest(), issuedAt);
    }

    public static void setUserId(Object userId) {
        setUserId(getRequest(), userId);
    }

    public static void setOrgId(Object orgId) {
        setOrgId(getRequest(), orgId);
    }

    public static void setAccount(Object account) {
        setAccount(getRequest(), account);
    }

    public static Long getUserId() {
        return getUserId(getRequest());
    }

    public static Long getOrgId() {
        return getOrgId(getRequest());
    }

    public static String getAccount() {
        return getAccount(getRequest());
    }

    /** @deprecated */
    @Deprecated
    public static Long getTenantId() {
        return getTenantId(getRequest());
    }

    public static void setData(ServletRequest request, Claims claims) {
        setUserId(request, claims.get("userId"));
        setOrgId(request, claims.get("orgId"));
        setAccount(request, claims.get("account"));
        setIssuedAt(request, claims.getIssuedAt());
    }

    public static Date getIssuedAt(ServletRequest request) {
        return (Date)request.getAttribute("issuedAt");
    }

    public static void setIssuedAt(ServletRequest request, Object issuedAt) {
        request.setAttribute("issuedAt", issuedAt);
    }

    public static void setUserId(ServletRequest request, Object userId) {
        request.setAttribute("userId", userId);
    }

    public static void setOrgId(ServletRequest request, Object orgId) {
        request.setAttribute("orgId", orgId);
    }

    public static void setAccount(ServletRequest request, Object account) {
        request.setAttribute("account", account);
    }

    public static Long getUserId(ServletRequest request) {
        return toLong(request.getAttribute("userId"), (Long)null);
    }

    public static Long getOrgId(ServletRequest request) {
        return toLong(request.getAttribute("orgId"), (Long)null);
    }

    public static String getAccount(ServletRequest request) {
        return (String)request.getAttribute("account");
    }

    /** @deprecated */
    @Deprecated
    public static Long getTenantId(ServletRequest request) {
        return getOrgId(request);
    }

    private static Long toLong(Object value, Long defaultValue) {
        try {
            if (value == null) {
                return defaultValue;
            } else {
                String str = value.toString().trim();
                if (!StringUtils.isEmpty(str) && !"null".equals(str.toLowerCase())) {
                    return !str.startsWith("N") && !str.startsWith("n") ? Long.parseLong(value.toString().trim()) : -Long.parseLong(str.substring(1));
                } else {
                    return defaultValue;
                }
            }
        } catch (Exception var3) {
            var3.printStackTrace();
            throw new RuntimeException(var3);
        }
    }
}
