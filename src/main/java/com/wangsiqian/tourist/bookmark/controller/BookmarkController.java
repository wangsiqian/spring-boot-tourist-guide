package com.wangsiqian.tourist.bookmark.controller;

import com.wangsiqian.tourist.bookmark.dto.CreateBookmarkDTO;
import com.wangsiqian.tourist.bookmark.representation.BookmarkVO;
import com.wangsiqian.tourist.bookmark.service.BookmarkApplicationService;
import com.wangsiqian.tourist.bookmark.service.BookmarkRepresentationService;
import com.wangsiqian.tourist.common.utils.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** @author wangsiqian */
@Api("书签 API")
@RestController
@RequestMapping("/v1/bookmark")
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkApplicationService applicationService;
    private final BookmarkRepresentationService representationService;

    @ApiOperation("收藏景点")
    @PostMapping
    public CommonResult<String> createBookmark(
            @RequestBody @Validated CreateBookmarkDTO createBookmarkDTO) {
        return applicationService.createBookmark(createBookmarkDTO);
    }

    @ApiOperation("根据用户ID列出景点")
    @GetMapping("/{userId}")
    public CommonResult<List<BookmarkVO>> listBookmarksByUserId(
            @PathVariable(name = "userId") String userId) {
        return representationService.listBookmarksByUserId(userId);
    }

    @DeleteMapping("/{userId}/place/{placeId}")
    public CommonResult<String> deleteBookmarkById(
            @PathVariable String userId, @PathVariable String placeId) {
        return applicationService.deleteBookmarkById(userId, placeId);
    }

    @GetMapping("/{userId}/place/{placeId}")
    public CommonResult<BookmarkVO> getBookmarkById(
            @PathVariable String userId, @PathVariable String placeId) {
        return representationService.getBookmarkById(userId, placeId);
    }
}
