package com.wangsiqian.tourist.bookmark.representation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/** @author wangsiqian */
@Getter
@Setter
@ToString
public class BookmarkVO {
    private String placeId;
    private String placeName;
    private String coverUrl;
    private Date createdAt;
}
