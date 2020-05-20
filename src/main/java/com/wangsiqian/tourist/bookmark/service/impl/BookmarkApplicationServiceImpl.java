package com.wangsiqian.tourist.bookmark.service.impl;

import com.wangsiqian.tourist.bookmark.BookmarkDAO;
import com.wangsiqian.tourist.bookmark.dto.CreateBookmarkDTO;
import com.wangsiqian.tourist.bookmark.exception.BookmarkAlreadyExistException;
import com.wangsiqian.tourist.bookmark.model.Bookmark;
import com.wangsiqian.tourist.bookmark.model.BookmarkFactory;
import com.wangsiqian.tourist.bookmark.service.BookmarkApplicationService;
import com.wangsiqian.tourist.common.utils.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** @author wangsiqian */
@Service
@RequiredArgsConstructor
public class BookmarkApplicationServiceImpl implements BookmarkApplicationService {
    private final BookmarkFactory bookmarkFactory;
    private final BookmarkDAO bookmarkDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonResult<String> createBookmark(CreateBookmarkDTO createBookmarkDTO) {
        if (bookmarkDAO.getBookmarkById(
                        createBookmarkDTO.getUserId(), createBookmarkDTO.getPlaceId())
                != null) {
            // 看是否已经收藏了该景点
            throw new BookmarkAlreadyExistException();
        }

        Bookmark bookmark = bookmarkFactory.create(createBookmarkDTO);
        bookmarkDAO.createBookmark(bookmark);
        return CommonResult.okResponse();
    }
}
