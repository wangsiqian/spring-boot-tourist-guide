package com.wangsiqian.tourist.comment.service.impl;

import com.wangsiqian.tourist.comment.CommentDAO;
import com.wangsiqian.tourist.comment.model.CommentFactory;
import com.wangsiqian.tourist.comment.representation.CommentVO;
import com.wangsiqian.tourist.comment.service.CommentRepresentationService;
import com.wangsiqian.tourist.common.utils.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author wangsiqian */
@Service
@RequiredArgsConstructor
public class CommentRepresentationServiceImpl implements CommentRepresentationService {
    private final CommentDAO commentDAO;

    @Override
    public CommonResult<List<CommentVO>> listCommentByPlaceId(String placeId) {
        return CommonResult.okResponse(commentDAO.listCommentByPlaceId(placeId));
    }
}
