package com.wangsiqian.tourist.place.representation;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.List;

/** @author wangsiqian */
@Getter
@Setter
@ToString
@Builder
public class PlaceRepresentation {
    private String placeId;
    private String name;
    private String address;
    private String description;
    private String audio;
    private String sightId;
    private List<String> images;
    private GeoPoint location;
}
