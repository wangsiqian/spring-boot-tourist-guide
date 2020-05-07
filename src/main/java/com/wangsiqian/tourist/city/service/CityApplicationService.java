package com.wangsiqian.tourist.city.service;

import com.wangsiqian.tourist.city.dto.CreateCityDTO;
import com.wangsiqian.tourist.common.utils.CommonResult;

/** @author wangsiqian */
public interface CityApplicationService {
    /**
     * 创建城市
     *
     * @param createCityDTO 城市数据载体
     * @return 创建结果
     */
    CommonResult<String> createCity(CreateCityDTO createCityDTO);
}
