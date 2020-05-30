package com.wangsiqian.tourist.upload.controller;

import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.upload.dto.UploadFileDTO;
import com.wangsiqian.tourist.upload.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/** @author wangsiqian */
@RestController
@RequestMapping("/v1/upload")
@RequiredArgsConstructor
public class UploadController {
    private final UploadService uploadService;

    @PostMapping("/image")
    public CommonResult<String> uploadImage(@Validated UploadFileDTO dto) {
        return uploadService.uploadImage(dto);
    }
}
