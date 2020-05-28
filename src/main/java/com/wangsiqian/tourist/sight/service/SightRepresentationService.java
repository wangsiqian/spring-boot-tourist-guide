package com.wangsiqian.tourist.sight.service;

import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.sight.representation.SightVO;

import java.util.List;

/** @author wangsiqian */
public interface SightRepresentationService {
    /**
     * 根据城市ID列出景点
     *
     * @param cityId 城市ID
     * @return 查询结果结果
     */
    CommonResult<List<SightVO>> listSightsByCityId(String cityId);
}
