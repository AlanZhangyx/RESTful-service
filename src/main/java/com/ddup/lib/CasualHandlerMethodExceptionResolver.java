package com.ddup.lib;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerMethodExceptionResolver;

import com.ddup.base.dto.resp.BaseResp;
import com.ddup.lib.exception.CasualException;

/**
 * 全局异常处理类
 * <br>
 * <strong>copyright</strong>： 2015, 北京都在哪网讯科技有限公司<br>
 * <strong>Time </strong>: 2015年12月29日<br>
 * <strong>History</strong>：<br>
 * Editor　　　version　　　Time　　　　　Operation　　　　　　　Description<br>
 *
 * @author dznzyx
 * @version : 1.0.0
 */
@Component
public class CasualHandlerMethodExceptionResolver extends AbstractHandlerMethodExceptionResolver {


    /**
     * 使用@Qualifier配合@Autowired是注入策略变为byName=jdk的@Resource
     */
    @Qualifier("mappingJackson2HttpMessageConverter")
    @Autowired
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
	
    
    /**
     * 对发生的异常进行定制化处理
     * 
     * @see org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver#doResolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
     */
	@Override
	protected ModelAndView doResolveHandlerMethodException(HttpServletRequest request, HttpServletResponse response, HandlerMethod handlerMethod, Exception ex) {
        // 如果handlerMethod为空，则不用该Handler处理
        if (handlerMethod == null || handlerMethod.getMethod() == null) {
            return null;
        }
        // 只处理@ResponseBody的方法，统一处理异常
        ResponseBody responseBody = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), ResponseBody.class);
        if (responseBody == null) {
            return null;
        }
        
        // ---------------------------- 处理解析异常，并用Json返回 --------------------------------------
        BaseResp resp = new BaseResp();
        // 业务异常
        if (ex instanceof CasualException) {
        	CasualException exception = (CasualException)ex;
            resp.setServer_status(exception.getErrorCode());//默认500
            resp.setServer_error(exception.getLocalizedMessage());
        } 
        // 验证异常
        else if (ex instanceof BindException) {
            BindException exception = (BindException) ex;
            resp.setServer_status(CasualException.ERROR_VALIDATE);
            resp.setServer_error(exception.getFieldError().getDefaultMessage());
        }
        // 其他系统崩溃异常
        else {  
            resp.setServer_status(CasualException.ERROR_DEFAULT);
            resp.setServer_error("系统崩溃异常！");
            // 记录全局非业务异常日志，方便排错
            if (this.logger.isErrorEnabled()) {
                this.logger.error("系统崩溃异常！", ex);
            }
        }

        // JSON 输出异常
        try {
            this.mappingJackson2HttpMessageConverter.write(resp, MediaType.ALL, new ServletServerHttpResponse(response));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ModelAndView();
	}

}