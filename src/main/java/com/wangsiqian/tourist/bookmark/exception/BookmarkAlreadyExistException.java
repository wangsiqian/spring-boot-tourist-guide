package com.wangsiqian.tourist.bookmark.exception;

import com.wangsiqian.tourist.common.exception.ApiException;

/** @author wangsiqian */
public class BookmarkAlreadyExistException extends ApiException {
    public BookmarkAlreadyExistException() {
        super("bookmark_already_exist", "您已经收藏了该景点了");
    }
}
