package com.zy.freemarker;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * 
 * @author admin
 *
 */
public class FreeMarkerUtils {

	public static void main(String[] args) {
		FreeMarkerUtils free = new FreeMarkerUtils();
		System.out.println(free.getpath());
		free.test();
	}
	
	public  String  getpath() {
		System.out.println(String.valueOf(this.getClass().getClassLoader().getResource("")));
		return String.valueOf(this.getClass().getClassLoader().getResource("")).replaceAll("file:/", "").replaceAll("%20", " ").trim();
	}
	
	
	public void test() {
		Configuration cfg = new Configuration();
		
		try {
			cfg.setDirectoryForTemplateLoading(new File(getpath())); //从哪个文件夹加载,说白了就是模板文件的地址
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			
			
			// Create the root hash
			Map<String, Object> root = new HashMap<>();
			// Put string ``user'' into the root
			root.put("user", "Big Joe");
			// Create the hash for ``latestProduct''
			Map<String, Object> latest = new HashMap<>();
			// and put it into the root
			root.put("latestProduct", latest);
			// put ``url'' and ``name'' into latest
			latest.put("url", "products/greenmouse.html");
			latest.put("name", "green mouse");
			
			Template temp = cfg.getTemplate("test.ftl"); //加载模板文件，配合上面的地址
			
			Writer out  = new OutputStreamWriter(System.out); //这里是输出到控制台
			
			temp.process(root, out); //合并模板
			
			
			System.out.println(out.toString());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
