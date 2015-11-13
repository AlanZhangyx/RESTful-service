package com.iwhere.iaddress.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iwhere.base.controller.BaseControllerTestCase;
import com.iwhere.base.dto.resp.BaseResp;
import com.iwhere.istar.dto.resp.TestResp;

/**
 * <br>
 * <strong>copyright</strong>： 2015, 成都都在哪网讯科技有限公司<br>
 * <strong>Time </strong>: 2015/11/3 10:48<br>
 * <strong>History</strong>：<br>
 * Editor　　　version　　　Time　　　　　Operation　　　　　　　Description<br>
 *
 * @author hewei
 * @version : 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TestControllerTest extends BaseControllerTestCase {

    @Test
    public void testGetJsonResp() throws Exception {
        String json = this.mockMvcJson("/iaddress/test/getJsonResp", null);
        // Json 解析
        TestResp resp = objectMapper.readValue(json, TestResp.class);
        // 验证
        assertEquals("返回状态正常", resp.getServer_status(), 200);
        assertNotNull("list返回正常", resp.getList());
        for (int i = 0; i < resp.getList().size(); i++){
            assertEquals("子List正常", resp.getList().get(i).getPhotoId(), Long.valueOf(i));
        }
    }

    @Test
    public void testGetValiResp() throws Exception {
        // --------------------------- 测试普通后台验证 ---------------------------
        String json = this.mockMvcJson("/iaddress/test/getValiResp", null);
        // Json 解析
        BaseResp resp = objectMapper.readValue(json, BaseResp.class);
        // 验证
        assertEquals("验证异常", resp.getServer_status(), BaseResp.STATUS_ERROR_VALIDATE);

        // --------------------------- 验证异常国际化 ---------------------------
        Map<String, String> param = new HashMap<String, String>();
        param.put("accessToken", "000a391e74ea2aa29635e6e4c4be73dcc6dacc75");
        json = this.mockMvcJson("/iaddress/test/getValiResp", param);
        // Json解析
        resp = objectMapper.readValue(json, BaseResp.class);
        // 验证
        assertEquals("国际化验证", resp.getServer_error(), "地址ID不能为空");

        // --------------------------- 验证异常国际化带入参数 ---------------------------
        param.put("addressId", "99");
        json = this.mockMvcJson("/iaddress/test/getValiResp", param);
        // Json解析
        resp = objectMapper.readValue(json, BaseResp.class);
        // 验证
        assertEquals("国际化带入参数", resp.getServer_error(), "地址ID范围1到9");

    }

    @Test
    public void testGetYwException() throws Exception {

    }

    @Test
    public void testGetI18n() throws Exception {

    }

    @Test
    public void testGetI18n00() throws Exception {

    }
}