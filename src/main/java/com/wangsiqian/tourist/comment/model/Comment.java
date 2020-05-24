package com.wangsiqian.tourist.comment.model;

import com.wangsiqian.tourist.comment.dto.NewCommentDTO;
import com.wangsiqian.tourist.common.utils.UuidGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/** @author wangsiqian */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private String commentId;
    private String placeId;
    private String userId;
    private String content;
    private Date createdAt;
    private Date updatedAt;

    public static Comment create(NewCommentDTO dto) {
        return Comment.builder()
                .commentId(UuidGenerator.newUuid())
                .placeId(dto.getPlaceId())
                .userId(dto.getUserId())
                .content(dto.getContent())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
    }
}
