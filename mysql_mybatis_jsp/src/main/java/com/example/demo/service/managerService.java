package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.managerMapper;
import com.example.demo.pojo.Manager;

@Service
public class managerService {

	@Autowired
	managerMapper managerMapper;
	
	public List<Manager> listManagers(){
		return managerMapper.listManagers();
	}
}
