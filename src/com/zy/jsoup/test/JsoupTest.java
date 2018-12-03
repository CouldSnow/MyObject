package com.zy.jsoup.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
* @author 郑炎
* @version 创建时间：2018年11月23日 下午5:52:14
* @ClassName 类名称
* @Description 类描述
*/
public class JsoupTest {

	public static String USER_AGENT = "User-Agent";
    public static String USER_AGENT_VALUE = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0";

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//爬取百度首页的html
		/*	Document doc = Jsoup.connect("http://www.baidu.com").get();
			System.out.println(doc);
			Elements newsHeadlines = doc.select("#mp-itn b a");
			for (Element headline : newsHeadlines) {
			System.out.println(headline.attr("title")+"-------"+ headline.absUrl("href"));
		}*/
		//解析文本html为document类
		/*String html = "<html><head><title>First parse</title></head>"
				  + "<body><p>Parsed HTML into a doc.</p></body></html>";
		Document doc = Jsoup.parse(html);
		//获取p节点
		Elements p = doc.select("p");
		//输出p节点内容
		System.out.println(p.html());*/
		
		/*Document doc = Jsoup.connect("http://localhost:8080/huatian/").;
		Elements form = doc.select("form");
		Elements userid = form.select("input[name='user_id']");
		Elements password = form.select("input[name='password']");
		Elements verify_pwd = form.select("input[name='verify_pwd']");
		System.out.println(userid);*/
		Connection con = Jsoup.connect("http://localhost:8080/huatian/"); //获取connection
		con.header(USER_AGENT, USER_AGENT_VALUE);								 //配置模拟浏览器
		Response rs = con.execute();																	 //获取响应
		Document doc = Jsoup.parse(rs.body());												 //转换dom树
		Elements form = doc.select("form"); 										 //获取form表单
		//获取form登入参数
		Elements userid = form.select("input[name='user_id']");
		Elements password = form.select("input[name='password']");
		Elements verify_pwd = form.select("input[name='verify_pwd']");
		
		Map<String,String> datas  = new HashMap<>();
		datas.put("user_id", "100101");
		datas.put("password", "000000");
		datas.put("verify_pwd", "7140");
		
		Map<String,String> cookies = new HashMap<>();
		cookies.put("JSESSIONID", "DA41008AAF97BAAB178304CDE9885BFB");
		Connection con2 = Jsoup.connect("http://localhost:8080/huatian/main.jsp");
		con2.header(USER_AGENT, USER_AGENT_VALUE);	
		
		Response login = con2.ignoreContentType(true).followRedirects(true).method(Method.POST).data(datas).cookies(cookies).execute();
		
		System.out.println(login.body());
		
	}
}
