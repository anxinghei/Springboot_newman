package org.sang.security.controller;

import org.sang.security.util.inExcel;
import org.sang.security.util.outExcel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class test {

	@RequestMapping("/hello")
	public String hello() {
		return "home";
	}
	@RequestMapping(value = "/exportEmp",method = RequestMethod.GET)
	public ResponseEntity<byte[]> load() {
		return outExcel.export2Excel();
	}
	@RequestMapping(value = "/importEmp",method = RequestMethod.POST)
	public String import2(MultipartFile file) {
		String string=inExcel.import2List(file);
		System.out.println(string);
		return "home";
	}
}
