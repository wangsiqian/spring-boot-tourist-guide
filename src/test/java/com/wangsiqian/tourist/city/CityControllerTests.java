package com.wangsiqian.tourist.city;

import com.wangsiqian.tourist.TouristGuideTests;
import com.wangsiqian.tourist.city.dto.CreateCityDTO;
import com.wangsiqian.tourist.city.model.City;
import com.wangsiqian.tourist.city.representation.CityVO;
import com.wangsiqian.tourist.city.service.CityApplicationService;
import com.wangsiqian.tourist.city.service.CityRepresentationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CityControllerTests extends TouristGuideTests {
    @Autowired CityApplicationService applicationService;
    @Autowired CityRepresentationService representationService;

    @Test(timeout = 10000)
    public void listCitiesTest() {
        CreateCityDTO createCityDTO = new CreateCityDTO();
        createCityDTO.setCityId("00001");
        createCityDTO.setName("北京");

        applicationService.createCity(createCityDTO);

        createCityDTO.setCityId("00002");
        createCityDTO.setName("成都");
        // 创建两个城市
        applicationService.createCity(createCityDTO);

        // 列出城市
        List<CityVO> cities = representationService.listCities().getResult();
        assertThat(cities.size(), equalTo(2));
    }
}
