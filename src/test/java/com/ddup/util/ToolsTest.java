package com.ddup.util;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class ToolsTest {
	
	@Test
	public void MD5Test() throws NoSuchAlgorithmException{
		System.out.println(Tools.string2MD5("哈哈"));
		
		System.out.println(Tools.string2MD52("哈哈"));
		
		System.out.println(-6 >>> 2);
	}
}
