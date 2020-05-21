package com.wangsiqian.tourist.bookmark;

import com.alibaba.fastjson.JSONObject;
import com.wangsiqian.tourist.TouristGuideTests;
import com.wangsiqian.tourist.bookmark.dto.CreateBookmarkDTO;
import com.wangsiqian.tourist.bookmark.representation.BookmarkVO;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class BookmarkControllerTests extends TouristGuideTests {
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
        JSONObject response = client.get(String.format("/v1/bookmark/%s", "db3da426-52c1-4f16-87fa-61ac"));
        assertThat(response.get("ok"), equalTo(true));

        List<BookmarkVO> bookmarks = (List<BookmarkVO>) response.get("result");
        assertThat(bookmarks.size(), equalTo(2));
    }
}
