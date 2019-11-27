package com.example.demo.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class HtmlStringStatic {

	public static void main(String[] args) throws IOException, TemplateException {
	    // 创建配置类
	    Configuration configuration = new Configuration(Configuration.getVersion());
	    // 测试模板内容
	    String templateString="" +
	            "<html>\n" +
	            " <head></head>\n" +
	            " <body>\n" +
	            " 名称：${name}\n" +
	            " </body>\n" +
	            "</html>";
	    // 模板加载器
	    StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
	    stringTemplateLoader.putTemplate("template",templateString);
	    configuration.setTemplateLoader(stringTemplateLoader);
	    // 得到模板
	    Template template = configuration.getTemplate("template","utf-8");
	    // 数据模型
	    Map<String,Object> map = new HashMap<>();
	    map.put("name","使用模板字符串静态化");
	    // 静态化
	    String content = FreeMarkerTemplateUtils.processTemplateIntoString(template,map);
	    // 打印静态化内容
	    System.out.println(content);
	    InputStream inputStream = IOUtils.toInputStream(content);
	    // 定位到项目路径
	    String path=System.getProperty("user.dir");
		System.out.println(path);
		// 输出文件
	    FileOutputStream fileOutputStream = new FileOutputStream(new File(path + "/src/main/resources/templates/stringStatic.html"));
	    int copy = IOUtils.copy(inputStream, fileOutputStream);
	}
}
