/**
 * DAO层完成对数据（持久层DB等）的访问和操作
 * 1. DAO层接受参数。只接受：
 * 		a.java基本类型数据
 * 		b.javaSE API对象
 * 		c.自身DAO层的model对象
 * 2. 并根据预定义的sql和输入参数对DB进行访问。
 * 3. 返回a/b/c。
 * <br>
 * <strong>Time </strong>: 2015年12月25日<br>
 * <strong>History</strong>：<br>
 * Editor　　　version　　　Time　　　　　Operation　　　　　　　Description<br>
 *
 * @author dznzyx
 * @version : 1.0.0
 */
package com.ddup.base.dao;