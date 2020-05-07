package com.wangsiqian.tourist.city;

import com.wangsiqian.tourist.TouristGuideTests;
import com.wangsiqian.tourist.city.dto.CreateCityDTO;
import com.wangsiqian.tourist.city.model.City;
import com.wangsiqian.tourist.common.security.AdminProperties;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CityAdminControllerTests extends TouristGuideTests {
    @Autowired AdminProperties adminProperties;
    @Autowired CityDAO cityDAO;

    @Test(timeout = 10000)
    public void creatCityTest() throws Exception {
        CreateCityDTO createCityDTO = new CreateCityDTO();
        createCityDTO.setCityId("00001");
        createCityDTO.setName("北京");

        // 创建城市
        client.post("/admin/city", createCityDTO);

        // 查询
        City city = cityDAO.getCityById("00001");
        assertThat(city.getCityId(), equalTo("00001"));
        assertThat(city.getName(), equalTo("北京"));
    }
}
