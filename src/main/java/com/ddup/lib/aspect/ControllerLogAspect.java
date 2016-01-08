package com.ddup.lib.aspect;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import net.sf.json.JSONObject;

/**
 * 控制层日志记录
 * 五种通知的执行顺序为： 前置通知→环绕通知→正常返回通知/异常返回通知→返回通知
 */
@Aspect
@Component
public class ControllerLogAspect {

	private final Logger LOGGER = Logger.getLogger(ControllerLogAspect.class);

	private String requestPath = null; // 请求地址
	private Map<?, ?> inputParamMap = null; // 传入参数
	private Map<String, Object> outputParamMap = null; // 存放输出结果
	private long startTimeMillis = 0; // 开始时间
	private long endTimeMillis = 0; // 结束时间
	
	private static final DateFormat DF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//日志时间格式
	
	@Pointcut("execution(* com.ddup.casual.controller.*Controller.*(..))")
	private void pointCut(){}
	
	/**
	 * @Title 前置通知,记录方法执行开始时间
	 * @Description *:所有返回类型，..:任意子包，*(..):任意方法
	 */
	@Before("pointCut()")
	public void doBefore(JoinPoint joinPoint) {
		startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间
	}

	/**
	 * @Title 环绕通知，获取方法url和参数
	 * @Description 必须有ProceedingJoinPoint，且返回值必须是目标方法的返回值pjp.proceed()
	 * @param pjp
	 * @return
	 * @throws Throwable 
	 * @TestUrl
	 */
	@Around("pointCut()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
		/************************ 1 前 ****************************/
		// 获取request
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
		// 获取输入参数
		inputParamMap = request.getParameterMap();
		// 获取请求地址不带参
		requestPath = request.getRequestURI();
		
		/************************ 2 调用 ****************************/
		Object result = pjp.proceed();// result的值就是被拦截方法的返回值
		
		/************************ 3 后 ****************************/
		// 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
		outputParamMap = new HashMap<String, Object>();
		outputParamMap.put("result", result);
		return result;
	}	
	
	/**
	 * @Title 后置通知,记录方法执行结束时间
	 * @Description
	 */
	@After("pointCut()")
	public void doAfter() {
		endTimeMillis = System.currentTimeMillis(); // 记录方法执行完成的时间
		this.printOptLog();
	}
	
	/**
	 * @Title 日志记录方法的执行过程
	 * @Description 
	 * 计划的日志格式：start_time : yyyy-MM-dd HH:mm:ss >>耗时:xxxx毫秒  >>url:http://xxxxxxx >>params:[{....}] >>result:[{.....}]
	 */
	private void printOptLog() {
		String start_time = DF.format(startTimeMillis);//开始时间
		String message = "\n start_time:" + start_time + " >>耗时:" + (endTimeMillis - startTimeMillis)
				+ "ms \n url:" + requestPath + " >>params:" + JSONObject.fromObject(inputParamMap)
				+ "\n result:" + JSONObject.fromObject(outputParamMap);
		LOGGER.info(message);
	}
}