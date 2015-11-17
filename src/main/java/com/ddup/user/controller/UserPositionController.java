package com.ddup.user.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ddup.base.controller.BaseController;
import com.ddup.tools.Tools;
import com.ddup.user.dto.req.CommitUserLocationReq001;
import com.ddup.user.service.UserPositionService;

@RestController
@RequestMapping(value = "/user/position", produces="application/json;charset=UTF-8",method = {RequestMethod.GET,RequestMethod.PUT})
public class UserPositionController extends BaseController {
    
    @Resource
    private UserPositionService userPositionService;
    
    /**
	 * 用户提交位置
	 **/
	@RequestMapping(value = "/commitUserLocation")
	public String commitUserLocation(CommitUserLocationReq001 bean, Errors errors){
		// bean转Map
		Map<String, Object> beanMap = Tools.transBeanToMap(bean);
		// 用户提交位置服务
		String resultStr = userPositionService.commitUserLocation(beanMap);
		return resultStr;
	}
	
	/**
	 * 用户分布信息
	 **/
	/*@RequestMapping(value = "/getUserDistribution")
	public String getUserDistribution(@Valid GetUserDistributionReq001 bean, Errors errors){
		// bean转Map
		Map<String, Object> beanMap = Tools.transBeanToMap(bean);
		// 用户提交位置服务
		String resultStr = userPositionService.getUserDistribution(beanMap);
		return resultStr;
	}*/
	
	/**
	 * 获取单个用户位置信息
	 **/
	/*@RequestMapping(value = "/getSingleUserPosition")
	public String getSingleUserPosition(@Valid GetSingleUserPositionReq001 bean, Errors errors){
		// bean转Map
		Map<String, Object> beanMap = Tools.transBeanToMap(bean);
		// 用户提交位置服务
		String resultStr = userPositionService.getUserDistribution(beanMap);
		return resultStr;
	}
    */
    
	@RequestMapping(value = "/list")
    public String list(){
        String resultStr = userPositionService.list();
        return resultStr;
    }
     
    
    
    
}