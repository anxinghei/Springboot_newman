package com.example.demo.mapper;

import com.example.demo.pojo.Staff;
import com.example.demo.pojo.StaffExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;


public interface StaffMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Staff record);

    int insertSelective(Staff record);

    List<Staff> selectByExample(StaffExample example);

    Staff selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
    
    List<Staff> findStaff(Staff staff);
}