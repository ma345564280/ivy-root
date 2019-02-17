package com.ivy.root.service;

import com.ivy.root.common.request.LoginRequest;
import com.ivy.root.common.request.RegisterRequest;
import com.ivy.root.domain.User;
import com.ivy.root.domain.UserAuthority;
import com.ivy.root.dto.UserRoleDto;
import com.ivy.root.vo.CurrentUserVo;

import java.util.List;

public interface UserService {

    User getOneUserByCondition(LoginRequest param);

    List<UserRoleDto> queryUserRole(User param);

    List<UserAuthority> queryAuthoritiesByCondition(List<UserRoleDto> userRoleDtos);

    boolean register(RegisterRequest param);

    CurrentUserVo queryCurrentUser(Long userId);
}
