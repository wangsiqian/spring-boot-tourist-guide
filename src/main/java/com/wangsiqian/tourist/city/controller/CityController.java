package com.wangsiqian.tourist.city.controller;

import com.wangsiqian.tourist.city.representation.CityVO;
import com.wangsiqian.tourist.city.service.CityRepresentationService;
import com.wangsiqian.tourist.common.utils.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** @author wangsiqian */
@Api("城市 API")
@RestController
@RequestMapping("/v1/city")
@RequiredArgsConstructor
public class CityController {
    private final CityRepresentationService representationService;

    @ApiOperation("列出城市")
    @GetMapping
    public CommonResult<List<CityVO>> listCities() {
        return representationService.listCities();
    }

    @GetMapping("/geo")
    CommonResult<CityVO> getCityByPoint(
            @RequestParam Double latitude, @RequestParam Double longitude) {
        return representationService.getCityByPoint(new GeoPoint(latitude, longitude));
    }
}
