package com.wangsiqian.tourist.place.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/** @author wangsiqian */
@Getter
@Setter
@ToString
public class ListPlacesByPointDTO {
    @NotNull
    @Range(min = 20, max = 50, message = "目前仅支持中国境内的景点")
    private Double latitude;

    @NotNull
    @Range(min = 70, max = 180, message = "目前仅支持中国境内的景点")
    private Double longitude;
}
