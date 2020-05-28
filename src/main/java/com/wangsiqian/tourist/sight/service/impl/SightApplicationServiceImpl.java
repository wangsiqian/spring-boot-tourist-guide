package com.wangsiqian.tourist.sight.service.impl;

import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.sight.SightDAO;
import com.wangsiqian.tourist.sight.dto.CreateSightDTO;
import com.wangsiqian.tourist.sight.exception.SightAlreadyExistException;
import com.wangsiqian.tourist.sight.model.Sight;
import com.wangsiqian.tourist.sight.model.SightFactory;
import com.wangsiqian.tourist.sight.service.SightApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** @author wangsiqian */
@Service
@RequiredArgsConstructor
public class SightApplicationServiceImpl implements SightApplicationService {
    private final SightDAO sightDAO;
    private final SightFactory sightFactory;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonResult<String> createSight(CreateSightDTO dto) {
        if (sightDAO.getSightByNameAndCityId(dto.getName(), dto.getCityId()) != null) {
            // 查询景区
            throw new SightAlreadyExistException();
        }

        // 创建
        Sight sight = sightFactory.create(dto);
        sightDAO.createSight(sight);

        return CommonResult.okResponse();
    }
}
