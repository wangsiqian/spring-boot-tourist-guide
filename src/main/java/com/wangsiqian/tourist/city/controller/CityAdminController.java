package com.wangsiqian.tourist.city.controller;

import com.wangsiqian.tourist.city.dto.CreateCityDTO;
import com.wangsiqian.tourist.city.service.CityApplicationService;
import com.wangsiqian.tourist.common.utils.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author wangsiqian */
@Api("城市API")
@RestController
@RequestMapping("/admin/city")
@RequiredArgsConstructor
public class CityAdminController {
    private final CityApplicationService applicationService;

    @ApiOperation("创建城市")
    @PostMapping
    public CommonResult<String> createCity(@RequestBody @Validated CreateCityDTO createCityDTO) {
        return applicationService.createCity(createCityDTO);
    }
}
