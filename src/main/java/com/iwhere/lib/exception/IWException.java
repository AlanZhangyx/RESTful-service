package com.iwhere.lib.exception;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * 自定义异常类
 * <p>
 * <br>
 * <strong>copyright</strong>： 2015, 成都都在哪网讯科技有限公司<br>
 * <strong>Time </strong>: 2015/10/28 18:04<br>
 * <strong>History</strong>：<br>
 * Editor　　　version　　　Time　　　　　Operation　　　　　　　Description<br>
 *
 * @author hewei
 * @version 1.0.0
 */
public class IWException extends RuntimeException {
    private static final long serialVersionUID = -339764807799082703L;
    // 全局默认异常
    public static final int ERROR_DEFAULT = 500;
    // 验证异常
    public static final int ERROR_VALIDATE = 510;

    // 全局异常Code
    private int errorCode = ERROR_DEFAULT;

    /**
     * 构造函数
     */
    public IWException() {
        super();
    }

    /**
     * 构造函数
     *
     * @param errorCode 错误消息ID
     */
    public IWException(int errorCode) {
        super();
        this.errorCode = errorCode;
    }

    /**
     * 构造函数
     *
     * @param s 错误消息
     */
    public IWException(String s) {
        super(s);
    }

    /**
     * 构造函数
     *
     * @param errorCode 错误消息ID
     * @param s         错误消息
     */
    public IWException(int errorCode, String s) {
        super(s);
        this.errorCode = errorCode;
    }

    /**
     * 构造函数
     *
     * @param s         错误消息
     * @param throwable 异常
     */
    public IWException(String s, Throwable throwable) {
        super(s, throwable);
    }

    /**
     * 构造函数
     *
     * @param errorCode 错误消息Code
     * @param s         错误消息
     * @param throwable 异常
     */
    public IWException(int errorCode, String s, Throwable throwable) {
        super(s, throwable);
        this.errorCode = errorCode;
    }

    /**
     * 构造函数
     *
     * @param throwable 异常
     */
    public IWException(Throwable throwable) {
        super(throwable);
    }

    /**
     * 构造函数
     *
     * @param errorCode 错误消息Code
     * @param throwable 异常
     */
    public IWException(int errorCode, Throwable throwable) {
        super(throwable);
        this.errorCode = errorCode;
    }

    /**
     * Creates a localized description of this throwable.
     * Subclasses may override this method in order to produce a
     * locale-specific message.  For subclasses that do not override this
     * method, the default implementation returns the same result as
     * {@code getMessage()}.
     *
     * @return The localized description of this throwable.
     * @since JDK1.1
     */
    @Override
    public String getLocalizedMessage() {
        // 重写异常信息国际化
        // 获取applicationContext
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        // 获取Local
        Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request);
        // 获取本地化异常
        return applicationContext.getMessage(this.getMessage(), null, locale);
    }

    /**
     * Getter method for property <tt>errorCode</tt>.
     *
     * @return property value of errorCode
     * @author hewei
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Setter method for property <tt>errorCode</tt>.
     *
     * @param errorCode value to be assigned to property errorCode
     * @author hewei
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
