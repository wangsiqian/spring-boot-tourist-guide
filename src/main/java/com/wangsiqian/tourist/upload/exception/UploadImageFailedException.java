package com.wangsiqian.tourist.upload.exception;

import com.wangsiqian.tourist.common.exception.ApiException;

/** @author wangsiqian */
public class UploadImageFailedException extends ApiException {
    public UploadImageFailedException() {
        super("upload_image_failed", "上传图片失败");
    }
}
