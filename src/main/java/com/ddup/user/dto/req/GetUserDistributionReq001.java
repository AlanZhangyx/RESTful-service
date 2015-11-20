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
public class GetUserDistributionReq001 extends BaseReq {
	/** 左下点经度  */
    private Double leftBottomLng;
    /** 左下点纬度  */
    private Double leftBottomLat;
    /** 右上点经度  */
    private Double rightTopLng;
    /** 右上点纬度*/
    private Double rightTopLat;
    /** 层级 */
    private Integer geoLevel;
    
	public Double getLeftBottomLng() {
		return leftBottomLng;
	}
	public void setLeftBottomLng(Double leftBottomLng) {
		this.leftBottomLng = leftBottomLng;
	}
	public Double getLeftBottomLat() {
		return leftBottomLat;
	}
	public void setLeftBottomLat(Double leftBottomLat) {
		this.leftBottomLat = leftBottomLat;
	}
	public Double getRightTopLng() {
		return rightTopLng;
	}
	public void setRightTopLng(Double rightTopLng) {
		this.rightTopLng = rightTopLng;
	}
	public Double getRightTopLat() {
		return rightTopLat;
	}
	public void setRightTopLat(Double rightTopLat) {
		this.rightTopLat = rightTopLat;
	}
	public Integer getGeoLevel() {
		return geoLevel;
	}
	public void setGeoLevel(Integer geoLevel) {
		this.geoLevel = geoLevel;
	}
    
	
}
