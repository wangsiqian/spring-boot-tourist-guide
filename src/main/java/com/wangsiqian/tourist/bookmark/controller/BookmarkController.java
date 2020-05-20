package com.wangsiqian.tourist.bookmark.controller;

import com.wangsiqian.tourist.bookmark.dto.CreateBookmarkDTO;
import com.wangsiqian.tourist.bookmark.service.BookmarkApplicationService;
import com.wangsiqian.tourist.common.utils.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author wangsiqian */
@Api("城市 API")
@RestController
@RequestMapping("/v1/bookmark")
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkApplicationService applicationService;

    @ApiOperation("收藏景点")
    @PostMapping
    public CommonResult<String> createBookmark(
            @RequestBody @Validated CreateBookmarkDTO createBookmarkDTO) {
        return applicationService.createBookmark(createBookmarkDTO);
    }
}
