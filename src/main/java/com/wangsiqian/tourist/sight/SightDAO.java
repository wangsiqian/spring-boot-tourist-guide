package com.wangsiqian.tourist.sight;

import com.wangsiqian.tourist.sight.model.Sight;
import com.wangsiqian.tourist.sight.representation.SightVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/** @author wangsiqian */
@Mapper
public interface SightDAO {
    /**
     * 新景区
     *
     * @param sight 景区实体
     */
    void createSight(@Param("sight") Sight sight);

    /**
     * 通过城市ID 和景区名获取景区
     *
     * @param name 景区名
     * @param cityId 城市ID
     * @return 返回结果
     */
    SightVO getSightByNameAndCityId(@Param("name") String name, @Param("cityId") String cityId);

    /**
     * 根据城市ID列出景区
     *
     * @param cityId 城市ID
     * @return 景区集合
     */
    ArrayList<SightVO> listSightsByCityId(@Param("cityId") String cityId);
}
