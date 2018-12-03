package com.zy.tools;

import java.io.UnsupportedEncodingException;

public class MyUtils {
	
	/**
	 * unicode编码转中文
	 * @param str
	 */
	public static void unicodeToch(String str) {
	//\u53c8\u4e00\u4e2aAndroid\u6743\u9650\u7ba1\u7406\u5668\u3002
		byte[] bytes = str.getBytes();
		String s;
		try {
			s = new String(bytes, "UTF-8");
			System.out.println(s);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyUtils.unicodeToch("\u53c8\u4e00\u4e2aAndroid\u6743\u9650\u7ba1\u7406\u5668\u3002");
	}
}
