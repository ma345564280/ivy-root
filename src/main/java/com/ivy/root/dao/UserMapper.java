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
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getOneUserByCondition(User user);

    List<UserRoleDto> queryUserRoleByCondition(HashMap map);

    List<UserAuthority> queryAuthoritiesByCondition(Map paramMap);

    int countAccount(Map<String, Object> paramC);
}