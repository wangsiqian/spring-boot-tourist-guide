package com.wangsiqian.tourist.upload.service.impl;

import com.wangsiqian.tourist.common.properties.FileProperties;
import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.common.utils.ImageChecker;
import com.wangsiqian.tourist.upload.UploadRecordDAO;
import com.wangsiqian.tourist.upload.dto.UploadFileDTO;
import com.wangsiqian.tourist.upload.exception.InvalidFileException;
import com.wangsiqian.tourist.upload.exception.UploadImageFailedException;
import com.wangsiqian.tourist.upload.model.UploadRecord;
import com.wangsiqian.tourist.upload.model.UploadRecordFactory;
import com.wangsiqian.tourist.upload.service.UploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/** @author wangsiqian */
@Service
@Log4j2
@RequiredArgsConstructor
public class UploadServiceImpl implements UploadService {
    private final FileProperties fileProperties;
    private final UploadRecordFactory uploadRecordFactory;
    private final UploadRecordDAO uploadRecordDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonResult<String> uploadImage(UploadFileDTO dto) {
        MultipartFile file = dto.getFile();
        if (!ImageChecker.check(file)) {
            // 检查是否为图片
            throw new InvalidFileException();
        }

        // 生成目录
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String filePath =
                fileProperties.getImagePath()
                        + dto.getUserId()
                        + new SimpleDateFormat("/yyyy/MM/dd/").format(new Date());
        Path fileStorageLocation = Paths.get(filePath).toAbsolutePath().normalize();
        Path targetLocation = fileStorageLocation.resolve(fileName);
        try {
            if (!Files.exists(fileStorageLocation)) {
                // 不存在则创建文件夹
                Files.createDirectories(fileStorageLocation);
            }
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException error) {
            throw new UploadImageFailedException();
        }

        String userId = dto.getUserId();
        String imagePath = filePath + fileName;
        if (uploadRecordDAO.getRecordByUserIdAndPath(userId, imagePath) == null) {
            // 不存在则记录数据
            UploadRecord record = uploadRecordFactory.create(userId, imagePath);
            uploadRecordDAO.createRecord(record);
        }
        return CommonResult.okResponse();
    }
}
