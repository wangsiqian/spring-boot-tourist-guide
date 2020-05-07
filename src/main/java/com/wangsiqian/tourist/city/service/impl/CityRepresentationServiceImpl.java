package com.wangsiqian.tourist.city.service.impl;

import com.wangsiqian.tourist.city.CityDAO;
import com.wangsiqian.tourist.city.exception.CityNotFoundException;
import com.wangsiqian.tourist.city.model.City;
import com.wangsiqian.tourist.city.representation.CityVO;
import com.wangsiqian.tourist.city.service.CityRepresentationService;
import com.wangsiqian.tourist.common.sdk.GeoSdk;
import com.wangsiqian.tourist.common.utils.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author wangsiqian */
@Service
@RequiredArgsConstructor
public class CityRepresentationServiceImpl implements CityRepresentationService {
    private final CityDAO cityDAO;

    @Override
    public CommonResult<List<CityVO>> listCities() {
        return CommonResult.okResponse(cityDAO.listCities());
    }

    @Override
    public CommonResult<CityVO> getCityByPoint(GeoPoint point) {
        String cityName = GeoSdk.getCityNameByPoint(point);
        if (cityName == null) {
            // 经纬度查询失败
            throw new CityNotFoundException();
        }

        City city = cityDAO.getCityByName(cityName);
        if (city == null) {
            // 未找到城市
            throw new CityNotFoundException();
        }

        return CommonResult.okResponse(city.toRepresentation());
    }
}
