package com.wangsiqian.tourist.common.config;

import com.wangsiqian.tourist.common.properties.FileProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/** @author wangsiqian */
@Configuration
@EnableConfigurationProperties(FileProperties.class)
public class FileUploadConfig {}
