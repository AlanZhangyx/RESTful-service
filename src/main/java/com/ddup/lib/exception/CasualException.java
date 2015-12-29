package com.ddup.lib.exception;

/**
 *  业务异常
 * <br>
 * <strong>copyright</strong>： 2015, 北京都在哪网讯科技有限公司<br>
 * <strong>Time </strong>: 2015年12月29日<br>
 * <strong>History</strong>：<br>
 * Editor　　　version　　　Time　　　　　Operation　　　　　　　Description<br>
 *
 * @author dznzyx
 * @version : 1.0.0
 */
public class CasualException extends RuntimeException {

	/**------------------------------------------ 参数定义 ------------------------------------------**/

	private static final long serialVersionUID = 1603190669433314587L;
	
	/**
	 * 全局默认异常
	 */
	public static final int ERROR_DEFAULT = 500;
	
	/**
	 * 验证异常
	 */
	public static final int ERROR_VALIDATE = 400;
	
	
	/**------------------------------------------ 服务器字段 ------------------------------------------**/
	
	private int errorCode = ERROR_DEFAULT;
	
	/**------------------------------------------ 构造函数 ------------------------------------------**/
	public CasualException(){
		super();
	}
	
	/**
	 * @param errorCode
	 */
	public CasualException(int errorCode){
		super();
		this.setErrorCode(errorCode);
	}
	
	/**
	 * @param errorCode
	 * @param msg
	 */
	public CasualException(int errorCode, String msg){
		super(msg);
		this.setErrorCode(errorCode);
	}
	
	/**
	 * @param msg
	 * @param throwable
	 */
	public CasualException(String msg, Throwable throwable){
		super(msg, throwable);
		
	}
	
	/**
	 * @param errorCode
	 * @param msg
	 * @param throwable
	 */
	public CasualException(int errorCode, String msg, Throwable throwable){
		super(msg, throwable);
		this.setErrorCode(errorCode);
	}
	
    /**
     * @param throwable
     */
    public CasualException(Throwable throwable) {
        super(throwable);
    }

    /**
     * @param errorCode
     * @param throwable
     */
    public CasualException(int errorCode, Throwable throwable) {
        super(throwable);
        this.setErrorCode(errorCode);
    }

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getLocalizedMessage()
	 */
	@Override
	public String getLocalizedMessage() {
		return super.getLocalizedMessage();
		// 重写异常信息国际化
        // 获取applicationContext
        /*HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        // 获取Local
        Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request);
        // 获取本地化异常
        return applicationContext.getMessage(this.getMessage(), null, locale);*/
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
