package com.wangsiqian.tourist.bookmark.model;

import com.wangsiqian.tourist.bookmark.dto.CreateBookmarkDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

/** @author wangsiqian */
@Component
public class BookmarkFactory {
    public Bookmark create(CreateBookmarkDTO createBookmarkDTO) {
        return Bookmark.create(createBookmarkDTO);
    }
}
