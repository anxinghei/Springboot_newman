package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.StaffMapper;
import com.example.demo.pojo.Staff;
import com.example.demo.pojo.StaffExample;

@Service
public class StaffService {

	@Autowired
	private StaffMapper staffMapper;
	
	public List<Staff> listStaffs(){
		StaffExample staffExample=new StaffExample();
		staffExample.setOrderByClause("id ASC");
		List<Staff> staffs=staffMapper.selectByExample(staffExample);
		return staffs;
	}
	
	public void updateStaff(Staff staff) {
		staffMapper.updateByPrimaryKeySelective(staff);
	}
	
	public Staff findStaffById(int id) {
		return staffMapper.selectByPrimaryKey(id);
	}
	
	public void deleteStaff(int id) {
		staffMapper.deleteByPrimaryKey(id);
	}
	
	public List<Staff> findStaff(Staff staff){
		return staffMapper.findStaff(staff);
	}
	
	public void addStaff(Staff staff) {
		staffMapper.insertSelective(staff);
	}
}
