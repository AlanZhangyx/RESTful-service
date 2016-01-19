package com.ddup.util;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.junit.Test;

public class ToolsTest {
	
	/**
	 * @Title
	 * @Description
	 * @throws NoSuchAlgorithmException
	 * @TestUrl
	 */
	@Test
	public void MD5Test() throws NoSuchAlgorithmException{
		System.out.println(Tools.string2MD5("哈哈"));
		
		System.out.println(Tools.string2MD52("哈哈"));
		
		System.out.println(-6 >>> 2);
		
		String uid = UUID.randomUUID().toString();
		System.out.println(uid);
		uid = uid.substring(0, 8) + uid.substring(9, 13) + uid.substring(14, 18) + 
		uid.substring(19, 23) + uid.substring(24, 36);
		System.out.println(uid);
		
		System.out.println(UUID.randomUUID());
		System.out.println(UUID.randomUUID());
		System.out.println(UUID.randomUUID());
		System.out.println(UUID.randomUUID());
		System.out.println(UUID.randomUUID());
		System.out.println(UUID.randomUUID());
		System.out.println(UUID.randomUUID());
		System.out.println(UUID.randomUUID());
		System.out.println(UUID.randomUUID());
	}
}
