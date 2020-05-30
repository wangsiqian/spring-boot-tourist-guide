package com.wangsiqian.tourist.statistics.controller;

import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.statistics.representation.StatisticsVO;
import com.wangsiqian.tourist.statistics.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author wangsiqian */
@RestController
@RequestMapping("/v1/statistics")
@RequiredArgsConstructor
public class StatisticsController {
    private final StatisticsService service;

    @GetMapping("/{userId}")
    public CommonResult<StatisticsVO> getStatisticsByUserId(@PathVariable String userId) {
        return service.getStatisticsByUserId(userId);
    }
}
