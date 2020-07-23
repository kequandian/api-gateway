package com.jfeat.gateway.util;

import com.jfeat.gateway.properties.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

/**
 * Created on 2020/5/25.
 *
 * @author Wen Hao
 */
@Service
@DependsOn({"jwtSpringContextHolder"})
public class JwtService {
    @Autowired
    private JwtProperties jwtProperties;
    private SignatureAlgorithm signatureAlgorithm;

    public JwtService() {
        this.signatureAlgorithm = SignatureAlgorithm.HS512;
    }

    public static JwtService me() {
        return (JwtService) JwtSpringContextHolder.getBean(JwtService.class);
    }

    public String createToken(Long orgId, Long userId, String account) {
        return this.createJWT(orgId, userId, account, this.jwtProperties.getTtlMillis());
    }

    public Claims parseToken(String token) {
        try {
            Claims claims = this.parseJWT(token);
            return claims;
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public long getExpiresIn() {
        return this.jwtProperties.getTtlMillis();
    }

    public String getTokenType() {
        return this.jwtProperties.getTokenType();
    }

    private String createJWT(Long orgId, Long userId, String account, long ttlMillis) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .claim("orgId", orgId + "")
                .claim("userId", userId + "")
                .claim("account", account)
                .setIssuedAt(now)
                .setId(userId.toString())
                .setSubject(account)
                .signWith(getSignatureAlgorithm(), getSecretKey());
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    private Claims parseJWT(String jwt) throws Exception {
        Claims claims = (Claims) Jwts.parser().setSigningKey(this.getSecretKey()).parseClaimsJws(jwt).getBody();
        return claims;
    }

    private SignatureAlgorithm getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    private Key deserializeKey(String encodedKey) {
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        Key key = new SecretKeySpec(decodedKey, this.getSignatureAlgorithm().getJcaName());
        return key;
    }

    private Key getSecretKey() {
        return this.deserializeKey(this.jwtProperties.getEncodedKey());
    }

    private String serializeKey(Key key) {
        String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
        return encodedKey;
    }

}
