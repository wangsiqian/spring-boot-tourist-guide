package com.wangsiqian.tourist.place.service;

import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.place.representation.PlaceRepresentation;
import com.wangsiqian.tourist.place.dto.ListNearByPlacesDTO;

import java.util.List;

/** @author wangsiqian */
public interface PlaceRepresentationService {
    /**
     * 列出附近的景点
     *
     * @param listNearByPlacesDTO 查询参数
     * @return 查询结果
     */
    CommonResult<List<PlaceRepresentation>> listNearbyPlaces(
            ListNearByPlacesDTO listNearByPlacesDTO);
}
