package com.wangsiqian.tourist.place.service;

import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.place.dto.ListPlacesByPointDTO;
import com.wangsiqian.tourist.place.representation.PlaceIdAndNameVO;
import com.wangsiqian.tourist.place.representation.PlaceRepresentation;
import com.wangsiqian.tourist.place.dto.ListNearByPlacesDTO;

import java.util.List;

/** @author wangsiqian */
public interface PlaceRepresentationService {

    /**
     * 根据景点ID查询景点
     *
     * @param placeId 景点ID
     * @return 查询结果
     */
    CommonResult<PlaceRepresentation> getPlaceByPlaceId(String placeId);

    /**
     * 列出附近的景点
     *
     * @param listNearByPlacesDTO 查询参数
     * @return 查询结果
     */
    CommonResult<List<PlaceRepresentation>> listNearbyPlaces(
            ListNearByPlacesDTO listNearByPlacesDTO);

    /**
     * 列出某个城市的所有景点
     *
     * @param listPlacesByPointDTO 城市经纬度参数
     * @return 查询结果
     */
    CommonResult<List<PlaceRepresentation>> listPlacesByPoint(
            ListPlacesByPointDTO listPlacesByPointDTO);

    /**
     * 根据城市ID列出所有景点
     *
     * @param cityId 城市ID
     * @return 查询结果
     */
    CommonResult<List<PlaceRepresentation>> listPlacesByCityId(String cityId);

    /**
     * 通过关键字模糊查询景点ID和名称
     *
     * @param keyword 关键字
     * @return 查询结果
     */
    CommonResult<List<PlaceIdAndNameVO>> listPlacesIdAndNameByKeyword(String keyword);
}
