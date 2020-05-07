package com.wangsiqian.tourist.city.service.impl;

import com.wangsiqian.tourist.city.CityDAO;
import com.wangsiqian.tourist.city.representation.CityVO;
import com.wangsiqian.tourist.city.service.CityRepresentationService;
import com.wangsiqian.tourist.common.utils.CommonResult;
import lombok.RequiredArgsConstructor;
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
}
