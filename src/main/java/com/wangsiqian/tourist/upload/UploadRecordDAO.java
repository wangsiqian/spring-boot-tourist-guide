package com.wangsiqian.tourist.upload;

import com.wangsiqian.tourist.upload.model.UploadRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** @author wangsiqian */
@Mapper
public interface UploadRecordDAO {
    /**
     * 记录用户上传
     *
     * @param record 记录
     */
    void createRecord(@Param("record") UploadRecord record);

    /**
     * 查询用户上传记录
     *
     * @param userId 用户ID
     * @param imagePath 图片路径
     * @return 记录主键
     */
    Integer getRecordByUserIdAndPath(
            @Param("userId") String userId, @Param("imagePath") String imagePath);
}
