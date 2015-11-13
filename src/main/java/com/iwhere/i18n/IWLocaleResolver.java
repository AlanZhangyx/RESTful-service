package com.iwhere.i18n;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * <br>
 * <strong>copyright</strong>： 2015, 成都都在哪网讯科技有限公司<br>
 * <strong>Time </strong>: 2015/11/2 16:20<br>
 * <strong>History</strong>：<br>
 * Editor version Time Operation Description<br>
 *
 * @author hewei
 * @version : 1.0.0
 */
public class IWLocaleResolver implements LocaleResolver {

	/**
	 * The name of the request attribute that holds the Locale.
	 * <p>
	 * Only used for overriding a cookie value if the locale has been changed in
	 * the course of the current request!
	 * <p>
	 * Use {@code RequestContext(Utils).getLocale()} to retrieve the current
	 * locale in controllers or views.
	 * 
	 * @see org.springframework.web.servlet.support.RequestContext#getLocale
	 * @see org.springframework.web.servlet.support.RequestContextUtils#getLocale
	 */
	public static final String LOCALE_REQUEST_ATTRIBUTE_NAME = IWLocaleResolver.class.getName() + ".LOCALE";

	// 默认参数名称
	public static final String DEFAULT_PARAM_NAME = "language";
	// 默认语言
	private Locale defaultLocale = Locale.CHINA;
	// 参数名称
	private String paramName = DEFAULT_PARAM_NAME;

	/**
	 * Resolve the current locale via the given request. Can return a default
	 * locale as fallback in any case.
	 *
	 * @param request
	 *            the request to resolve the locale for
	 * @return the current locale (never {@code null})
	 */
	public Locale resolveLocale(HttpServletRequest request) {
		// 对于一次request请求，只进行一次locale封装，如存在，则直接返回，减少代码执行
		// jsp 请求同样会进该方法，如此处不进行特殊处理jsp访问会有问题
		if (request.getAttribute(LOCALE_REQUEST_ATTRIBUTE_NAME) != null) {
			return (Locale) request.getAttribute(LOCALE_REQUEST_ATTRIBUTE_NAME);
		}

		// 获取语言信息
		Locale locale;
		String lan = request.getParameter(this.getParamName());
		if (lan != null) {
			locale = StringUtils.parseLocaleString(lan);
		} else {
			locale = this.defaultLocale;
		}

		// 设置Local
		request.setAttribute(LOCALE_REQUEST_ATTRIBUTE_NAME, locale);

		return locale;
	}

	/**
	 * Set the current locale to the given one.
	 *
	 * @param request
	 *            the request to be used for locale modification
	 * @param response
	 *            the response to be used for locale modification
	 * @param locale
	 *            the new locale, or {@code null} to clear the locale
	 * @throws UnsupportedOperationException
	 *             if the LocaleResolver implementation does not support dynamic
	 *             changing of the locale
	 */
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		request.setAttribute(LOCALE_REQUEST_ATTRIBUTE_NAME, locale);
	}

	/**
	 * Getter method for property <tt>defaultLocale</tt>.
	 *
	 * @return property value of defaultLocale
	 * @author hewei
	 */
	public Locale getDefaultLocale() {
		return defaultLocale;
	}

	/**
	 * Setter method for property <tt>defaultLocale</tt>.
	 *
	 * @param defaultLocale
	 *            value to be assigned to property defaultLocale
	 * @author hewei
	 */
	public void setDefaultLocale(Locale defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

	/**
	 * Getter method for property <tt>paramName</tt>.
	 *
	 * @return property value of paramName
	 * @author hewei
	 */
	public String getParamName() {
		return paramName;
	}

	/**
	 * Setter method for property <tt>paramName</tt>.
	 *
	 * @param paramName
	 *            value to be assigned to property paramName
	 * @author hewei
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
}
