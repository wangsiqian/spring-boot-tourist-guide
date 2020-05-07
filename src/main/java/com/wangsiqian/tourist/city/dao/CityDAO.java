package com.wangsiqian.tourist.city.dao;

import com.wangsiqian.tourist.city.model.City;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** @author wangsiqian */
@Mapper
public interface CityDAO {
    /**
     * 创建城市
     *
     * @param city 城市实例
     */
    void createCity(@Param("city") City city);

    /**
     * 根据 城市ID 查询城市
     *
     * @param cityId 城市ID
     * @return 城市实例
     */
    City getCityById(@Param("cityId") String cityId);
}
