package com.wangsiqian.tourist.bookmark.exception;

import com.wangsiqian.tourist.common.exception.ApiException;

/** @author wangsiqian */
public class BookmarkNotFoundException extends ApiException {
    public BookmarkNotFoundException() {
        super("bookmark_not_found", "您还没有收藏该景点");
    }
}
