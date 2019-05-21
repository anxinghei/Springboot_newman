package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.pojo.Manager;
import com.example.demo.pojo.Manager;
import com.example.demo.service.ManagerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class BossController {

	@Autowired
	private ManagerService managerService;

// 分页遍历所有经理
	@RequestMapping("/listManager")
	public String listManager(Model model, @RequestParam(value = "start", defaultValue = "0") int start,
			@RequestParam(value = "size", defaultValue = "10") int size) {
		PageHelper.startPage(start, size);
		List<Manager> managers = managerService.listManagers();
		model.addAttribute("managers", managers);
		PageInfo<Manager> pageInfo = new PageInfo<Manager>(managers);
		model.addAttribute("page", pageInfo);
		return "listManager";
	}
// 修改经理信息
	@RequestMapping(value = "/editManager", method = RequestMethod.GET)
	public String toeditManager(int id, Model model) {
		Manager manager = managerService.findManagerById(id);
		model.addAttribute("manager", manager);
		return "editManager";
	}
	@RequestMapping("/updateManager")
	public String updateManager(Manager manager, HttpSession session) {
		managerService.updateManager(manager);
		session.setAttribute("editManager", "成功修改一条经理信息");
		return "redirect:/listManager";
	}
// 删除经理
	@RequestMapping("/deleteManager")
	public String deleteManager(int id, HttpSession session) {
		managerService.deleteManager(id);
		session.setAttribute("editManager", "成功删除一条经理信息");
		return "redirect:/listManager";
	}
// 添加经理
	@RequestMapping(value = "/toAddManager", method = RequestMethod.GET)
	public String toaddManager() {
		return "addManager";
	}
	@RequestMapping("/addManager")
	public String addManager(Manager manager, HttpSession session) {
		managerService.addManager(manager);
		session.setAttribute("editManager", "成功添加一条经理信息");
		return "redirect:/listManager";
	}
// 查找经理
	@RequestMapping(value = "/toFindManager", method = RequestMethod.GET)
	public String toFindManager() {
		return "findManager";
	}
	@RequestMapping("/findManager")
	public String findManager(Manager manager, HttpSession session) {
		List<Manager> managers = managerService.findManager(manager);
		session.setAttribute("managersFind", managers);
		return "redirect:/toFindManager";
	}
}
