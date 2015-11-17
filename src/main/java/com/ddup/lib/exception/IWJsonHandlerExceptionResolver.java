package com.ddup.lib.exception;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerMethodExceptionResolver;

import com.ddup.base.dto.resp.BaseResp;

/**
 * 全局异常处理类
 * <p>
 * <br>
 * <strong>copyright</strong>： 2015, 成都都在哪网讯科技有限公司<br>
 * <strong>Time </strong>: 2015/11/2 9:24<br>
 * <strong>History</strong>：<br>
 * Editor　　　version　　　Time　　　　　Operation　　　　　　　Description<br>
 *
 * @author hewei
 * @version : 1.0.0
 */
@Controller
public class IWJsonHandlerExceptionResolver extends AbstractHandlerMethodExceptionResolver {


    @Qualifier("mappingJackson2HttpMessageConverter")
    @Autowired
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    /**
     * Actually resolve the given exception that got thrown during on handler execution,
     * returning a ModelAndView that represents a specific error page if appropriate.
     * <p>May be overridden in subclasses, in order to apply specific exception checks.
     * Note that this template method will be invoked <i>after</i> checking whether this
     * resolved applies ("mappedHandlers" etc), so an implementation may simply proceed
     * with its actual exception handling.
     *
     * @param request       current HTTP request
     * @param response      current HTTP response
     * @param handlerMethod the executed handler method, or {@code null} if none chosen at the time
     *                      of the exception (for example, if multipart resolution failed)
     * @param ex            the exception that got thrown during handler execution
     * @return a corresponding ModelAndView to forward to, or {@code null} for default processing
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
        if (ex instanceof IWException) { // 业务异常
            IWException exception = (IWException)ex;
            resp.setServer_status(exception.getErrorCode());
            resp.setServer_error(exception.getLocalizedMessage());
        } else if (ex instanceof BindException) {   // 验证异常
            BindException exception = (BindException) ex;
            resp.setServer_status(IWException.ERROR_VALIDATE);
            resp.setServer_error(exception.getFieldError().getDefaultMessage());
        } else {  // 其他系统崩溃异常
            resp.setServer_status(IWException.ERROR_DEFAULT);
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
