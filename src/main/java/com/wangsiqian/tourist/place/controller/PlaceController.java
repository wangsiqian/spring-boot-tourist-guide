package com.wangsiqian.tourist.place.controller;

import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.place.dto.CreatePlaceDTO;
import com.wangsiqian.tourist.place.dto.ListNearByPlacesDTO;
import com.wangsiqian.tourist.place.dto.ListPlacesByPointDTO;
import com.wangsiqian.tourist.place.representation.PlaceIdAndNameVO;
import com.wangsiqian.tourist.place.representation.PlaceIntroductionVO;
import com.wangsiqian.tourist.place.representation.PlaceRepresentation;
import com.wangsiqian.tourist.place.service.PlaceApplicationService;
import com.wangsiqian.tourist.place.service.PlaceRepresentationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/** @author wangsiqian */
@RestController
@RequestMapping("/v1/place")
@RequiredArgsConstructor
@Api("景点API")
public class PlaceController {
    private final PlaceApplicationService applicationService;
    private final PlaceRepresentationService representationService;

    @GetMapping("/{placeId}")
    @ApiOperation("通过景点ID获取景点")
    public CommonResult<PlaceRepresentation> getPlaceByPlaceId(
            @PathVariable("placeId") String placeId) {
        return representationService.getPlaceByPlaceId(placeId);
    }

    @PostMapping
    @ApiOperation("添加景点（后续改成 admin 接口）")
    public CommonResult<String> createPlace(@RequestBody @Validated CreatePlaceDTO createPlaceDTO) {
        return applicationService.createPlace(createPlaceDTO);
    }

    @GetMapping("/nearby")
    @ApiOperation("查找附近的景点")
    public CommonResult<List<PlaceRepresentation>> listNearbyPlaces(
            @Valid ListNearByPlacesDTO listNearByPlacesDTO) {
        return representationService.listNearbyPlaces(listNearByPlacesDTO);
    }

    @GetMapping("/geo")
    @ApiOperation("根据经纬度列出所处城市的所有景点")
    public CommonResult<List<PlaceRepresentation>> listPlacesByPoint(
            @Valid ListPlacesByPointDTO listPlacesByPointDTO) {
        return representationService.listPlacesByPoint(listPlacesByPointDTO);
    }

    @GetMapping("/sight/{sightId}")
    @ApiOperation("根据景点ID列出景点")
    public CommonResult<List<PlaceRepresentation>> listPlacesBySightId(
            @PathVariable("sightId") String sightId) {
        return representationService.listPlacesBySightId(sightId);
    }

    @GetMapping("/name")
    @ApiOperation("根据模糊名列出景点ID和名字")
    public CommonResult<List<PlaceIdAndNameVO>> listPlacesIdAndNameByKeyword(
            @RequestParam @NotNull String keyword) {
        return representationService.listPlacesIdAndNameByKeyword(keyword);
    }

    @GetMapping("/introduction")
    @ApiOperation("根据模糊名列出相关景点介绍")
    public CommonResult<List<PlaceIntroductionVO>> listPlacesIntroductionByKeyword(
            @RequestParam @NotNull String keyword) {
        return representationService.listPlacesIntroductionByKeyword(keyword);
    }
}
