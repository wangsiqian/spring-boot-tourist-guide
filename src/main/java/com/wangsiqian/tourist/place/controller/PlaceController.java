package com.wangsiqian.tourist.place.controller;

import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.place.dto.CreatePlaceDTO;
import com.wangsiqian.tourist.place.dto.ListNearByPlacesDTO;
import com.wangsiqian.tourist.place.representation.PlaceRepresentation;
import com.wangsiqian.tourist.place.service.PlaceApplicationService;
import com.wangsiqian.tourist.place.service.PlaceRepresentationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/** @author wangsiqian */
@RestController
@RequestMapping("/v1/place")
@RequiredArgsConstructor
@Api("景点API")
public class PlaceController {
    private final PlaceApplicationService placeApplicationService;
    private final PlaceRepresentationService placeRepresentationService;

    @ApiOperation("添加景点（后续改成 admin 接口）")
    @PostMapping
    public CommonResult<String> createPlace(@RequestBody @Validated CreatePlaceDTO createPlaceDTO) {
        return placeApplicationService.createPlace(createPlaceDTO);
    }

    @GetMapping
    @ApiOperation("查找附近的景点")
    public CommonResult<List<PlaceRepresentation>> listNearbyPlaces(
            @Valid ListNearByPlacesDTO listNearByPlacesDTO) {
        return placeRepresentationService.listNearbyPlaces(listNearByPlacesDTO);
    }
}
