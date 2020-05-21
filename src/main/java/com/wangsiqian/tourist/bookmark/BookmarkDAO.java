package com.wangsiqian.tourist.bookmark;

import com.wangsiqian.tourist.bookmark.model.Bookmark;
import com.wangsiqian.tourist.bookmark.representation.BookmarkVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/** @author wangsiqian */
@Mapper
public interface BookmarkDAO {
    /**
     * 创建书签
     *
     * @param bookmark 新书签
     */
    void createBookmark(@Param("bookmark") Bookmark bookmark);

    /**
     * 根据联合唯一索引查询景点
     *
     * @param userId 用户ID
     * @param placeId 收藏的景点ID
     * @return 查询结果
     */
    Bookmark getBookmarkById(@Param("userId") String userId, @Param("placeId") String placeId);

    /**
     * 根据用户ID获取收藏夹
     *
     * @param userId 用户ID
     * @return 获取结果
     */
    ArrayList<BookmarkVO> listBookmarksByUserId(@Param("userId") String userId);
}
