package com.wangsiqian.tourist.place.representation;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.List;

/**
 * 景点简短介绍
 *
 * @author wangsiqian
 */
@Getter
@Setter
@ToString
@Builder
public class PlaceIntroductionVO {
    private String placeId;
    private String name;
    private String description;
    private String image;
}
