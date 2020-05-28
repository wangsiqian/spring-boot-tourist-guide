package com.wangsiqian.tourist.sight.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/** @author wangsiqian */
@Getter
@Setter
@ToString
public class CreateSightDTO {
    @NotBlank private String name;
    @NotBlank private String coverUrl;
    @NotBlank private String cityId;
}
