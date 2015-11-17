package com.ddup.user.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.ddup.user.service.UserPositionService;

@Service
public class UserPositionServiceImpl implements UserPositionService {

	/*@Autowired
	UserPositionMapper userPositionMapper = null;
	@Autowired
	OauthUsersMapper oauthUsersMapper = null;*/
	
	@Override
	public String commitUserLocation(Map<String, Object> paramMap) {
		// 获取用户ID
		/*Long userId = oauthUsersMapper.getUserIdByUserCode((String)paramMap.get("userCode"));
		paramMap.put("userId", userId);
		// 准备上报参数
		if (paramMap.containsKey("lng") && null != paramMap.get("lng")){
			int level = 7;
			Integer geoLevel = (Integer)paramMap.get("geoLevel");
			if (geoLevel <= 16){
				level = 4;
			} else if (geoLevel > 16 && geoLevel <= 19){
				level = 5;
			} else if (geoLevel > 19 && geoLevel <= 22){
				level = 6;
			} else if (geoLevel > 22){
				level = 7;
			}
			String iwcode = GeoSOTDLL.tranPointToGeoCode((Double)paramMap.get("lat"), 
					(Double)paramMap.get("lng"), level);
			paramMap.put("iwcode", iwcode);
			Long getNum = GeoSOTDLL.PointGridIdentify_D((Double)paramMap.get("lat"), 
					(Double)paramMap.get("lng"), geoLevel);
			paramMap.put("geoNum", getNum);
			paramMap.put("geoLevel", geoLevel);
		} 
		// 上传用户最新位置信息
		int count = userPositionMapper.uploadUserPosition(paramMap);
		// 构建返回JSON
		CommitUserLocationResp001 response = new CommitUserLocationResp001();
		JSONObject resultJson = null;
		if (1 == count){
			response.setServer_status(200);
			resultJson = JSONObject.fromObject(response);
		} else {
			response.setServer_status(200);
			response.setServer_error("更新用户上报位置出错");
			resultJson = JSONObject.fromObject(response);
		}
		return resultJson.toString();*/
		return "ddd";
	}

	@Override
	public String getUserDistribution(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSingleUserPosition(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public String list() {
        
        return null;
    }

}
