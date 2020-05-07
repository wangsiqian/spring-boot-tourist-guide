package com.wangsiqian.tourist.city.controller;

import com.wangsiqian.tourist.city.representation.CityVO;
import com.wangsiqian.tourist.city.service.CityRepresentationService;
import com.wangsiqian.tourist.common.utils.CommonResult;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** @author wangsiqian */
@Api("城市 API")
@RestController
@RequestMapping("/v1/city")
@RequiredArgsConstructor
public class CityController {
    private final CityRepresentationService representationService;

    @GetMapping
    public CommonResult<List<CityVO>> listCities() {
        return representationService.listCities();
    }
}
