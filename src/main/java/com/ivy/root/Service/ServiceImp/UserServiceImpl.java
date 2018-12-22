package com.ivy.root.Service.ServiceImp;

import com.ivy.root.Service.UserService;
import com.ivy.root.common.request.LoginRequest;
import com.ivy.root.dao.UserMapper;
import com.ivy.root.domain.User;
import com.ivy.root.domain.UserAuthority;
import com.ivy.root.dto.UserRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getOneUserByCondition(LoginRequest param) {
        User user = new User();
        user.setUserName(param.getUserName());
        user.setPassword(param.getPassword());
        return userMapper.getOneUserByCondition(user);
    }

    @Override
    public List<UserRoleDto> queryUserRole(User param) {
        HashMap map = new HashMap();
        map.put("userId", param.getId());
        List<UserRoleDto> userRoleDto = userMapper.queryUserRoleByCondition(map);
        return userRoleDto;
    }

    @Override
    public List<UserAuthority> queryAuthoritiesByCondition(List<UserRoleDto> userRoleDtos) {
        if(userRoleDtos == null || userRoleDtos.size() == 0) return null;
        List<Long> roleIds = userRoleDtos.stream().map(UserRoleDto::getRoleId).collect(Collectors.toList());
        Map paramMap = new HashMap();
        paramMap.put("roleIds", roleIds);
        List<UserAuthority> userRoles = userMapper.queryAuthoritiesByCondition(paramMap);
        return userRoles;
    }
}
