package com.ddup.casual.controller;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ddup.base.controller.BaseControllerTestCase;
import com.ddup.base.dto.resp.BaseResp;

/**
 *
 * <br>
 * <strong>copyright</strong>： 2015, 北京都在哪网讯科技有限公司<br>
 * <strong>Time </strong>: 2015年12月15日<br>
 * <strong>History</strong>：<br>
 * Editor　　　version　　　Time　　　　　Operation　　　　　　　Description<br>
 *
 * @author dznzyx
 * @version : 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CasualControllerTest extends BaseControllerTestCase {
	
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
}
