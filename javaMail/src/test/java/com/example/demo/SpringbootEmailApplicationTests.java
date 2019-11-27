package com.example.demo;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.example.demo.pojo.User;
import com.example.demo.service.EmailService;

import freemarker.template.Configuration;
import freemarker.template.Template;

@SpringBootTest
class SpringbootEmailApplicationTests {

	@Autowired
	EmailService emailService;
	
	@Autowired
	TemplateEngine engine;
	
	@Test
	void sendSimpleEmail() {
		emailService.sendEmail("846939029@qq.com", "2859453403@qq.com", "发送邮件测试", "发送邮件测试");
	}
	@Test
	void sendEmailWithFile() throws MessagingException {
		File file=new File("D:\\E_softwareFiles\\Eclipse\\Springboot_newman\\README.md");
		emailService.sendEmailWithFile("846939029@qq.com", "2859453403@qq.com", "发送带附件的邮件测试", "这是一封带附件的邮件",file);
	}
	@Test
	void sendEmailWithImg() throws MessagingException {
		String content="<div>这是一封带图片的邮件："
				+ "图片1：<div><img src='cid:p01'/></div>"
				+ "图片2：<div><img src='cid:p02'/></div>"
				+ "</div>";
		String[] paths=new String[] {
				"C:\\Users\\锡\\AppData\\Local\\Packages\\Microsoft.Windows.ShellExperienceHost_cw5n1h2txyewy\\TempState\\ScreenClip\\1.png",
				"C:\\Users\\锡\\AppData\\Local\\Packages\\Microsoft.Windows.ShellExperienceHost_cw5n1h2txyewy\\TempState\\ScreenClip\\2.png"
		};
		String[] ids=new String[] {
				"p01","p02"
		};
		emailService.sendEmailWithImg("846939029@qq.com", "2859453403@qq.com", "发送带图片的邮件测试", content,paths,ids);
	}
	
	@Test
	void sendEmailUsingFtl() {
		try {
			Configuration configuration=new Configuration(Configuration.VERSION_2_3_0);
			ClassLoader loader=SpringbootEmailApplication.class.getClassLoader();
			configuration.setClassLoaderForTemplateLoading(loader, "templates");
			Template template=configuration.getTemplate("freemarkerMail.ftl");
			StringWriter writer=new StringWriter();
			List<Map<String, Object>> users=initMap();
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("userList",users);
			map.put("title", "忠实的朋友表单");
			template.process(map, writer);
			emailService.sendHtmlEmail("846939029@qq.com", "2859453403@qq.com", "发送freemarker模板的邮件测试", writer.toString());
		} catch (Exception e) {
			System.out.println("发送失败！！！");
			e.printStackTrace();
		}
	}
	
	@Test
	void sendEmailUsingHtml() {
		Context context=new Context();
		List<User> users=new ArrayList<>();
		users.add(new User("张山","男"));
		users.add(new User("李斯","男"));
		users.add(new User("赵榴","女"));
		context.setVariable("userList", users);
		context.setVariable("title", "酒肉朋友表单");
		String content=engine.process("htmlMail.html", context);
		emailService.sendHtmlEmail("846939029@qq.com", "2859453403@qq.com", "发送thymeleaf模板的邮件测试", content);
	}
	
	public List<Map<String, Object>> initMap(){
		List<Map<String, Object>> users=new ArrayList<Map<String,Object>>(); 		
        Map<String, Object> map=new HashMap<String, Object>();  
        map.put("userName", "张三");  
        map.put("sex", "男");    
        users.add(map);  
        map=new HashMap<String, Object>();
        map.put("userName", "李四");  
        map.put("sex", "男");       
        users.add(map); 
        map=new HashMap<String, Object>();  
        map.put("userName", "王五");  
        map.put("sex", "女");    
        users.add(map);  
        map=new HashMap<String, Object>();
        map.put("userName", "赵六");  
        map.put("sex", "男");      
        users.add(map);  
        map=new HashMap<String, Object>();
        map.put("userName", "田七");  
        map.put("sex", "女");     
        users.add(map);         
		return users;
	}
	
}
