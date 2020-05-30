package com.wangsiqian.tourist.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/** @author wangsiqian */
@Data
@Validated
@ConfigurationProperties("tourist.file")
public class FileProperties {
    @NotBlank private String imagePath;
}
