package com.wangsiqian.tourist.common.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/** @author wangsiqian */
@Data
@Validated
@ConfigurationProperties("template.admin")
public class AdminProperties {
    @NotBlank private String username;
    @NotBlank private String password;
    @NotBlank private String role;
}
