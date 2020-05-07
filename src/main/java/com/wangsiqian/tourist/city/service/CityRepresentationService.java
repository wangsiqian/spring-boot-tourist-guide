package com.wangsiqian.tourist.city.service;

import com.wangsiqian.tourist.city.representation.CityVO;
import com.wangsiqian.tourist.common.utils.CommonResult;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.List;

/** @author wangsiqian */
public interface CityRepresentationService {
    /**
     * 列出城市
     *
     * @return 城市集合
     */
    CommonResult<List<CityVO>> listCities();

    /**
     * 通过经纬度获取城市
     *
     * @param point 经纬度
     * @return 获取结果
     */
    CommonResult<CityVO> getCityByPoint(GeoPoint point);
}
