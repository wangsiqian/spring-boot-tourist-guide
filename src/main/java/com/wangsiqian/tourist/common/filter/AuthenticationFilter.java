package com.wangsiqian.tourist.common.filter;

import com.wangsiqian.tourist.common.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.wangsiqian.tourist.common.constant.JwtConstant.AUTHORIZATION_HEADER;

/** @author wangsiqian */
@Slf4j
public class AuthenticationFilter extends OncePerRequestFilter {
    @Qualifier("org.springframework.security.userDetailsService")
    @Autowired private UserDetailsService userDetailsService;
    @Autowired private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = request.getHeader(AUTHORIZATION_HEADER);
        if (token != null) {
            // 接收到 token 则设置身份
            try {
                setAuthentication(token, request);
            } catch (Exception error) {
                log.error(
                        String.format("token=%s, exception=%s", token, error.getClass().getName()));
            }
        }

        filterChain.doFilter(request, response);
    }

    private void setAuthentication(String token, HttpServletRequest request) {
        // 获取用户名
        String username = jwtUtils.getUsernameByToken(token);

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        // 将用户信息设置到 context，后面的 filter chain 会进行身份验证
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
