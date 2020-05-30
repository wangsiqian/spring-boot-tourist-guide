package com.wangsiqian.tourist.upload.exception;

import com.wangsiqian.tourist.common.exception.ApiException;

/** @author wangsiqian */
public class InvalidFileException extends ApiException {
    public InvalidFileException() {
        super("invalid_file", "不合法的文件");
    }
}
