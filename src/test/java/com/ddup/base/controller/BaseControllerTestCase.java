package com.ddup.base.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Map;

/**
 *
 * <br>
 * <strong>Time </strong>: 2015年12月15日<br>
 * <strong>History</strong>：<br>
 * Editor　　　version　　　Time　　　　　Operation　　　　　　　Description<br>
 *
 * @author dznzyx
 * @version : 1.0.0
 */
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-context.xml", "classpath:spring-mvc.xml", "classpath:spring-mybatis.xml"})
public class BaseControllerTestCase {
    @Autowired
    protected WebApplicationContext webApplicationContext;
    // mvc
    protected MockMvc mvc;
    // json 解析器
    protected ObjectMapper objectMapper;

    /**
     * 执行前方法
     */
    @Before
    public void before() {
        this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        this.objectMapper = new ObjectMapper();
    }


    // ------------------------------------------------ mock util ----------------------------------------------

    /**
     * mock 模拟请求
     *
     * @param uri   uri
     * @param param 参数
     * @return Json 字符串
     * @throws Exception
     */
    public String mockMvcJson(String uri, Map<String, String> param) throws Exception {
        // 构建请求
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri).characterEncoding("UTF-8").accept(MediaType.APPLICATION_JSON);
        // 附加参数
        if (param != null) {
            for (Map.Entry<String, String> entry : param.entrySet()) {
                requestBuilder.param(entry.getKey(), entry.getValue());
            }
        }
        // mvc
        return this.mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
    }


}
