package com.wangsiqian.tourist.bookmark.model;

import com.wangsiqian.tourist.bookmark.dto.CreateBookmarkDTO;
import com.wangsiqian.tourist.bookmark.representation.BookmarkVO;
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
public class Bookmark {
    private String userId;
    private String placeId;
    private String placeName;
    private String coverUrl;
    private Date createdAt;
    private Date updatedAt;

    public static Bookmark create(CreateBookmarkDTO createBookmarkDTO) {
        return Bookmark.builder()
                .userId(createBookmarkDTO.getUserId())
                .placeId(createBookmarkDTO.getPlaceId())
                .placeName(createBookmarkDTO.getPlaceName())
                .coverUrl(createBookmarkDTO.getCoverUrl())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
    }

    public BookmarkVO toRepresentation() {
        BookmarkVO bookmarkVO = new BookmarkVO();
        bookmarkVO.setPlaceId(placeId);
        bookmarkVO.setPlaceName(placeName);
        bookmarkVO.setCoverUrl(coverUrl);
        bookmarkVO.setCreatedAt(createdAt);
        return bookmarkVO;
    }
}
