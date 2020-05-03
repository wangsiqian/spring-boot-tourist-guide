package com.wangsiqian.tourist.place.service.impl;

import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.place.dto.CreatePlaceDTO;
import com.wangsiqian.tourist.place.model.Place;
import com.wangsiqian.tourist.place.model.PlaceFactory;
import com.wangsiqian.tourist.place.repository.PlaceRepository;
import com.wangsiqian.tourist.place.service.PlaceApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;

/** @author wangsiqian */
@Service
@Slf4j
@RequiredArgsConstructor
public class PlaceApplicationServiceImpl implements PlaceApplicationService {
    private final PlaceRepository placeRepository;
    private final PlaceFactory placeFactory;

    @Override
    public CommonResult<String> createPlace(CreatePlaceDTO createPlaceDTO) {
        Place place = placeFactory.create(createPlaceDTO);

        // 存储到 ES
        placeRepository.index(place);
        log.info("Created place[{}].", place);

        return CommonResult.okResponse(place.getPlaceId());
    }
}
