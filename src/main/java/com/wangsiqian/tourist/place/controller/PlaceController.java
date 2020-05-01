package com.wangsiqian.tourist.place.controller;

import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.place.dto.CreatePlaceDTO;
import com.wangsiqian.tourist.place.service.PlaceApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author wangsiqian */
@RestController
@RequestMapping("/v1/place")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceApplicationService placeApplicationService;

    @PostMapping
    public CommonResult<String> createPlace(@RequestBody @Validated CreatePlaceDTO createPlaceDTO) {
        return placeApplicationService.createPlace(createPlaceDTO);
    }
}
