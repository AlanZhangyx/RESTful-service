package com.ddup.tools;

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

public class Tools {

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) {
	    try {
            System.out.println(string2MD5("123456"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
	}

	public static boolean isAllLetter(String str){
		boolean isWord=str.matches("[a-zA-Z]+");
		return isWord;
	}
	
	/** 
	 * bean转Map
	 **/
	public static Map<String, Object> transBeanToMap(Object obj) {   
        if(obj == null){  
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
      * @Title: formatTimeInTheList
      * @Description: 将list中的时间格式化为1990-xx-xx格式
      * @param list
      * @throws
      */
     public static void formatTimeInTheList(
             List<Map<String, Object>> list) {
         DateFormat sd= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//格式化时间
         for (int i = 0; i < list.size(); i++) {
             Map<String,Object> item=list.get(i);
             //对可能有的时间进行格式化
             if(item.containsKey("publishTime")){
                 item.put("publishTime",sd.format(item.get("publishTime")));
             }
             if(item.containsKey("createTime")){
                 item.put("createTime",sd.format(item.get("createTime")));
             }
         }
     }
     
     /*** 
      * MD5加码 生成32位md5码 
     * @throws NoSuchAlgorithmException 
      */  
     public static String string2MD5(String message) throws NoSuchAlgorithmException{  
         //1 创建一个提供信息摘要算法的对象，初始化为md5算法对象
         MessageDigest md = MessageDigest.getInstance("MD5");
  
         //2 将消息变成byte数组
     	 byte[] input = message.getBytes();
  
     	 //3 计算后获得字节数组,这就是那128位了
         byte[] buff = md.digest(input);
  
         //4 把数组每一字节（一个字节占八位）换成16进制连成md5字符串
         String md5str = bytesToHex(buff);
  
         return md5str;
     }
     
     /**
      * 二进制转十六进制
      * @param bytes
      * @return
      */
     public static String bytesToHex(byte[] bytes) {
         StringBuffer md5str = new StringBuffer();
         //把数组每一字节换成16进制连成md5字符串
         int digital;
         for (int i = 0; i < bytes.length; i++) {
              digital = bytes[i];
  
             if(digital < 0) {
                 digital += 256;
             }
             if(digital < 16){
                 md5str.append("0");
             }
             md5str.append(Integer.toHexString(digital));
         }
         return md5str.toString().toUpperCase();
     }
}
