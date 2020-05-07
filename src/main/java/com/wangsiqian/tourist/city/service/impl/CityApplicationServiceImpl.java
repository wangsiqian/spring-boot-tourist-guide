package com.wangsiqian.tourist.city.service.impl;

import com.wangsiqian.tourist.city.CityDAO;
import com.wangsiqian.tourist.city.dto.CreateCityDTO;
import com.wangsiqian.tourist.city.exception.CityAlreadyExistException;
import com.wangsiqian.tourist.city.model.CityFactory;
import com.wangsiqian.tourist.city.service.CityApplicationService;
import com.wangsiqian.tourist.common.utils.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** @author wangsiqian */
@Service
@RequiredArgsConstructor
public class CityApplicationServiceImpl implements CityApplicationService {
    private final CityDAO cityDAO;
    private final CityFactory cityFactory;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonResult<String> createCity(CreateCityDTO createCityDTO) {
        if (cityDAO.getCityById(createCityDTO.getCityId()) != null) {
            throw new CityAlreadyExistException();
        }

        // 创建城市
        cityDAO.createCity(cityFactory.create(createCityDTO));

        return CommonResult.okResponse();
    }
}
