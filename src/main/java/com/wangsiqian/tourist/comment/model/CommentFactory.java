package com.wangsiqian.tourist.comment.model;

import com.wangsiqian.tourist.comment.dto.NewCommentDTO;
import org.springframework.stereotype.Component;

/**
 * @author wangsiqian
 */
@Component
public class CommentFactory {
    public Comment create(NewCommentDTO dto) {
        return Comment.create(dto);
    }
}
