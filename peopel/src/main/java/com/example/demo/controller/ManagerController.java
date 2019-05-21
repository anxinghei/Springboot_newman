package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.pojo.Manager;
import com.example.demo.pojo.Staff;
import com.example.demo.service.ManagerService;
import com.example.demo.service.StaffService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class ManagerController {

	@Autowired
	private StaffService staffService;
	@Autowired
	private ManagerService managerService;
// 分页遍历所有员工	
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
// 修改员工信息	
	@RequestMapping(value="/editStaff",method=RequestMethod.GET)
	public String toeditStaff(int id,Model model) {
		Staff staff=staffService.findStaffById(id);
		model.addAttribute("staff_edit", staff);
		return "editStaff";
	}
	@RequestMapping("/updateStaff")
	public String updateStaff(Staff staff,HttpSession session) {
		staffService.updateStaff(staff);
		session.setAttribute("editMess","成功修改一条员工信息");
		return "redirect:/listStaff";
	}
// 删除员工	
	@RequestMapping("/deleteStaff")
	public String deleteStaff(int id,HttpSession session) {
		staffService.deleteStaff(id);
		session.setAttribute("editMess","成功删除一条员工信息");	
		return "redirect:/main";
	}
// 添加员工
	@RequestMapping(value="/toAddStaff",method=RequestMethod.GET)
	public String toaddStaff(Model model,@RequestParam(value = "start", defaultValue = "0") int start,
			@RequestParam(value = "size", defaultValue = "5") int size) {
		PageHelper.startPage(start,size);
		List<Manager> managers=managerService.listManagers();
		model.addAttribute("managers", managers);
		PageInfo<Manager> pageInfo=new PageInfo<Manager>(managers);
		model.addAttribute("pagem", pageInfo);
		return "addStaff";
	}
	@RequestMapping("/addStaff")
	public String addStaff(Staff staff,HttpSession session) {
		staffService.addStaff(staff);
		session.setAttribute("editMess","成功添加一条员工信息");
		return "redirect:/listStaff";
	}
// 查找员工
	@RequestMapping(value="/toFindStaff",method=RequestMethod.GET)
	public String toFindStaff(Model model,@RequestParam(value = "start", defaultValue = "0") int start,
			@RequestParam(value = "size", defaultValue = "5") int size) {
		PageHelper.startPage(start,size);
		List<Manager> managers=managerService.listManagers();
		model.addAttribute("managersFind", managers);
		PageInfo<Manager> pageInfo=new PageInfo<Manager>(managers);
		model.addAttribute("pageFind", pageInfo);
		return "findStaff";
	}
	@RequestMapping("/findStaff")
	public String findStaff(Staff staff,HttpSession session) {
		List<Staff> staffs=staffService.findStaff(staff);
		session.setAttribute("staffsFind", staffs);
		return "redirect:/toFindStaff";
	}
	
	@RequestMapping("/main")
	public String toMain(HttpSession session) {
		session.setAttribute("editMess","");
		return "main";
	}
}