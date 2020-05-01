package com.wangsiqian.tourist.place.model;

import com.wangsiqian.tourist.place.dto.CreatePlaceDTO;
import org.springframework.stereotype.Component;

/** @author wangsiqian */
@Component
public class PlaceFactory {
    public Place create(CreatePlaceDTO createPlaceDTO) {
        return Place.create(createPlaceDTO);
    }
}
