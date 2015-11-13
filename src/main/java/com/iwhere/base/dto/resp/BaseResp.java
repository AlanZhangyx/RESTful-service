package com.iwhere.base.dto.resp;

/**
 * 基础返回封装
 * <p/>
 * <br>
 * <strong>copyright</strong>： 2015, 成都都在哪网讯科技有限公司<br>
 * <strong>Time </strong>: 2015/10/28 13:57<br>
 * <strong>History</strong>：<br>
 * Editor　　　version　　　Time　　　　　Operation　　　　　　　Description<br>
 *
 * @author hewei
 * @version : 1.0.0
 */
public class BaseResp {
    // 状态参数字段
    public static final String SERVER_STATUS = "server_status";
    // 异常参数字段
    public static final String SERVER_ERROR = "server_error";

    // --------------------------------------------------- 状态 start ---------------------------------------------
    // 状态：正常
    public static final int STATUS_SUCCESS = 200;
    // 状态：异常
    public static final int STATUS_ERROR = 500;
    // 状态：验证异常
    public static final int STATUS_ERROR_VALIDATE = 510;
    // --------------------------------------------------- 状态 end ---------------------------------------------

    // 接口状态：200 正常
    public int server_status = STATUS_SUCCESS;
    // 异常信息
    public String server_error;

    /**
     * Getter method for property <tt>server_status</tt>.
     *
     * @return property value of server_status
     * @author hewei
     */
    public int getServer_status() {
        return server_status;
    }

    /**
     * Setter method for property <tt>server_status</tt>.
     *
     * @param server_status value to be assigned to property server_status
     * @author hewei
     */
    public void setServer_status(int server_status) {
        this.server_status = server_status;
    }

    /**
     * Getter method for property <tt>server_error</tt>.
     *
     * @return property value of server_error
     * @author hewei
     */
    public String getServer_error() {
        return server_error;
    }

    /**
     * Setter method for property <tt>server_error</tt>.
     *
     * @param server_error value to be assigned to property server_error
     * @author hewei
     */
    public void setServer_error(String server_error) {
        this.server_error = server_error;
    }
}
