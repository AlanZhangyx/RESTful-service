package com.ddup.base.dto.resp;

/**
 * 基础返回封装
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
public class BaseResp {
	
	/**------------------------------------------ 参数定义 ------------------------------------------**/
    // 状态参数字段
    public static final String SERVER_STATUS = "server_status";
    // 异常参数字段
    public static final String SERVER_ERROR = "server_error";

    // ----------------------------------------- 状态 start ---------------------------------------
    // 状态：正常
    public static final int STATUS_SUCCESS = 200;
    // 状态：异常
    public static final int STATUS_ERROR = 500;
    // 状态：验证异常
    public static final int STATUS_ERROR_VALIDATE = 400;
    // ------------------------------------------ 状态 end ---------------------------------------------

	/**------------------------------------------ 服务器字段 ------------------------------------------**/
    // 接口状态：200 正常
    public int server_status = STATUS_SUCCESS;
    // 异常信息
    public String server_error;
    
	public int getServer_status() {
		return server_status;
	}
	public void setServer_status(int server_status) {
		this.server_status = server_status;
	}
	public String getServer_error() {
		return server_error;
	}
	public void setServer_error(String server_error) {
		this.server_error = server_error;
	}

}
