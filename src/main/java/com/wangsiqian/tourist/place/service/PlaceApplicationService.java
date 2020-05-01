package com.wangsiqian.tourist.place.service;

import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.place.dto.CreatePlaceDTO;

/** @author wangsiqian */
public interface PlaceApplicationService {
    /**
     * 创建景点
     *
     * @param createPlaceDTO 景点数据
     * @return 创建结果
     */
    public CommonResult<String> createPlace(CreatePlaceDTO createPlaceDTO);
}
