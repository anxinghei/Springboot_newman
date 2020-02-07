package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;

@Controller
public class HuTool2Codes {

		static String path=System.getProperty("user.dir");

	    // 创建 线段干扰的验证码
	    public static void lineCode(){
	        int width = 200;
	        int height = 100;
	        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(width, height);
	        System.out.println("当前的验证码是"+captcha.getCode());
	        //\src\main\resources\img
	        String path1 = path+"\\src\\main\\resources\\static\\img\\line.jpg";
	        captcha.write(path1);
	    }

	    // 创建 圆圈干扰的验证码
	    public static void circleCode(){
	        int width = 200;
	        int height = 100;
	        int codeCount = 5;
	        int circleCount = 40;
	        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(width, height,codeCount,circleCount);
	        System.out.println("当前的验证码是"+captcha.getCode());
	        String path1 = path+"\\src\\main\\resources\\static\\img\\circle.jpg";
	        captcha.write(path1);
	    }

	    // 创建 扭曲线干扰的验证码
	    public static void shearCode(){
	        int width = 200;
	        int height = 100;
	        int codeCount = 5;
	        int thickness = 2;
	        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(width, height,codeCount,thickness);
	        System.out.println("当前的验证码是"+captcha.getCode());
	        String path1 = path+"\\src\\main\\resources\\static\\img\\shear.jpg";
	        captcha.write(path1);
	    }

}
