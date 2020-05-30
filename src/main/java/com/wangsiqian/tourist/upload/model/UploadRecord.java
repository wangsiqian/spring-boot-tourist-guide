package com.wangsiqian.tourist.upload.model;

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
public class UploadRecord {
    private String userId;
    private String imagePath;
    private Date createdAt;
    private Date updatedAt;

    public static UploadRecord create(String userId, String imagePath) {
        return UploadRecord.builder()
                .userId(userId)
                .imagePath(imagePath)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
    }
}
