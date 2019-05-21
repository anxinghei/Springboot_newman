package com.example.demo.mapper;

import com.example.demo.pojo.Manager;
import com.example.demo.pojo.ManagerExample;
import com.example.demo.pojo.Staff;

import java.util.List;

public interface ManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Manager record);

    int insertSelective(Manager record);

    List<Manager> selectByExample(ManagerExample example);

    Manager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
    
    List<Manager> findManager(Manager manager);
}