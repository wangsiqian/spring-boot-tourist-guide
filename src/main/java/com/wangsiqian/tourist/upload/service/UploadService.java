package com.wangsiqian.tourist.upload.service;

import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.upload.dto.UploadFileDTO;

/** @author wangsiqian */
public interface UploadService {
    /**
     * 用户上传图片
     *
     * @param dto 图片数据
     * @return 上传结果
     */
    CommonResult<String> uploadImage(UploadFileDTO dto);
}
