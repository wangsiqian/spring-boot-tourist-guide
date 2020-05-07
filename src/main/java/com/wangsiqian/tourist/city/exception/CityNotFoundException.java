package com.wangsiqian.tourist.city.exception;

import com.wangsiqian.tourist.common.exception.ApiException;

/** @author wangsiqian */
public class CityNotFoundException extends ApiException {
    public CityNotFoundException() {
        super("city_not_found", "没有找到该城市");
    }
}
