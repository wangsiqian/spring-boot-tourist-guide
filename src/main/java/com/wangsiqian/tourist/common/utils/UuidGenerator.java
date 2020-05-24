package com.wangsiqian.tourist.common.utils;

import java.util.UUID;

/** @author wangsiqian */
public class UuidGenerator {
    public static String newUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
