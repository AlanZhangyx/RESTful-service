/**
 * Service层
 * 1. Service层接受参数。只接受：
 * 		a.java基本类型数据
 * 		b.javaSE API对象
 * 		c.相应的Resp对象
 * 		----暂时不使用BO d.service层对外发布的BO（Business Object）对象。 
 * 2. 根据业务需求对数据进行操作，可以调用DAO。
 * 3. 返回a/b/c/model。
 * <br>
 * <strong>Time </strong>: 2015年12月25日<br>
 * <strong>History</strong>：<br>
 * Editor　　　version　　　Time　　　　　Operation　　　　　　　Description<br>
 *
 * @author dznzyx
 * @version : 1.0.0
 */
package com.ddup.base.service;