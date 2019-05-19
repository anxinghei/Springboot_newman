package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.Manager;
import com.example.demo.service.managerService;

@Controller
public class managerController {

	@Autowired
	managerService managerService;
	
	@RequestMapping("/listManagers")
	public String listManagers() {
		List<Manager> managers=managerService.listManagers();
		for(Manager manager:managers)
			System.out.println(manager);
		return "index";
	}
}
