package com.wangsiqian.tourist.sight;

import com.wangsiqian.tourist.TouristGuideTests;
import com.wangsiqian.tourist.sight.dto.CreateSightDTO;
import com.wangsiqian.tourist.sight.representation.SightVO;
import com.wangsiqian.tourist.sight.service.SightApplicationService;
import com.wangsiqian.tourist.sight.service.SightRepresentationService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SightControllerTests extends TouristGuideTests {
    @Autowired SightApplicationService applicationService;

    @Autowired SightRepresentationService representationService;

    @Autowired SightDAO sightDAO;

    @Test(timeout = 10000)
    public void createSightTest() {
        CreateSightDTO dto = new CreateSightDTO();
        dto.setCityId("00001");
        dto.setCoverUrl("https://www.wangsiqian.com");
        dto.setName("青城山");

        // 创建景区
        applicationService.createSight(dto);

        SightVO sightVO = sightDAO.getSightByNameAndCityId("青城山", "00001");
        Assert.assertThat(sightVO.getName(), Matchers.equalTo("青城山"));
        Assert.assertThat(sightVO.getCoverUrl(), Matchers.equalTo("https://www.wangsiqian.com"));
    }

    @Test(timeout = 10000)
    public void listSightByCityIdTest() {
        CreateSightDTO dto = new CreateSightDTO();
        dto.setCityId("00001");
        dto.setCoverUrl("https://www.wangsiqian.com");
        dto.setName("青城山");

        // 创建景区
        applicationService.createSight(dto);
        dto.setName("都江堰");
        applicationService.createSight(dto);
        // 另一个城市
        dto.setCityId("00002");
        applicationService.createSight(dto);

        List<SightVO> sights = representationService.listSightsByCityId("00001").getResult();
        Assert.assertThat(sights.size(), Matchers.equalTo(2));
    }
}
