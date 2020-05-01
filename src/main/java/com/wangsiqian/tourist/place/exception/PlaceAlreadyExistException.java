package com.wangsiqian.tourist.place.exception;

import com.wangsiqian.tourist.common.exception.ApiException;

/** @author wangsiqian */
public class PlaceAlreadyExistException extends ApiException {
    public PlaceAlreadyExistException() {
        super("place_already_exist", "该景点已经存在了");
    }
}
