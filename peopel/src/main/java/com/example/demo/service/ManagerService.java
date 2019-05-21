package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.ManagerMapper;
import com.example.demo.pojo.Manager;
import com.example.demo.pojo.ManagerExample;

@Service
public class ManagerService {

	@Autowired
	private ManagerMapper managerMapper;
	
	public List<Manager> listManagers(){
		ManagerExample managerExample=new ManagerExample();
		managerExample.setOrderByClause("id ASC");
		List<Manager> managers=managerMapper.selectByExample(managerExample);
		return managers;
	}
	
	public void updateManager(Manager manager) {
		managerMapper.updateByPrimaryKeySelective(manager);
	}
	
	public Manager findManagerById(int id) {
		return managerMapper.selectByPrimaryKey(id);
	}
	
	public void deleteManager(int id) {
		managerMapper.deleteByPrimaryKey(id);
	}
	
	public List<Manager> findManager(Manager manager){
		return managerMapper.findManager(manager);
	}
	
	public void addManager(Manager manager) {
		managerMapper.insertSelective(manager);
	}
}
