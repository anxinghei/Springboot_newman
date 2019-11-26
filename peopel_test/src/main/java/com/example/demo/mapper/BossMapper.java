package com.example.demo.mapper;

import com.example.demo.pojo.Boss;
import com.example.demo.pojo.BossExample;
import java.util.List;

public interface BossMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Boss record);

    int insertSelective(Boss record);

    List<Boss> selectByExample(BossExample example);

    Boss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Boss record);

    int updateByPrimaryKey(Boss record);
}