package com.wangsiqian.tourist.statistics.service;

import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.statistics.representation.StatisticsVO;

/** @author wangsiqian */
public interface StatisticsService {
    /**
     * 通过用户ID获取统计信息
     *
     * @param userId 用户ID
     * @return 统计数据
     */
    CommonResult<StatisticsVO> getStatisticsByUserId(String userId);
}
