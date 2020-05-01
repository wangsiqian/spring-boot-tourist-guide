package com.wangsiqian.tourist.place.repository;

import com.wangsiqian.tourist.place.model.Place;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/** @author wangsiqian */
public interface PlaceRepository extends ElasticsearchRepository<Place, String> {}
