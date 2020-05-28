package com.wangsiqian.tourist.sight.service.impl;

import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.sight.SightDAO;
import com.wangsiqian.tourist.sight.representation.SightVO;
import com.wangsiqian.tourist.sight.service.SightRepresentationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author wangsiqian */
@Service
@RequiredArgsConstructor
public class SightRepresentationServiceImpl implements SightRepresentationService {
    private final SightDAO sightDAO;

    @Override
    public CommonResult<List<SightVO>> listSightsByCityId(String cityId) {
        return CommonResult.okResponse(sightDAO.listSightsByCityId(cityId));
    }
}
