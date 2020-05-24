package com.wangsiqian.tourist.comment.controller;

import com.wangsiqian.tourist.comment.dto.NewCommentDTO;
import com.wangsiqian.tourist.comment.representation.CommentVO;
import com.wangsiqian.tourist.comment.service.CommentApplicationService;
import com.wangsiqian.tourist.comment.service.CommentRepresentationService;
import com.wangsiqian.tourist.common.utils.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** @author wangsiqian */
@RestController
@RequestMapping("/v1/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentApplicationService applicationService;
    private final CommentRepresentationService representationService;

    @PostMapping
    public CommonResult<String> newComment(@Validated @RequestBody NewCommentDTO dto) {
        return applicationService.newComment(dto);
    }

    @GetMapping("/place/{placeId}")
    public CommonResult<List<CommentVO>> listCommentByPlaceId(@PathVariable String placeId) {
        return representationService.listCommentByPlaceId(placeId);
    }
}
