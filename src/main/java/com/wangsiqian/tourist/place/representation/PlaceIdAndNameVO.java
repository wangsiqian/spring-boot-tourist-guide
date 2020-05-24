package com.wangsiqian.tourist.place.representation;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** @author wangsiqian */
@Getter
@Setter
@ToString
@Builder
public class PlaceIdAndNameVO {
    private String placeId;
    private String name;
}
