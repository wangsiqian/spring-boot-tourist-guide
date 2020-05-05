package com.wangsiqian.tourist.session.exception;

import com.wangsiqian.tourist.common.exception.ApiException;

/** @author wangsiqian */
public class AuthenticationFailedException extends ApiException {
    public AuthenticationFailedException() {
        super("authentication_failed", "账号或者密码错误");
    }
}
