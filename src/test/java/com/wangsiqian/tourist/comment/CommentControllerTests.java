package com.wangsiqian.tourist.comment;

import com.wangsiqian.tourist.TouristGuideTests;
import com.wangsiqian.tourist.comment.dto.NewCommentDTO;
import com.wangsiqian.tourist.comment.representation.CommentVO;
import com.wangsiqian.tourist.comment.service.CommentApplicationService;
import com.wangsiqian.tourist.comment.service.CommentRepresentationService;
import com.wangsiqian.tourist.common.utils.CommonResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CommentControllerTests extends TouristGuideTests {
    @Autowired CommentApplicationService applicationService;
    @Autowired CommentRepresentationService representationService;

    @Test(timeout = 10000)
    public void newCommentTest() {
        NewCommentDTO dto = new NewCommentDTO();
        dto.setUserId("def9b1fc-5bd0-4ffe-9ef2-cdee");
        dto.setPlaceId("bbb85611-f653-424d-8e0e-86ab54949f71");
        dto.setContent("这里很好玩");

        // 创建评论
        CommonResult<String> result = applicationService.newComment(dto);
        assertThat(result.isOk(), equalTo(true));
    }

    @Test(timeout = 10000)
    public void listCommentsByPlaceIdTest() {
        NewCommentDTO dto = new NewCommentDTO();
        dto.setUserId("def9b1fc-5bd0-4ffe-9ef2-cdee");
        dto.setPlaceId("bbb85611-f653-424d-8e0e-86ab54949f71");
        dto.setContent("这里很好玩");

        // 创建评论
        applicationService.newComment(dto);
        applicationService.newComment(dto);
        applicationService.newComment(dto);

        // 另一个景点
        dto.setPlaceId("269f8a89-0e23-47aa-8758-2ed4222d52ac");
        applicationService.newComment(dto);

        // 验证评论数为 3
        List<CommentVO> comments =
                representationService
                        .listCommentByPlaceId("bbb85611-f653-424d-8e0e-86ab54949f71")
                        .getResult();
        assertThat(comments.size(), equalTo(3));
    }
}
