package com.wangsiqian.tourist.city.service;

import com.wangsiqian.tourist.city.representation.CityVO;
import com.wangsiqian.tourist.common.utils.CommonResult;

import java.util.List;

/** @author wangsiqian */
public interface CityRepresentationService {
    /**
     * 列出城市
     *
     * @return 城市集合
     */
    CommonResult<List<CityVO>> listCities();
}
