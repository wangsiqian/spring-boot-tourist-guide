package com.wangsiqian.tourist.common.security;

import com.wangsiqian.tourist.common.exception.handler.PermissionDeniedHandler;
import com.wangsiqian.tourist.common.filter.AuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/** @author wangsiqian */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableConfigurationProperties(AdminProperties.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final AdminProperties adminProperties;
    private final PermissionDeniedHandler permissionDeniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(adminProperties.getUsername())
                .password(bCryptPasswordEncoder().encode(adminProperties.getPassword()))
                .roles(adminProperties.getRole());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 访问控制
        http.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**")
                .permitAll()
                .antMatchers("/admin/**")
                .hasRole(adminProperties.getRole());

        // 请求控制
        http.csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .headers()
                .cacheControl();

        // 异常处理
        http.exceptionHandling()
                .accessDeniedHandler(permissionDeniedHandler)
                .authenticationEntryPoint(permissionDeniedHandler);

        // 身份验证
        http.addFilterBefore(
                authenticationFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public AuthenticationFilter authenticationFilterBean() {
        return new AuthenticationFilter();
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean(name = BeanIds.USER_DETAILS_SERVICE)
    @Override
    public UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }
}
