package com.wangsiqian.tourist.city.exception;

import com.wangsiqian.tourist.common.exception.ApiException;

/** @author wangsiqian */
public class CityAlreadyExistException extends ApiException {
    public CityAlreadyExistException() {
        super("city_already_exist", "该城市已经存在");
    }
}
