package com.wangsiqian.tourist.bookmark.service.impl;

import com.wangsiqian.tourist.bookmark.BookmarkDAO;
import com.wangsiqian.tourist.bookmark.exception.BookmarkNotFoundException;
import com.wangsiqian.tourist.bookmark.model.Bookmark;
import com.wangsiqian.tourist.bookmark.representation.BookmarkVO;
import com.wangsiqian.tourist.bookmark.service.BookmarkRepresentationService;
import com.wangsiqian.tourist.common.utils.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author wangsiqian */
@Service
@RequiredArgsConstructor
public class BookmarkRepresentationServiceImpl implements BookmarkRepresentationService {
    private final BookmarkDAO bookmarkDAO;

    @Override
    public CommonResult<List<BookmarkVO>> listBookmarksByUserId(String userId) {
        return CommonResult.okResponse(bookmarkDAO.listBookmarksByUserId(userId));
    }

    @Override
    public CommonResult<Boolean> getBookmarkStatus(String userId, String placeId) {
        Bookmark bookmark = bookmarkDAO.getBookmarkById(userId, placeId);
        boolean result = true;
        if (bookmark == null) {
            // 不存在
            result = false;
        }

        return CommonResult.okResponse(result);
    }
}
