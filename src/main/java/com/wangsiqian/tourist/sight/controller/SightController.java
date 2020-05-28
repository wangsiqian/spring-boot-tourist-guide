package com.wangsiqian.tourist.sight.controller;

import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.sight.representation.SightVO;
import com.wangsiqian.tourist.sight.service.SightRepresentationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** @author wangsiqian */
@RestController
@RequestMapping("/v1/sight")
@RequiredArgsConstructor
public class SightController {
    private final SightRepresentationService representationService;

    @GetMapping("/city/{cityId}")
    public CommonResult<List<SightVO>> listSightByCityId(@PathVariable String cityId) {
        return representationService.listSightsByCityId(cityId);
    }
}
