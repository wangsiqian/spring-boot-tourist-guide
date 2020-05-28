package com.wangsiqian.tourist.sight.model;

import com.wangsiqian.tourist.sight.dto.CreateSightDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/** @author wangsiqian */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sight {
    private String name;
    private String coverUrl;
    private String cityId;
    private Date createdAt;
    private Date updatedAt;

    public static Sight create(CreateSightDTO dto) {
        return Sight.builder()
                .name(dto.getName())
                .coverUrl(dto.getCoverUrl())
                .cityId(dto.getCityId())
                .build();
    }
}
