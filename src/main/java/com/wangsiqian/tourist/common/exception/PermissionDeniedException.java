package com.wangsiqian.tourist.common.exception;

/** @author wangsiqian */
public class PermissionDeniedException extends ApiException {
    public PermissionDeniedException() {
        super("permission_denied", "您没有访问的权限");
    }
}
