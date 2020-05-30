package com.wangsiqian.tourist.upload.model;

import org.springframework.stereotype.Component;

/** @author wangsiqian */
@Component
public class UploadRecordFactory {
    public UploadRecord create(String userId, String imagePath) {
        return UploadRecord.create(userId, imagePath);
    }
}
