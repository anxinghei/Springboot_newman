package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.Manager;

@Mapper
public interface managerMapper {
	
	public List<Manager> listManagers();
}
