package com.wangsiqian.tourist.upload.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/** @author wangsiqian */
@Getter
@Setter
@ToString
public class UploadFileDTO {
    @NotNull MultipartFile file;
    @NotBlank String userId;
}
