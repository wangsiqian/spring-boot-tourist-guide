package com.wangsiqian.tourist.place.model;

import com.wangsiqian.tourist.place.dto.CreatePlaceDTO;
import com.wangsiqian.tourist.place.representation.PlaceIdAndNameVO;
import com.wangsiqian.tourist.place.representation.PlaceIntroductionVO;
import com.wangsiqian.tourist.place.representation.PlaceRepresentation;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/** @author wangsiqian */
@Getter
@Setter
@ToString
@Builder
@TypeAlias("place")
@Document(indexName = "place", type = "place", shards = 1, replicas = 0)
public class Place {
    @Id
    @Field(type = FieldType.Keyword)
    private String placeId;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String address;

    @Field(type = FieldType.Text)
    private String description;

    private String audio;

    @Field(type = FieldType.Keyword)
    private String sightId;

    @Field(type = FieldType.Nested)
    private List<String> images;

    private GeoPoint location;

    @Field(type = FieldType.Date)
    private Date createdAt;

    @Field(type = FieldType.Date)
    private Date updatedAt;

    public static Place create(CreatePlaceDTO createPlaceDTO) {
        return Place.builder()
                .placeId(UUID.randomUUID().toString())
                .name(createPlaceDTO.getName())
                .sightId(createPlaceDTO.getSightId())
                .description(createPlaceDTO.getDescription())
                .address(createPlaceDTO.getAddress())
                .audio(createPlaceDTO.getAudio())
                .images(createPlaceDTO.getImages())
                .location(new GeoPoint(createPlaceDTO.getLatitude(), createPlaceDTO.getLongitude()))
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
    }

    public PlaceRepresentation toRepresentation() {
        return PlaceRepresentation.builder()
                .placeId(placeId)
                .name(name)
                .address(address)
                .description(description)
                .audio(audio)
                .sightId(sightId)
                .images(images)
                .location(location)
                .build();
    }

    public PlaceIdAndNameVO remainIdAndName() {
        return PlaceIdAndNameVO.builder().placeId(placeId).name(name).build();
    }

    public PlaceIntroductionVO toIntroduction() {
        String image = "";
        if (images.size() != 0) {
            image = images.get(0);
        }

        return PlaceIntroductionVO.builder()
                .placeId(placeId)
                .name(name)
                .image(image)
                .description(description)
                .build();
    }
}
