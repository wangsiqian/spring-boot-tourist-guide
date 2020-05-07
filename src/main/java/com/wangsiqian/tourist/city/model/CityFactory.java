package com.wangsiqian.tourist.city.model;

import com.wangsiqian.tourist.city.dto.CreateCityDTO;
import org.springframework.stereotype.Component;

/** @author wangsiqian */
@Component
public class CityFactory {
    public City create(CreateCityDTO createCityDTO) {
        return City.create(createCityDTO);
    }
}
