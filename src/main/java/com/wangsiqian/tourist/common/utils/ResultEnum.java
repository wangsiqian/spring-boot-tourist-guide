package com.wangsiqian.tourist.common.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** @author wangsiqian */
@Getter
@AllArgsConstructor
public enum ResultEnum {
    // 默认调用成功返回
    SUCCESS(true, "", ""),
    // 默认调用失败返回
    FAILED(false, "", ""),
    // 默认参数验证失败返回
    VALIDATE_FAILED(false, "数据验证失败", "");

    private final boolean ok;
    private final String message;
    private final String result;
}
