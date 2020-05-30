package com.wangsiqian.tourist.common.utils;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/** @author wangsiqian */
public class ImageChecker {
    public static boolean check(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        if (originalFileName == null || file.isEmpty()) {
            // 是否为空
            return false;
        }

        String invalidPath = "..";
        String fileName = StringUtils.cleanPath(originalFileName);
        if (fileName.contains(invalidPath) || "".equals(originalFileName)) {
            // 判断文件名
            return false;
        }

        BufferedImage inputStream;
        try {
            inputStream = ImageIO.read(file.getInputStream());
        } catch (IOException e) {
            return false;
        }

        // 是否是图片
        return inputStream != null;
    }
}
