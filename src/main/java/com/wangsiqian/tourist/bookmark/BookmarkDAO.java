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

    /**
     * 统计用户的收藏数据
     *
     * @param userId 用户ID
     * @return 统计结果
     */
    Integer countBookmarkByUserId(@Param("userId") String userId);

    /**
     * 通过用户id 和景点id 删除书签
     *
     * @param placeId 景点 id
     * @param userId 用户 id
     */
    void deleteBookmarkById(@Param("userId") String userId, @Param("placeId") String placeId);
}
