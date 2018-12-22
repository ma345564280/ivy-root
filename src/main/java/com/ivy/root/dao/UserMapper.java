package com.ivy.root.dao;

import com.ivy.root.domain.User;
import com.ivy.root.domain.UserAuthority;
import com.ivy.root.dto.UserRoleDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    User getOneUserByCondition(User user);

    List<UserRoleDto> queryUserRoleByCondition(HashMap map);

    List<UserAuthority> queryAuthoritiesByCondition(Map paramMap);
}