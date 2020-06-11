package com.wangsiqian.tourist.bookmark;

import com.alibaba.fastjson.JSONObject;
import com.wangsiqian.tourist.TouristGuideTests;
import com.wangsiqian.tourist.bookmark.dto.CreateBookmarkDTO;
import com.wangsiqian.tourist.bookmark.representation.BookmarkVO;
import com.wangsiqian.tourist.bookmark.service.BookmarkRepresentationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class BookmarkControllerTests extends TouristGuideTests {
    @Autowired BookmarkRepresentationService representationService;

    @Test(timeout = 10000)
    public void createBookmarkTest() throws Exception {
        CreateBookmarkDTO body = new CreateBookmarkDTO();
        body.setUserId("db3da426-52c1-4f16-87fa-61ac");
        body.setPlaceId("5505dc6d-5c06-4110-92ae-9b39eb9eaa67");
        body.setPlaceName("青城山");
        body.setCoverUrl("http://www.wangsiqian.com");
        // 创建收藏夹
        client.post("/v1/bookmark", body);

        // 再次创建
        JSONObject response = client.post("/v1/bookmark", body);
        assertThat(response.get("message"), equalTo("您已经收藏了该景点了"));
        assertThat(response.get("result"), equalTo("bookmark_already_exist"));
    }

    @Test(timeout = 10000)
    public void listBookmarksTest() throws Exception {
        CreateBookmarkDTO body = new CreateBookmarkDTO();
        body.setUserId("db3da426-52c1-4f16-87fa-61ac");
        body.setPlaceId("5505dc6d-5c06-4110-92ae-9b39eb9eaa67");
        body.setPlaceName("青城山");
        body.setCoverUrl("http://www.wangsiqian.com");
        // 创建收藏夹
        client.post("/v1/bookmark", body);
        body.setPlaceId("ed77ed8d-5ccf-4787-8ae7-f862277f4ce1");
        client.post("/v1/bookmark", body);

        // 列出收藏夹
        JSONObject response =
                client.get(String.format("/v1/bookmark/%s", "db3da426-52c1-4f16-87fa-61ac"));
        assertThat(response.get("ok"), equalTo(true));

        List<BookmarkVO> bookmarks = (List<BookmarkVO>) response.get("result");
        assertThat(bookmarks.size(), equalTo(2));
    }

    @Test
    public void deleteBookmarkByIdTest() throws Exception {
        String userId = "db3da426-52c1-4f16-87fa-61ac";
        String placeId = "5505dc6d-5c06-4110-92ae-9b39eb9eaa67";

        CreateBookmarkDTO body = new CreateBookmarkDTO();
        body.setUserId(userId);
        body.setPlaceId(placeId);
        body.setPlaceName("青城山");
        body.setCoverUrl("http://www.wangsiqian.com");
        // 创建收藏夹
        client.post("/v1/bookmark", body);
        assertThat(
                representationService.listBookmarksByUserId(userId).getResult().size(), equalTo(1));

        // 删除
        client.delete(String.format("/v1/bookmark/%s/place/%s", userId, placeId), null);
        assertThat(
                representationService.listBookmarksByUserId(userId).getResult().size(), equalTo(0));
    }
}
