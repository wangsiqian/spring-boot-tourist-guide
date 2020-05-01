package com.wangsiqian.tourist.common.exception.handler;

import com.alibaba.fastjson.JSONObject;
import com.wangsiqian.tourist.common.exception.PermissionDeniedException;
import com.wangsiqian.tourist.common.utils.CommonResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/** @author wangsiqian */
@Component
public class PermissionDeniedHandler implements AccessDeniedHandler, AuthenticationEntryPoint {
    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException accessDeniedException)
            throws IOException {

        response.setContentType("application/json; charset=utf-8");
        OutputStream out = response.getOutputStream();
        out.write(
                JSONObject.toJSONBytes(
                        CommonResult.falseResponse(new PermissionDeniedException())));
        out.flush();
    }

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException)
            throws IOException {

        response.setContentType("application/json; charset=utf-8");
        OutputStream out = response.getOutputStream();
        out.write(
                JSONObject.toJSONBytes(
                        CommonResult.falseResponse(new PermissionDeniedException())));
        out.flush();
    }
}
