package org.sang.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.sang.security.pojo.Role;
import org.sang.security.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {
    User loadUserByUsername(String username);
    List<Role> getUserRolesByUid(Integer id);
}
