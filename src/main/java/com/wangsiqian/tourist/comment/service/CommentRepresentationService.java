package com.wangsiqian.tourist.comment.service;

import com.wangsiqian.tourist.comment.representation.CommentVO;
import com.wangsiqian.tourist.common.utils.CommonResult;

import java.util.List;

/** @author wangsiqian */
public interface CommentRepresentationService {
    /**
     * 通过景点ID列出评论内容
     *
     * @param placeId 景点ID
     * @return 查询结果
     */
    CommonResult<List<CommentVO>> listCommentByPlaceId(String placeId);
}
