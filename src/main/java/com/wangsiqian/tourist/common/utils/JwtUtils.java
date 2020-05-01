package com.wangsiqian.tourist.common.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;

import static com.wangsiqian.tourist.common.constant.JwtConstant.JWT_EXPIRATION_MILLI;
import static com.wangsiqian.tourist.common.constant.JwtConstant.JWT_SECRET;

/** @author wangsiqian */
@Component
public class JwtUtils {
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(new HashMap<>(4))
                .setSubject(userDetails.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_MILLI))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public String getUsernameByToken(String token) {
        return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody().getSubject();
    }
}
