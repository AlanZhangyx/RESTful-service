package com.ddup.casual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddup.base.controller.BaseController;
import com.ddup.casual.dto.req.PrivilegeReq;
import com.ddup.casual.dto.req.PrivilegeReq.QueryList;
import com.ddup.casual.dto.resp.PrivilegeResp01;

/**
 * 权限Controller
 * 只有@ResponseBody的方法会被纳入全局异常处理流程
 * <br>
 * <strong>copyright</strong>： 2015, 北京都在哪网讯科技有限公司<br>
 * <strong>Time </strong>: 2015年12月29日<br>
 * <strong>History</strong>：<br>
 * Editor　　　version　　　Time　　　　　Operation　　　　　　　Description<br>
 *
 * @author dznzyx
 * @version : 1.0.0
 */
@Controller
@RequestMapping(value = "/pri", method = { RequestMethod.GET,RequestMethod.PUT })
public class PrivilegeController extends BaseController{
	
	@RequestMapping(value = "/list")
    public @ResponseBody PrivilegeResp01 queryList(@Validated(QueryList.class) PrivilegeReq dtoReq){
		return null;
	}
}
