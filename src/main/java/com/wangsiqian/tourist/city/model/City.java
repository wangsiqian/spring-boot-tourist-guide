package com.wangsiqian.tourist.city.model;

import com.wangsiqian.tourist.city.dto.CreateCityDTO;
import com.wangsiqian.tourist.city.representation.CityVO;
import lombok.*;
import lombok.experimental.Tolerate;

import java.util.Date;

/** @author wangsiqian */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private String cityId;
    private String name;
    private Date createdAt;
    private Date updatedAt;

    public static City create(CreateCityDTO createCityDTO) {
        return City.builder()
                .cityId(createCityDTO.getCityId())
                .name(createCityDTO.getName())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
    }

    public CityVO toRepresentation() {
        // 转化为展示层对象
        CityVO cityVO = new CityVO();
        cityVO.setCityId(cityId);
        cityVO.setName(name);

        return cityVO;
    }
}
