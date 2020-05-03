package com.wangsiqian.tourist.place.service.impl;

import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.place.dto.ListNearByPlacesDTO;
import com.wangsiqian.tourist.place.model.Place;
import com.wangsiqian.tourist.place.repository.PlaceRepository;
import com.wangsiqian.tourist.place.representation.PlaceRepresentation;
import com.wangsiqian.tourist.place.service.PlaceRepresentationService;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/** @author wangsiqian */
@Service
@RequiredArgsConstructor
public class PlaceRepresentationServiceImpl implements PlaceRepresentationService {
    private final PlaceRepository placeRepository;

    @Override
    public CommonResult<List<PlaceRepresentation>> listNearbyPlaces(
            ListNearByPlacesDTO listNearByPlacesDTO) {
        // 按中心点和距离过滤
        GeoDistanceQueryBuilder locationFilter =
                QueryBuilders.geoDistanceQuery("location")
                        .point(
                                listNearByPlacesDTO.getLatitude(),
                                listNearByPlacesDTO.getLongitude())
                        .distance(listNearByPlacesDTO.getDistance(), DistanceUnit.MILES);

        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.filter(locationFilter);

        // 转化为 representation
        List<PlaceRepresentation> representations = new ArrayList<>();
        Iterable<Place> iterator = placeRepository.search(boolQueryBuilder);
        iterator.forEach(place -> representations.add(place.toRepresentation()));

        return CommonResult.okResponse(representations);
    }
}
