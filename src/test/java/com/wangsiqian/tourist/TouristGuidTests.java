package com.wangsiqian.tourist;

import org.junit.Before;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
class TouristGuidTests {
    @Autowired public WebApplicationContext webApplicationContext;
    public Client client;

    @Before
    public void setup() {
        client =
                new Client(
                        MockMvcBuilders.webAppContextSetup(webApplicationContext).build(),
                        new MockHttpSession());
    }
}
