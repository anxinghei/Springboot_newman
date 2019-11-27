package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.User;

@Controller
public class testController {
	
// 测试 Thymeleaf 和热部署是否生效
	@RequestMapping("/hello")
	public String teString(Model model ) {
		model.addAttribute("name", "ns");
		return "tea";
	}
	
// 测试引入的 css/js 文件是否生效	
	@RequestMapping("/js")
	public String testJS(Model model ) {
		model.addAttribute("name", "le");
		return "cssJS";
	}
	
// 测试功能：1、显示 转义和非转义的 html 文本 	2、显示对象以及对象属性  3、*{}方式显示属性  4、算数运算  5、包含另一个页面的信息
	@RequestMapping("/ari")
	public String testAri(Model model ) {
		User user=new User();
		user.setAge(23);
		user.setName("zsliww");
		String htmlContent = "<p style='color:red'> 红色文字</p>";
		model.addAttribute("htmlContent", htmlContent);
		model.addAttribute("user", user);
		return "Ari";
	}
	
// 测试功能：条件判断
	@RequestMapping("/if")
	public String testIf(Model model ) {
		boolean testBoolean = true;
		model.addAttribute("testBoolean", testBoolean);
		return "if";
	}
	
// 测试功能：遍历—— 1、普通遍历   2、带状态的遍历   3、结合下拉框    4、结合单选框
	@RequestMapping("/findall")
	public String testfindall(Model model ) {
		List<User> users=new ArrayList<>();
		users.add(new User(1, "zs", 13));
		users.add(new User(2, "li", 24));
		users.add(new User(4, "22", 35));
		users.add(new User(5, "zl", 9));
		users.add(new User(8, "tq", 76));
		users.add(new User(10, "ll", 56));
		User currentUser=new User(5, "zl", 9);
		model.addAttribute("users", users);
		model.addAttribute("currentUser", currentUser);
		return "findall";
	}
}
