package com.ddup.casual.dto.req.group;

import javax.validation.GroupSequence;

/**
 * 定义【每个】请求的所有参数的校验顺序接口（接口充当标识）
 */
public interface Groups {
	
	public interface IFirst{}
	public interface ISecond{}
	public interface IThird{}
	
	/************************* MediaReq使用的 ************************/
	@GroupSequence({
		IFirst.class,
		ISecond.class,
		IThird.class
	})
	public interface IFirstMethod{}//firstMethod
	
	@GroupSequence({
		IFirst.class,
		ISecond.class,
		IThird.class
	})
	public interface ISecondMethod{}//secondMethod
}
