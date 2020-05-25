package com.wangsiqian.tourist.utils;

import org.elasticsearch.ElasticsearchStatusException;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.client.RestClients;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.io.IOException;

@Component
public class ElasticsearchTestUtils {

    @Value("${tourist.elasticsearch.hostAndPort}")
    private String hostAndPort;

    public RestHighLevelClient restHighLevelClient() {
        return RestClients.create(ClientConfiguration.builder().connectedTo(hostAndPort).build())
                .rest();
    }

    public void deleteIndices(String... indexes) {
        if (ObjectUtils.isEmpty(indexes)) {
            return;
        }

        try (RestHighLevelClient client = restHighLevelClient()) {
            for (String index : indexes) {
                try {

                    client.indices().delete(new DeleteIndexRequest(index), RequestOptions.DEFAULT);
                } catch (ElasticsearchStatusException ignored) {
                    // ignore
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createIndices(Class<?>... indexes) {
        if (ObjectUtils.isEmpty(indexes)) {
            return;
        }

        try (RestHighLevelClient client = restHighLevelClient()) {
            ElasticsearchRestTemplate restTemplate = new ElasticsearchRestTemplate(client);

            try {
                for (Class<?> index : indexes) {
                    restTemplate.createIndex(index);
                }
            } catch (ElasticsearchStatusException ignored) {
                // ignore
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
