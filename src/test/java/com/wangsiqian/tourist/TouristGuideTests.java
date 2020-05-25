package com.wangsiqian.tourist;

import com.wangsiqian.tourist.place.model.Place;
import com.wangsiqian.tourist.utils.Client;
import com.wangsiqian.tourist.utils.ElasticsearchTestUtils;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(webEnvironment = RANDOM_PORT)
public abstract class TouristGuideTests {
    @Autowired public WebApplicationContext webApplicationContext;
    @Autowired public ElasticsearchTestUtils elasticsearchTestUtils;

    public Client client;

    @Before
    public void setup() {
        client =
                new Client(
                        MockMvcBuilders.webAppContextSetup(webApplicationContext).build(),
                        new MockHttpSession());

        deleteIndices();

        elasticsearchTestUtils.createIndices(Place.class);
    }

    @AfterEach
    public void after() {
        deleteIndices();
    }

    private void deleteIndices() {
        elasticsearchTestUtils.deleteIndices("place");
    }
}
