package com.wangsiqian.tourist.common.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchEntityMapper;
import org.springframework.data.elasticsearch.core.EntityMapper;

/** @author wangsiqian */
@Configuration
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

    @Value("${tourist.elasticsearch.hostAndPort}")
    private String hostAndPort;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration =
                ClientConfiguration.builder().connectedTo(hostAndPort).build();

        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    @Override
    public EntityMapper entityMapper() {
        ElasticsearchEntityMapper entityMapper =
                new ElasticsearchEntityMapper(
                        elasticsearchMappingContext(), new DefaultConversionService());
        entityMapper.setConversions(elasticsearchCustomConversions());
        return entityMapper;
    }
}
