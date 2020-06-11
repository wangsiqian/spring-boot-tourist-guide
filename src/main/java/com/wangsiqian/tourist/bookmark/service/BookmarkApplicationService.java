package com.wangsiqian.tourist.bookmark.service;

import com.wangsiqian.tourist.bookmark.dto.CreateBookmarkDTO;
import com.wangsiqian.tourist.common.utils.CommonResult;

/** @author wangsiqian */
public interface BookmarkApplicationService {
    /**
     * 创建书签
     *
     * @param createBookmarkDTO 数据载体
     * @return 创建结果
     */
    CommonResult<String> createBookmark(CreateBookmarkDTO createBookmarkDTO);

    /**
     * 通过用户id 和景点id 删除书签
     *
     * @param placeId 景点 id
     * @param userId 用户 id
     * @return 删除结果
     */
    CommonResult<String> deleteBookmarkById(String userId, String placeId);
}
