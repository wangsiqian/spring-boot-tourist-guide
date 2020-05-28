package com.wangsiqian.tourist.sight.model;

import com.wangsiqian.tourist.sight.dto.CreateSightDTO;
import org.springframework.stereotype.Component;

/**
 * @author wangsiqian
 */
@Component
public class SightFactory {
    public Sight create(CreateSightDTO dto) {
        return Sight.create(dto);
    }
}
