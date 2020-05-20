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
    public CommonResult<String> createBookmark(CreateBookmarkDTO createBookmarkDTO);
}
