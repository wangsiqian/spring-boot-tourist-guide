package com.wangsiqian.tourist.common.sdk;

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/** @author wangsiqian */
public class GeoSdk {
    public static String getCityNameByPoint(GeoPoint point) {
        RestTemplate restTemplate = new RestTemplate();

        JSONObject response;
        try {
            response =
                    restTemplate.getForObject(
                            "https://h5.ele.me/restapi/bgs/poi/reverse_geo_coding?latitude={1}&longitude={2}",
                            JSONObject.class, point.getLat(), point.getLon());
        } catch (RestClientException error) {
            // 请求失败
            return null;
        }

        if (response != null) {
            return (String) response.get("city");
        } else {
            return null;
        }
    }
}
