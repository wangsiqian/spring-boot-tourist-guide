package com.wangsiqian.tourist.place.controller;

import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.place.dto.CreatePlaceDTO;
import com.wangsiqian.tourist.place.dto.ListNearByPlacesDTO;
import com.wangsiqian.tourist.place.representation.PlaceRepresentation;
import com.wangsiqian.tourist.place.service.PlaceApplicationService;
import com.wangsiqian.tourist.place.service.PlaceRepresentationService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/** @author wangsiqian */
@RestController
@RequestMapping("/v1/place")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceApplicationService placeApplicationService;
    private final PlaceRepresentationService placeRepresentationService;

    @PostMapping
    public CommonResult<String> createPlace(@RequestBody @Validated CreatePlaceDTO createPlaceDTO) {
        return placeApplicationService.createPlace(createPlaceDTO);
    }

    @GetMapping
    public CommonResult<List<PlaceRepresentation>> listNearbyPlaces(
            @Valid ListNearByPlacesDTO listNearByPlacesDTO) {
        return placeRepresentationService.listNearbyPlaces(listNearByPlacesDTO);
    }
}
