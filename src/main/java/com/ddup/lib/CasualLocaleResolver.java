package com.ddup.lib;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

public class CasualLocaleResolver implements LocaleResolver {
	
	//一个key，其值存储的是一次请求中的Locale
	private static final String LOCALE_REQUEST_ATTRIBUTE_NAME = CasualLocaleResolver.class.getName() + ".LOCALE";
	// 默认参数名称
	public static final String DEFAULT_PARAM_NAME = "locale";
	// 默认语言
	private Locale defaultLocale = Locale.CHINA;
	// 参数名称
	private String paramName = DEFAULT_PARAM_NAME;

	/**
	 * spring validate会调用，用来国际化解析其返回资源，一个参数调用一次，所以这里通常会被调用多次
	 */
	@Override
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
	 * spring i18n的拦截器会调用此方法来设置
	 */
	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		request.setAttribute(LOCALE_REQUEST_ATTRIBUTE_NAME, locale);
	}

	/**
	 * @return the defaultLocale
	 */
	public Locale getDefaultLocale() {
		return defaultLocale;
	}

	/**
	 * @param defaultLocale the defaultLocale to set
	 */
	public void setDefaultLocale(Locale defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

	/**
	 * @return the paramName
	 */
	public String getParamName() {
		return paramName;
	}

	/**
	 * @param paramName the paramName to set
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	/**
	 * @return the localeRequestAttributeName
	 */
	public static String getLocaleRequestAttributeName() {
		return LOCALE_REQUEST_ATTRIBUTE_NAME;
	}

	/**
	 * @return the defaultParamName
	 */
	public static String getDefaultParamName() {
		return DEFAULT_PARAM_NAME;
	}

}
