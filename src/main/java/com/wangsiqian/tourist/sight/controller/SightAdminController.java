package com.wangsiqian.tourist.sight.controller;

import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.sight.dto.CreateSightDTO;
import com.wangsiqian.tourist.sight.service.SightApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author wangsiqian */
@RestController
@RequestMapping("/admin/sight")
@RequiredArgsConstructor
public class SightAdminController {
    private final SightApplicationService applicationService;

    @PostMapping
    public CommonResult<String> createSight(@Validated @RequestBody CreateSightDTO dto) {
        return applicationService.createSight(dto);
    }
}
