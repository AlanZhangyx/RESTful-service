package com.ddup.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public class Tools {

	public static boolean isAllLetter(String str) {
		boolean isWord = str.matches("[a-zA-Z]+");
		return isWord;
	}
	
	/**
	 * 获取IP地址
	 * @Title
	 * @Description
	 * @param request
	 * @return
	 * @TestUrl
	 */
	public static final String getIP(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getRemoteAddr();
		}
		ip = ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
		return ip;
	}

	/**
	 * bean转Map
	 **/
	public static Map<String, Object> transBeanToMap(Object obj) {
		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				// 过滤class属性
				if (!key.equals("class")) {
					// 得到property对应的getter方法
					Method getter = property.getReadMethod();
					Object value = getter.invoke(obj);
					map.put(key, value);
				}
			}
		} catch (Exception e) {
			System.out.println("transBean2Map Error " + e);
		}
		return map;
	}

	/**
	 * @Title: formatTimeInTheList @Description:
	 *         将list中的时间格式化为1990-xx-xx格式 @param list @throws
	 */
	public static void formatTimeInTheList(List<Map<String, Object>> list) {
		DateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化时间
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> item = list.get(i);
			// 对可能有的时间进行格式化
			if (item.containsKey("publishTime")) {
				item.put("publishTime", sd.format(item.get("publishTime")));
			}
			if (item.containsKey("createTime")) {
				item.put("createTime", sd.format(item.get("createTime")));
			}
		}
	}

	/**
	 * Bean转Map
	 * 1. 可以指定源Bean属性是驼峰的还是下划线的
	 * 2. 可以指定目标Map属性是驼峰还是下划线的
	 * @Title
	 * @Description
	 * @param obj
	 * @param sourceIsCamelBean
	 * @param targetIsCamelMap
	 * @return
	 * @TestUrl
	 */
	public static Map<String, Object> transBeanToMap(Object obj, boolean sourceIsCamelBean, boolean targetIsCamelMap) {
        if(obj == null){  
            return null;  
        }          
        Map<String, Object> map = new HashMap<String, Object>();
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (!key.equals("class")) {// 过滤class属性  
                    Method getter = property.getReadMethod();// 得到property对应的getter方法  
                    Object value = getter.invoke(obj);
                    //驼峰和下划线命名的处理
                    StringBuilder sb = null;
                    if (sourceIsCamelBean && !targetIsCamelMap) {//bean是驼峰而目标map是_
                    	sb = new StringBuilder();
        				for (int i = 0; i < key.length(); i++) {
    						if (Character.isUpperCase(key.charAt(i))) {
    							sb.append('_');
								sb.append(Character.toLowerCase(key.charAt(i)));//小写并追加
							}else {
								sb.append(key.charAt(i));
							}
    					}
        			}else if (!sourceIsCamelBean && targetIsCamelMap) {//bean是_目标map是驼峰，本项目一般用这个
        				sb = new StringBuilder();
        				for (int i = 0; i < key.length(); i++) {
    						if (key.charAt(i) == '_') {
								i++;//跳过_
								sb.append(Character.toUpperCase(key.charAt(i)));//大写并追加
							}else {
								sb.append(key.charAt(i));
							}
    					}
        			}
                    //加入map
                    map.put(sb.toString(), value);
                }
            }
        } catch (Exception e) {
            System.out.println("transBean2Map Error " + e);  
        }
        return map;
	}

	/**
	 * 将String摘要为长度为32的16进制数字MD5字符串
	 * 
	 * @Title
	 * @Description
	 * @param s
	 * @return
	 * @TestUrl
	 */
	public final static String string2MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			// MD5对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 摘要，MD5摘要结果是128bit/32位16进制，但这里java实现后获得长度为16的字节数组
			byte[] md = mdInst.digest(s.getBytes());

			char str[] = new char[32];
			// i用来循环，k用来标识char[]
			for (int i = 0, k = 0; i < 16; i++) {
				byte perByte = md[i];//每一个字节代表着两个16进制数字(因为4个bit就是一个16进制数)
				//1 获取1个byte中的前4bit(第一个16进制数)
				//>>>4 相当于把原高4位移到低4位，然后高4位补0（也就是说如果是负数就会被变正数）
				//按位再跟15（0000 1111）进行&操作，跟15进行&操作，结果永远在0-15之间
				str[k++] = hexDigits[perByte >>> 4 & 0xf];//第1个char
				//2 后4个bit
				str[k++] = hexDigits[perByte & 0xf];//第2个char
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 第2种方法
	 * @Title
	 * @Description
	 * @param message
	 * @return
	 * @TestUrl
	 */
	public static String string2MD52(String message){
		// 1 创建一个提供信息摘要算法的对象，初始化为md5算法对象
		MessageDigest md = null;
		byte[] buff = null;
		try {
			md = MessageDigest.getInstance("MD5");
			buff = md.digest(message.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// 把数组每一字节（一个字节占八位）换成16进制连成md5字符串
		return bytesToHex(buff);
	}

	/**
	 * byte[]转16进制
	 * @Title
	 * @Description
	 * @param bytes
	 * @return
	 * @TestUrl
	 */
	public static String bytesToHex(byte[] bytes) {
		StringBuffer md5str = new StringBuffer();
		// 把数组每一字节换成16进制连成md5字符串
		int digital;
		for (int i = 0; i < bytes.length; i++) {
			digital = bytes[i];

			if (digital < 0) {
				digital += 256;
			}
			if (digital < 16) {
				md5str.append("0");
			}
			md5str.append(Integer.toHexString(digital));
		}
		return md5str.toString();
	}
	
	/**
	 * 获得32位随机UUID
	 * @Title
	 * @Description
	 * @return
	 * @TestUrl
	 */
	public static String getUUID(){
		String uid = UUID.randomUUID().toString();
		return uid.substring(0, 8) + uid.substring(9, 13) + uid.substring(14, 18) + 
		uid.substring(19, 23) + uid.substring(24, 36);
	}
	
	public static final String generate32Token(){
		
		
		//UUID.nameUUIDFromBytes(name)
		
		return null;
	}
	
}