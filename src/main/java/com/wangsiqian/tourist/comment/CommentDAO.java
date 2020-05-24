package com.wangsiqian.tourist.comment;

import com.wangsiqian.tourist.comment.model.Comment;
import com.wangsiqian.tourist.comment.representation.CommentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/** @author wangsiqian */
@Mapper
public interface CommentDAO {
    /**
     * 创建新的留言
     *
     * @param comment 留言实体
     */
    void newComment(@Param("comment") Comment comment);

    /**
     * 通过景点ID列出景点评论内容
     *
     * @param placeId 景点ID
     * @return 查询结果
     */
    List<CommentVO> listCommentByPlaceId(@Param("placeId") String placeId);
}
