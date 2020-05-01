package com.wangsiqian.tourist.place.model;

import com.wangsiqian.tourist.place.dto.CreatePlaceDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.geo.Point;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/** @author wangsiqian */
@Getter
@Setter
@ToString
@Builder
@Document(indexName = "place", type = "place", replicas = 0)
public class Place {
    @Id private String placeId;
    private String name;
    private String address;
    private String description;
    private String audio;
    private String cityId;

    @Field(type = FieldType.Nested)
    private List<String> images;

    @GeoPointField private Point location;

    private Date createdAt;
    private Date updatedAt;

    public static Place create(CreatePlaceDTO createPlaceDTO) {
        return Place.builder()
                .placeId(UUID.randomUUID().toString())
                .name(createPlaceDTO.getName())
                .cityId(createPlaceDTO.getCityId())
                .description(createPlaceDTO.getDescription())
                .address(createPlaceDTO.getAddress())
                .audio(createPlaceDTO.getAudio())
                .images(createPlaceDTO.getImages())
                .location(new Point(createPlaceDTO.getLatitude(), createPlaceDTO.getLongitude()))
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
    }
}
