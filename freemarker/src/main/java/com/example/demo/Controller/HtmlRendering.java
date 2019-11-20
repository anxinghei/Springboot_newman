package com.example.demo.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.User;

@Controller
public class HtmlRendering {

	// localhost:8080/freemarker/htmlRendering
	@RequestMapping("htmlRendering")
	public String rendering(Model model) {
		List<User> users = User.initList();
		model.addAttribute("userList", users);
		return "rendering";
	}
}
