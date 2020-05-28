package com.wangsiqian.tourist.place.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/** @author wangsiqian */
@Builder
@Getter
@Setter
@ToString
public class CreatePlaceDTO {
    @NotBlank private String name;
    @NotBlank private String address;
    @NotBlank private String description;
    @NotBlank private String audio;
    @NotNull private String sightId;
    @NotNull private List<String> images;

    @Range(min = 20, max = 50, message = "目前仅支持中国境内的景点")
    private Double latitude;

    @Range(min = 70, max = 180, message = "目前仅支持中国境内的景点")
    private Double longitude;
}
