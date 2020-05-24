package com.wangsiqian.tourist.comment.service.impl;

import com.wangsiqian.tourist.comment.CommentDAO;
import com.wangsiqian.tourist.comment.dto.NewCommentDTO;
import com.wangsiqian.tourist.comment.model.Comment;
import com.wangsiqian.tourist.comment.model.CommentFactory;
import com.wangsiqian.tourist.comment.service.CommentApplicationService;
import com.wangsiqian.tourist.common.utils.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author wangsiqian */
@Service
@RequiredArgsConstructor
public class CommentApplicationServiceImpl implements CommentApplicationService {
    private final CommentFactory commentFactory;
    private final CommentDAO commentDAO;

    @Override
    public CommonResult<String> newComment(NewCommentDTO newCommentDTO) {
        Comment comment = commentFactory.create(newCommentDTO);
        commentDAO.newComment(comment);

        return CommonResult.okResponse();
    }
}
