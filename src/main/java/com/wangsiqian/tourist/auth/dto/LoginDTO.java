package com.wangsiqian.tourist.auth.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/** @author wangsiqian */
@Getter
@Setter
@ToString
public class LoginDTO {
    @NotBlank private String username;
    @NotBlank private String password;
}
