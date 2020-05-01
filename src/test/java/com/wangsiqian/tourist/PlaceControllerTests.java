package com.wangsiqian.tourist;

import com.wangsiqian.tourist.place.dto.CreatePlaceDTO;
import com.wangsiqian.tourist.place.model.Place;
import com.wangsiqian.tourist.place.repository.PlaceRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class PlaceControllerTests extends TouristGuidTests {
    @Autowired PlaceRepository placeRepository;

    @Test(timeout = 10000)
    public void createPlaceTest() throws Exception {
        CreatePlaceDTO createPlaceDTO =
                CreatePlaceDTO.builder()
                        .cityId("704547")
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
        assertThat(place.getLocation().getX(), equalTo(30.914196));
        assertThat(place.getLocation().getY(), equalTo(103.567074));
        assertThat(place.getDescription(), equalTo("青城山自古素有“青城天下幽”的美誉，分前山和后山两部分"));
    }
}
