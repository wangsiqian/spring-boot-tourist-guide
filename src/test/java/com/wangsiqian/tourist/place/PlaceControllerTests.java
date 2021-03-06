package com.wangsiqian.tourist.place;

import com.wangsiqian.tourist.TouristGuideTests;
import com.wangsiqian.tourist.city.dto.CreateCityDTO;
import com.wangsiqian.tourist.city.service.CityApplicationService;
import com.wangsiqian.tourist.place.dto.CreatePlaceDTO;
import com.wangsiqian.tourist.place.dto.ListPlacesByPointDTO;
import com.wangsiqian.tourist.place.model.Place;
import com.wangsiqian.tourist.place.repository.PlaceRepository;
import com.wangsiqian.tourist.place.representation.PlaceIdAndNameVO;
import com.wangsiqian.tourist.place.representation.PlaceIntroductionVO;
import com.wangsiqian.tourist.place.representation.PlaceRepresentation;
import com.wangsiqian.tourist.place.service.PlaceApplicationService;
import com.wangsiqian.tourist.place.service.PlaceRepresentationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class PlaceControllerTests extends TouristGuideTests {
    @Autowired PlaceRepository placeRepository;
    @Autowired CityApplicationService cityApplicationService;
    @Autowired PlaceApplicationService placeApplicationService;
    @Autowired PlaceRepresentationService placeRepresentationService;

    @Test(timeout = 10000)
    public void createPlaceTest() throws Exception {
        CreatePlaceDTO createPlaceDTO =
                CreatePlaceDTO.builder()
                        .sightId("704547")
                        .name("老君阁")
                        .images(Arrays.asList("https://www.baidu.com/", "https://www.google.com/"))
                        .audio("https://www.baidu.com/")
                        .address("都江堰市西南部青城山风景区")
                        .description("青城山自古素有“青城天下幽”的美誉，分前山和后山两部分")
                        .latitude(30.914196)
                        .longitude(103.567074)
                        .build();

        // 创建
        String placeId = (String) client.post("/v1/place", createPlaceDTO).get("result");

        // 等待数据写入
        Thread.sleep(3 * 1000);

        Place place = placeRepository.findById(placeId).orElse(null);

        assertThat(place, notNullValue());
        assertThat(place.getName(), equalTo("老君阁"));
        assertThat(place.getAddress(), equalTo("都江堰市西南部青城山风景区"));
        assertThat(place.getLocation().getLat(), equalTo(30.914196));
        assertThat(place.getLocation().getLon(), equalTo(103.567074));
        assertThat(place.getDescription(), equalTo("青城山自古素有“青城天下幽”的美誉，分前山和后山两部分"));
    }

    @Test(timeout = 10000)
    public void listPlacesByPointTest() throws Exception {
        CreateCityDTO createCityDTO = new CreateCityDTO();
        createCityDTO.setName("成都市");
        createCityDTO.setCityId("00001");
        // 添加城市
        cityApplicationService.createCity(createCityDTO);

        CreatePlaceDTO createPlaceDTO =
                CreatePlaceDTO.builder()
                        .sightId("00001")
                        .name("老君阁")
                        .images(Arrays.asList("https://www.baidu.com/", "https://www.google.com/"))
                        .audio("https://www.baidu.com/")
                        .address("都江堰市西南部青城山风景区")
                        .description("青城山自古素有“青城天下幽”的美誉，分前山和后山两部分")
                        .latitude(30.914196)
                        .longitude(103.567074)
                        .build();
        // 添加3个成都市的景点
        placeApplicationService.createPlace(createPlaceDTO);
        placeApplicationService.createPlace(createPlaceDTO);
        placeApplicationService.createPlace(createPlaceDTO);

        // 等待数据写入
        Thread.sleep(3 * 1000);

        // 根据成都的经纬度获取当前城市景点
        ListPlacesByPointDTO pointDTO = new ListPlacesByPointDTO();
        pointDTO.setLatitude(30.67);
        pointDTO.setLongitude(104.06);

        List<PlaceRepresentation> places =
                placeRepresentationService.listPlacesByPoint(pointDTO).getResult();
        assertThat(places.size(), equalTo(3));
    }

    @Test(timeout = 10000)
    public void listPlacesIdAndNameByKeywordTest() {
        CreateCityDTO createCityDTO = new CreateCityDTO();
        createCityDTO.setName("成都市");
        createCityDTO.setCityId("00001");
        // 添加城市
        cityApplicationService.createCity(createCityDTO);

        CreatePlaceDTO createPlaceDTO =
                CreatePlaceDTO.builder()
                        .sightId("00001")
                        .name("天安门")
                        .images(Arrays.asList("https://www.baidu.com/", "https://www.google.com/"))
                        .audio("https://www.baidu.com/")
                        .address("都江堰市西南部青城山风景区")
                        .description("青城山自古素有“青城天下幽”的美誉，分前山和后山两部分")
                        .latitude(30.914196)
                        .longitude(103.567074)
                        .build();
        // 添加3个成都市的景点
        placeApplicationService.createPlace(createPlaceDTO);
        createPlaceDTO.setName("朝天门");
        placeApplicationService.createPlace(createPlaceDTO);
        createPlaceDTO.setName("景点3");
        placeApplicationService.createPlace(createPlaceDTO);

        // 根据名字模糊查询
        List<PlaceIdAndNameVO> places =
                placeRepresentationService.listPlacesIdAndNameByKeyword("门").getResult();
        assertThat(places.size(), equalTo(2));
    }

    @Test(timeout = 10000)
    public void listPlacesIntroductionByKeywordTest() {
        CreatePlaceDTO createPlaceDTO =
                CreatePlaceDTO.builder()
                        .sightId("00001")
                        .name("天安门")
                        .images(Arrays.asList("https://www.baidu.com/", "https://www.google.com/"))
                        .audio("https://www.baidu.com/")
                        .address("都江堰市西南部青城山风景区")
                        .description("青城山自古素有“青城天下幽”的美誉，分前山和后山两部分")
                        .latitude(30.914196)
                        .longitude(103.567074)
                        .build();
        // 添加3个成都市的景点
        placeApplicationService.createPlace(createPlaceDTO);
        createPlaceDTO.setName("朝天门");
        placeApplicationService.createPlace(createPlaceDTO);
        createPlaceDTO.setName("景点3");
        placeApplicationService.createPlace(createPlaceDTO);

        // 根据名字模糊查询
        List<PlaceIntroductionVO> places =
                placeRepresentationService.listPlacesIntroductionByKeyword("门").getResult();
        assertThat(places.size(), equalTo(2));
    }
}
