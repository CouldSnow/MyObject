package com.zy.jsoup.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;

/**
* @author 郑炎
* @version 创建时间：2018年11月24日 上午10:47:26
* @ClassName 类名称
* @Description 类描述
*/
public class JsoupTest1 {
	
	public static String USER_AGENT = "User-Agent";
    public static String USER_AGENT_VALUE = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0";


	public static void main(String[] args) throws Exception {
		Connection con2 = Jsoup.connect("http://9993600.com/tools/ssc_ajax.ashx?A=GetLotteryOpen&S=c99&U=wo735072371");
		con2.header(USER_AGENT, USER_AGENT_VALUE);	
		
		Map<String,String> cookies = new HashMap<>();
		cookies.put("C_SessionId", "3b87fb67-a8f7-4a6d-b807-c8cc696f9c5a");
		cookies.put("IVK", "84a01949");
		
		Map<String,String> datas  = new HashMap<>();
		datas.put("Action", "GetLotteryOpen");
		datas.put("SourceName", "PC");
		datas.put("LotteryCode", "1047");
		datas.put("IssueNo", "0");
		datas.put("DataNum", "10");
		Response login = con2.ignoreContentType(true).method(Method.POST).data(datas).cookies(cookies).execute();
		
		System.out.println(login.body());
	}
}
