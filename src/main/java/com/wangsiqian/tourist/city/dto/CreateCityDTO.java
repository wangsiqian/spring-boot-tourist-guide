package com.wangsiqian.tourist.city.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/** @author wangsiqian */
@Getter
@Setter
@ToString
public class CreateCityDTO {
    @NotBlank private String cityId;
    @NotBlank private String name;
}
