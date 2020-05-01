package com.wangsiqian.tourist;

import com.alibaba.fastjson.JSONObject;

import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class Client {
    public MockMvc mockMvc;
    public MockHttpSession session;

    public Client(MockMvc mockMvc, MockHttpSession session) {
        this.mockMvc = mockMvc;
        this.session = session;
    }

    /**
     * 自定义请求
     *
     * @param builders 自定义请求构建
     * @return json 响应结果
     * @throws Exception 请求异常
     */
    public JSONObject perform(MockHttpServletRequestBuilder builders) throws Exception {
        ResultActions resultActions =
                mockMvc.perform(
                                builders.contentType(MediaType.APPLICATION_JSON)
                                        .accept(MediaType.APPLICATION_JSON)
                                        .session(session))
                        .andExpect(MockMvcResultMatchers.status().isOk());
        return getJson(resultActions);
    }

    /**
     * get 请求
     *
     * @param url 目标 url
     * @return json 响应结果
     * @throws Exception 请求异常
     */
    public JSONObject get(String url) throws Exception {
        ResultActions resultActions =
                mockMvc.perform(
                                MockMvcRequestBuilders.get(url)
                                        .accept(MediaType.APPLICATION_JSON)
                                        .session(session))
                        .andExpect(MockMvcResultMatchers.status().isOk());

        return getJson(resultActions);
    }

    /**
     * post 请求
     *
     * @param url 目标 url
     * @param object 数据传输对象
     * @return json 响应结果
     * @throws Exception 请求异常
     */
    public JSONObject post(String url, Object object) throws Exception {
        ResultActions resultActions =
                mockMvc.perform(
                                MockMvcRequestBuilders.post(url)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .content(JSONObject.toJSONString(object))
                                        .accept(MediaType.APPLICATION_JSON)
                                        .session(session))
                        .andExpect(MockMvcResultMatchers.status().isOk());

        return getJson(resultActions);
    }

    /**
     * put 请求
     *
     * @param url 目标 url
     * @param object 数据传输对象
     * @return json 响应结果
     * @throws Exception 请求异常
     */
    public JSONObject put(String url, Object object) throws Exception {
        ResultActions resultActions =
                mockMvc.perform(
                                MockMvcRequestBuilders.put(url)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .content(JSONObject.toJSONString(object))
                                        .accept(MediaType.APPLICATION_JSON)
                                        .session(session))
                        .andExpect(MockMvcResultMatchers.status().isOk());

        return getJson(resultActions);
    }

    /**
     * delete 请求
     *
     * @param url 目标 url
     * @param object 数据传输对象
     * @return json 响应结果
     * @throws Exception 请求异常
     */
    public JSONObject delete(String url, Object object) throws Exception {
        ResultActions resultActions =
                mockMvc.perform(
                                MockMvcRequestBuilders.delete(url)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .content(JSONObject.toJSONString(object))
                                        .accept(MediaType.APPLICATION_JSON)
                                        .session(session))
                        .andExpect(MockMvcResultMatchers.status().isOk());

        return getJson(resultActions);
    }

    /**
     * 获取 json result
     *
     * @param resultActions result
     * @return json result
     */
    private JSONObject getJson(ResultActions resultActions) {
        if (resultActions == null) {
            return null;
        }

        byte[] content = resultActions.andReturn().getResponse().getContentAsByteArray();
        return (JSONObject) JSONObject.parse(content);
    }
}
