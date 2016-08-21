package com.ddup.casual.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddup.base.controller.BaseController;
import com.ddup.casual.dao.PrivilegeMapper;
import com.ddup.casual.dao.model.Privilege;
import com.ddup.casual.dto.req.PrivilegeReq;
import com.ddup.casual.dto.req.PrivilegeReq.QueryList;
import com.ddup.casual.dto.resp.PrivilegeResp01;

/**
 * 权限Controller
 * 只有@ResponseBody的方法会被纳入全局异常处理流程
 * <br>
 * <strong>Time </strong>: 2015年12月29日<br>
 * <strong>History</strong>：<br>
 * Editor　　　version　　　Time　　　　　Operation　　　　　　　Description<br>
 *
 * @author dznzyx
 * @version : 1.0.0
 */
@Controller
@RequestMapping(value = "/pri", method = { RequestMethod.GET,RequestMethod.POST })
public class PrivilegeController extends BaseController{
	
	@Autowired
	private PrivilegeMapper priDao;
		
	@RequestMapping(value = "/list")
	public @ResponseBody PrivilegeResp01 queryList(@Validated(QueryList.class) PrivilegeReq dtoReq){
		System.out.println("111");
		return new PrivilegeResp01();
	}
	
	@RequestMapping(value = "/test")
	public @ResponseBody PrivilegeResp01 queryList(){
		System.out.println("12");
		return new PrivilegeResp01();
	}
	
	@RequestMapping(value = "/test/insert")
	public void testInsert(Privilege record){
		priDao.insertSelective(record);
	}
	
	@RequestMapping(value = "/test/list")
	public @ResponseBody List<Privilege> testList(){
		List<Privilege> list = priDao.list();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId());
		}
		return list;
	}
	
	@RequestMapping(value = "/test/json")
	public @ResponseBody Map<String, Object> testJson(){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> attributeMap = new HashMap<String, Object>();
		Map<String, Object> object = new HashMap<String, Object>();
		object.put("haha", 123);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list.add(object);
		attributeMap.put("list_a", list);
		result.put("map", attributeMap);
		return result;
	}
}