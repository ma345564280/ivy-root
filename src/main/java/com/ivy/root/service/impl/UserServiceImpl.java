package com.ivy.root.service.impl;

import com.ivy.root.common.exception.BusinessException;
import com.ivy.root.dao.UserRoleMapper;
import com.ivy.root.domain.UserRole;
import com.ivy.root.service.UserService;
import com.ivy.root.common.request.LoginRequest;
import com.ivy.root.common.request.RegisterRequest;
import com.ivy.root.dao.UserMapper;
import com.ivy.root.domain.User;
import com.ivy.root.domain.UserAuthority;
import com.ivy.root.dto.UserRoleDto;
import com.ivy.root.vo.CurrentUserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

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
        if(userRoleDtos == null || userRoleDtos.size() == 0) {
            return null;
        }
        List<Long> roleIds = userRoleDtos.stream().map(UserRoleDto::getRoleId).collect(Collectors.toList());
        Map paramMap = new HashMap();
        paramMap.put("roleIds", roleIds);
        List<UserAuthority> userRoles = userMapper.queryAuthoritiesByCondition(paramMap);
        return userRoles;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean register(RegisterRequest param) {
        Map<String, Object> paramC = new HashMap<>(4);
        paramC.put("username", param.getUserName());
        int count = userMapper.countAccount(paramC);

        if(count != 0) {
            throw new BusinessException(60001, "该账户已存在。");
        }

        User user = new User();
        BeanUtils.copyProperties(param, user);
        userMapper.insertSelective(user);
        UserRole userRole = new UserRole(user.getId(), 2L);
        userRoleMapper.insertSelective(userRole);
        return true;
    }

    @Override
    public CurrentUserVo queryCurrentUser(Long userId) {
        Map<String, Object> param = new HashMap<>(4);

        param.put("userId", userId);
        User user = userMapper.selectByCondtion(param);

        CurrentUserVo currentUserVo = new CurrentUserVo(user);


        return null;
    }
}
