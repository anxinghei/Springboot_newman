package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.pojo.Staff;
import com.example.demo.service.StaffService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class StaffController {

	@Autowired
	private StaffService staffService;
	
	@RequestMapping("/listStaff")
	public String listStaff(Model model,@RequestParam(value = "start", defaultValue = "0") int start,
			@RequestParam(value = "size", defaultValue = "5") int size) {
		PageHelper.startPage(start,size);
		List<Staff> staffs=staffService.listStaffs();
		model.addAttribute("staffs", staffs);
		PageInfo<Staff> pageInfo=new PageInfo<Staff>(staffs);
		model.addAttribute("page", pageInfo);		
		return "listStaff";
	}
	
	@RequestMapping(value="/editStaff",method=RequestMethod.GET)
	public String toeditStaff(int id,Model model) {
		Staff staff=staffService.findStaffById(id);
		model.addAttribute("staff_edit", staff);
		return "editStaff";
	}
	@RequestMapping("/updateStaff")
	public String updateStaff(Staff staff) {
		staffService.updateStaff(staff);
		return "main";
	}
	
	@RequestMapping("/deleteStaff")
	public String deleteStaff(int id) {
		staffService.deleteStaff(id);
		return "main";
	}
}
