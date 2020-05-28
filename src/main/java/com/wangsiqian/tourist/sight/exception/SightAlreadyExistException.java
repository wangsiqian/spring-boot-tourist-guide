package com.wangsiqian.tourist.sight.exception;

import com.wangsiqian.tourist.common.exception.ApiException;

/** @author wangsiqian */
public class SightAlreadyExistException extends ApiException {
    public SightAlreadyExistException() {
        super("sight_already_exist", "该景区已经存在了");
    }
}
