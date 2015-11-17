package com.ddup.user.dto.req;

import com.ddup.base.dto.req.BaseReq;

/**
 * 接口：0001_0001_0003获取单个用户位置信息接口
 * <br>
 * <strong>copyright</strong>： 2015, 北京都在哪网讯科技有限公司<br>
 * <strong>Time </strong>: 2015年11月16日<br>
 * <strong>History</strong>：<br>
 * Editor　　　version　　　Time　　　　　Operation　　　　　　　Description<br>
 *
 * @author dznzyx
 * @version : 1.0.0
 */
public class GetSingleUserPositionReq001 extends BaseReq {
	/** 用户编码 */
    private String userCode = null;
    /** 经度 */
    private Double lng = null;
    /** 纬度 */
    private Double lat = null;
    /** 网格编码*/
    private Long geoNum = null;
    /** 位置码 */
    private String iwcode = null;
    /** 层级 */
    private Integer geoLevel = null;
    
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Long getGeoNum() {
		return geoNum;
	}
	public void setGeoNum(Long geoNum) {
		this.geoNum = geoNum;
	}
	public String getIwcode() {
		return iwcode;
	}
	public void setIwcode(String iwcode) {
		this.iwcode = iwcode;
	}
	public Integer getGeoLevel() {
		return geoLevel;
	}
	public void setGeoLevel(Integer geoLevel) {
		this.geoLevel = geoLevel;
	}
}
