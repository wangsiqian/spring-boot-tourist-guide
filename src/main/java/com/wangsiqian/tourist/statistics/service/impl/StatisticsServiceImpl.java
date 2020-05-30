package com.wangsiqian.tourist.statistics.service.impl;

import com.wangsiqian.tourist.bookmark.BookmarkDAO;
import com.wangsiqian.tourist.common.utils.CommonResult;
import com.wangsiqian.tourist.statistics.representation.StatisticsVO;
import com.wangsiqian.tourist.statistics.service.StatisticsService;
import com.wangsiqian.tourist.upload.UploadRecordDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/** @author wangsiqian */
@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {
    private final BookmarkDAO bookmarkDAO;
    private final UploadRecordDAO uploadRecordDAO;

    @Override
    public CommonResult<StatisticsVO> getStatisticsByUserId(String userId) {
        Integer bookmarkCount = bookmarkDAO.countBookmarkByUserId(userId);
        Integer imageCount = uploadRecordDAO.countImageByUserId(userId);

        StatisticsVO statisticsVO = new StatisticsVO();
        statisticsVO.setBookmarkCount(bookmarkCount);
        statisticsVO.setImageCount(imageCount);

        return CommonResult.okResponse(statisticsVO);
    }
}
