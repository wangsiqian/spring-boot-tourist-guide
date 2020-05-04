package com.wangsiqian.tourist.place.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/** @author wangsiqian */
@Builder
@Getter
@Setter
@ToString
public class ListNearByPlacesDTO {
    @NotNull
    @Range(min = 20, max = 50, message = "目前仅支持中国境内的景点")
    private Double latitude;

    @NotNull
    @Range(min = 70, max = 180, message = "目前仅支持中国境内的景点")
    private Double longitude;

    @NotNull
    @Range(min = 0, max = 5000, message = "请输入正确的景点范围")
    private Double distance;

    @Tolerate
    public ListNearByPlacesDTO() {}
}
