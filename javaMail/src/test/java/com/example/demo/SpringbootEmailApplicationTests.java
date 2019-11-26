package com.example.demo;

import java.io.File;

import javax.mail.MessagingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.EmailService;

@SpringBootTest
class SpringbootEmailApplicationTests {

	@Autowired
	EmailService emailService;
	
	@Test
	void sendSimpleEmail() {
		emailService.sendEmail("846939029@qq.com", "2859453403@qq.com", "发送邮件测试", "发送邮件测试");
	}
	@Test
	void sendEmailWithFile() throws MessagingException {
		emailService.sendEmailWithFile("846939029@qq.com", "2859453403@qq.com", "发送带附件的邮件测试", "这是一封带附件的邮件",new File("D:\\E_softwareFiles\\Eclipse\\Springboot_newman\\README.md"));
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
	

}
