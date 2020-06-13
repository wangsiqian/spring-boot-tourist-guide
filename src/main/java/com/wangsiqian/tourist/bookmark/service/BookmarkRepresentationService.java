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
    CommonResult<List<BookmarkVO>> listBookmarksByUserId(String userId);

    /**
     * 判断是否已经收藏
     *
     * @param userId 用户 id
     * @param placeId 景点 id
     * @return 收藏结果
     */
    CommonResult<Boolean> getBookmarkStatus(String userId, String placeId);
}
