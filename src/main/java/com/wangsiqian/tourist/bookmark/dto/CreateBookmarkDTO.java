package com.wangsiqian.tourist.bookmark.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/** @author wangsiqian */
@Getter
@Setter
@ToString
public class CreateBookmarkDTO {
    @NotNull private String userId;
    @NotNull private String placeId;
    @NotNull private String placeName;
    @NotNull private String coverUrl;
}
