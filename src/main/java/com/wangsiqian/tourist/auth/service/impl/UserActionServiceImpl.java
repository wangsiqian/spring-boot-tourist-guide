package com.wangsiqian.tourist.auth.service.impl;

import com.wangsiqian.tourist.auth.dto.LoginDTO;
import com.wangsiqian.tourist.auth.exception.AuthenticationFailedException;
import com.wangsiqian.tourist.auth.service.UserActionService;
import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.common.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/** @author wangsiqian */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserActionServiceImpl implements UserActionService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;

    @Override
    public CommonResult<String> login(LoginDTO loginDTO) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getUsername(), loginDTO.getPassword()));
        } catch (AuthenticationException exception) {
            log.error("Authenticate failed with " + exception.getClass().getName());
            throw new AuthenticationFailedException();
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginDTO.getUsername());

        return CommonResult.okResponse(jwtUtils.generateToken(userDetails));
    }
}
