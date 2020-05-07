package com.wangsiqian.tourist.city;

import com.wangsiqian.tourist.city.representation.CityVO;
import com.wangsiqian.tourist.city.model.City;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

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

    /**
     * 通过城市名查找
     *
     * @param name 城市名
     * @return 城市
     */
    City getCityByName(@Param("name") String name);

    /**
     * 列出所有城市（暂时不用分页）
     *
     * @return 城市集
     */
    ArrayList<CityVO> listCities();
}
