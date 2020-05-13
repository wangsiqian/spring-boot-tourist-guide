package com.wangsiqian.tourist.place.exception;

import com.wangsiqian.tourist.common.exception.ApiException;

/** @author wangsiqian */
public class PlaceNotFoundException extends ApiException {
    public PlaceNotFoundException() {
        super("place_not_found", "没有查询到该景点");
    }
}
