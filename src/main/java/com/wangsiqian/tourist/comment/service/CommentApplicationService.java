package com.wangsiqian.tourist.comment.service;

import com.wangsiqian.tourist.comment.dto.NewCommentDTO;
import com.wangsiqian.tourist.common.utils.CommonResult;

import java.util.List;

/** @author wangsiqian */
public interface CommentApplicationService {
    /**
     * 创建留言
     *
     * @param newCommentDTO 新的留言数据
     * @return 创建结果
     */
    CommonResult<String> newComment(NewCommentDTO newCommentDTO);
}
