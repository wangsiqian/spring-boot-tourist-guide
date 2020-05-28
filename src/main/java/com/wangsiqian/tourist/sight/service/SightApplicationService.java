package com.wangsiqian.tourist.sight.service;

import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.sight.dto.CreateSightDTO;

/** @author wangsiqian */
public interface SightApplicationService {
    /**
     * 添加新的景点
     *
     * @param dto 景点数据
     * @return 添加结果
     */
    CommonResult<String> createSight(CreateSightDTO dto);
}
