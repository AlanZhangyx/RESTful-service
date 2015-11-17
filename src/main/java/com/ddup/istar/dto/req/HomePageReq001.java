package com.ddup.istar.dto.req;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.ddup.base.dto.req.BaseReq;

/**
 * 接口：0001_0001_0004 获取用户主页信息
 * <br>
 * <strong>copyright</strong>： 2015, 北京都在哪网讯科技有限公司<br>
 * <strong>Time </strong>: 2015年11月16日<br>
 * <strong>History</strong>：<br>
 * Editor　　　version　　　Time　　　　　Operation　　　　　　　Description<br>
 *
 * @author dznzyx
 * @version : 1.0.0
 */
public class HomePageReq001 extends BaseReq {
    
    @NotBlank(message = "{error.user.userCode.NotBlank}")
    @Pattern(regexp = "^[0-9a-fA-F]{32}$", message = "{error.user.userCode.Pattern}")
    private String userCode;//用户编码
    
    @Range(min= 1, max= 32, message = "{error.HomePageReq001.geoLevel.Range}")
    private Short geoLevel = 13;//层级 默认为：13 8公里网格

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Short getGeoLevel() {
        return geoLevel;
    }

    public void setGeoLevel(Short geoLevel) {
        this.geoLevel = geoLevel;
    }
}
