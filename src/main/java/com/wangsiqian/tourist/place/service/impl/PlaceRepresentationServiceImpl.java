package com.wangsiqian.tourist.place.service.impl;

import com.wangsiqian.tourist.city.CityDAO;
import com.wangsiqian.tourist.city.exception.CityNotFoundException;
import com.wangsiqian.tourist.city.service.CityRepresentationService;
import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.place.dto.ListNearByPlacesDTO;
import com.wangsiqian.tourist.place.dto.ListPlacesByPointDTO;
import com.wangsiqian.tourist.place.exception.PlaceNotFoundException;
import com.wangsiqian.tourist.place.model.Place;
import com.wangsiqian.tourist.place.repository.PlaceRepository;
import com.wangsiqian.tourist.place.representation.PlaceIdAndNameVO;
import com.wangsiqian.tourist.place.representation.PlaceRepresentation;
import com.wangsiqian.tourist.place.service.PlaceRepresentationService;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** @author wangsiqian */
@Service
@RequiredArgsConstructor
public class PlaceRepresentationServiceImpl implements PlaceRepresentationService {
    private final PlaceRepository placeRepository;
    private final CityRepresentationService cityRepresentationService;
    private final CityDAO cityDAO;

    @Override
    public CommonResult<PlaceRepresentation> getPlaceByPlaceId(String placeId) {
        Place place = placeRepository.findById(placeId).orElse(null);
        if (place == null) {
            throw new PlaceNotFoundException();
        }

        return CommonResult.okResponse(place.toRepresentation());
    }

    @Override
    public CommonResult<List<PlaceRepresentation>> listNearbyPlaces(
            ListNearByPlacesDTO listNearByPlacesDTO) {
        // 按中心点和距离过滤
        GeoDistanceQueryBuilder locationFilter =
                QueryBuilders.geoDistanceQuery("location")
                        .point(
                                listNearByPlacesDTO.getLatitude(),
                                listNearByPlacesDTO.getLongitude())
                        .distance(listNearByPlacesDTO.getDistance(), DistanceUnit.METERS);

        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.filter(locationFilter);

        // 转化为 representation
        List<PlaceRepresentation> representations = new ArrayList<>();
        Iterable<Place> iterator = placeRepository.search(boolQueryBuilder);
        iterator.forEach(place -> representations.add(place.toRepresentation()));

        return CommonResult.okResponse(representations);
    }

    @Override
    public CommonResult<List<PlaceRepresentation>> listPlacesByPoint(
            ListPlacesByPointDTO listPlacesByPointDTO) {
        // 通过经纬度获取城市ID
        String cityId =
                cityRepresentationService
                        .getCityByPoint(
                                new GeoPoint(
                                        listPlacesByPointDTO.getLatitude(),
                                        listPlacesByPointDTO.getLongitude()))
                        .getResult()
                        .getCityId();

        // 转化为展示模型
        return CommonResult.okResponse(
                placeRepository.findByCityId(cityId).stream()
                        .map(Place::toRepresentation)
                        .collect(Collectors.toList()));
    }

    @Override
    public CommonResult<List<PlaceRepresentation>> listPlacesByCityId(String cityId) {
        if (cityDAO.getCityById(cityId) == null) {
            throw new CityNotFoundException();
        }

        return CommonResult.okResponse(
                placeRepository.findByCityId(cityId).stream()
                        .map(Place::toRepresentation)
                        .collect(Collectors.toList()));
    }

    @Override
    public CommonResult<List<PlaceIdAndNameVO>> listPlacesIdAndNameByKeyword(String keyword) {
        // 展示 5 个相近名字的景点
        List<Place> places = placeRepository.findByNameLike(keyword, PageRequest.of(0, 5));

        return CommonResult.okResponse(
                places.stream().map(Place::remainIdAndName).collect(Collectors.toList()));
    }
}
