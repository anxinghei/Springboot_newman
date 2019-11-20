package com.example.demo.Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.User;
import com.example.demo.util.DocumentHandler;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Controller
public class WordDownLoading {

	//localhost:8080/freemarker/exportWord
	@RequestMapping("exportWord")
	@ResponseBody
	public String freemaker(HttpServletRequest req,HttpServletResponse resp) {
		List<Map<String, Object>> users=User.initMap();
		System.out.println(users);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userList",users);
		System.out.println(map);
		boolean b =new DocumentHandler().exportDoc("wordLoading", "exportWord", map, resp);
		System.out.println(b);
		return "Success";
	}
	
}
