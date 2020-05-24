package com.wangsiqian.tourist.comment.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** @author wangsiqian */
@Getter
@Setter
@ToString
public class NewCommentDTO {
    @NotNull private String placeId;

    @NotNull
    @Size(max = 255)
    private String content;

    private String userId;
}
