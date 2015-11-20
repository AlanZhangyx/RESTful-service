package com.ddup.user.service;

import java.util.Map;

import com.ddup.base.service.BaseService;

public interface UserPositionService extends BaseService {
	/** 用户上报位置 */
	public String commitUserLocation(Map<String,Object> paramMap);
	/** 获取用户分布 */
	public String getUserDistribution(final Map<String,Object> paramMap);
	/** 获取单个用户位置信息 */
	public String getSingleUserPosition(Map<String,Object> paramMap);
	
	public String list();
}
