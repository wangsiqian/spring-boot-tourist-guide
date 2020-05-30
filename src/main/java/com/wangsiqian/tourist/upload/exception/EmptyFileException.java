package com.wangsiqian.tourist.upload.exception;

import com.wangsiqian.tourist.common.exception.ApiException;

/** @author wangsiqian */
public class EmptyFileException extends ApiException {
    public EmptyFileException() {
        super("empty_file", "上传文件为空");
    }
}
