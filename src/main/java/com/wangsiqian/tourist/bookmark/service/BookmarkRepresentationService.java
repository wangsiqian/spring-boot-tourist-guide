package com.wangsiqian.tourist.bookmark.service;

import com.wangsiqian.tourist.bookmark.representation.BookmarkVO;
import com.wangsiqian.tourist.common.utils.CommonResult;

import java.util.List;

/** @author wangsiqian */
public interface BookmarkRepresentationService {
    /**
     * 根据用户ID列出收藏夹
     *
     * @param userId 用户ID
     * @return 查询结果
     */
    public CommonResult<List<BookmarkVO>> listBookmarksByUserId(String userId);
}
