package com.wangsiqian.tourist.session;

import com.alibaba.fastjson.JSONObject;
import com.wangsiqian.tourist.TouristGuideTests;
import com.wangsiqian.tourist.common.security.AdminProperties;
import com.wangsiqian.tourist.session.dto.LoginDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class SessionControllerTests extends TouristGuideTests {

    @Autowired AdminProperties adminProperties;

    @Test(timeout = 10000)
    public void loginTest() throws Exception {
        // admin 账号密码
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setPassword(adminProperties.getPassword());
        loginDTO.setUsername(adminProperties.getUsername());

        JSONObject response = client.post("/v1/login", loginDTO);

        assertThat(response.get("ok"), equalTo(true));
        // token 不为空
        assertThat(response.get("result"), notNullValue());
    }
}
