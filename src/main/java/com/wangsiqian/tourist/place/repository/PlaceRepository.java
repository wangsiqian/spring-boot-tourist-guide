package com.wangsiqian.tourist.place.repository;

import com.wangsiqian.tourist.place.model.Place;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/** @author wangsiqian */
public interface PlaceRepository extends ElasticsearchRepository<Place, String> {
    /**
     * 通过景区ID 获取景点
     *
     * @param sightId 景区ID
     * @return 获取结果
     */
    List<Place> findBySightId(String sightId);

    /**
     * 通过景点名模糊查询
     *
     * @param name 景点名
     * @param pageable 分页
     * @return 查询结果
     */
    List<Place> findByNameLike(String name, Pageable pageable);
}
