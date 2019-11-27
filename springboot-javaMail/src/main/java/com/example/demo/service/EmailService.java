package com.example.demo.service;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String from,String to,String title,String content) {
		// 创建一个简单的邮件对象
		SimpleMailMessage message=new SimpleMailMessage();
		// 设置发件邮箱
		message.setFrom(from);
		// 设置收件邮箱
		message.setTo(to);
		// 设置邮件标题
		message.setSubject(title);
		// 设置文件内容
		message.setText(content);
		// 发送邮件
		mailSender.send(message);
	}
	
	public void sendEmailWithFile(String from,String to,String title,String content,File file ) throws MessagingException {
		MimeMessage message=mailSender.createMimeMessage();
		// true表示为multipart邮件
		MimeMessageHelper helper=new MimeMessageHelper(message, true);
		helper.setFrom(from);
		helper.setTo(to);
		helper.setSubject(title);				
		helper.setText(content);
		helper.addAttachment(file.getName(), file);
		// 发送邮件
		mailSender.send(message);
	}
	
	public void sendEmailWithImg(String from,String to,String title,String content,String[] paths,String[] ids ) {
		if (paths.length!=ids.length) {
			System.out.println("发送失败");
			return ;
		}
		MimeMessage message=mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper= new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(title);
			// 设置邮件内容，参数true，表示启用html格式
			helper.setText(content,true);
			FileSystemResource systemResource=null;
			for (int i = 0; i < paths.length; i++) {
				systemResource=new FileSystemResource(new File(paths[i]));
				helper.addInline(ids[i], systemResource);
			}
			// 发送邮件
			mailSender.send(message);
		} catch (MessagingException e) {
			System.out.println("发送失败");
			e.printStackTrace();
		}			
	}
	
	public void sendHtmlEmail(String from,String to,String title,String content)  {
		try {
			MimeMessage message=mailSender.createMimeMessage();
			MimeMessageHelper helper= new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(title);
			helper.setText(content,true);
			// 发送邮件
			mailSender.send(message);
		} catch (Exception e) {
			System.out.println("发送失败");
		}
		
	}
}
