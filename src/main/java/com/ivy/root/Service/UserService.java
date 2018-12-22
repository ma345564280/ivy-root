package com.ivy.root.Service;

import com.ivy.root.common.request.LoginRequest;
import com.ivy.root.domain.User;
import com.ivy.root.domain.UserAuthority;
import com.ivy.root.dto.UserRoleDto;

import java.util.List;

public interface UserService {

    User getOneUserByCondition(LoginRequest param);

    List<UserRoleDto> queryUserRole(User param);

    List<UserAuthority> queryAuthoritiesByCondition(List<UserRoleDto> userRoleDtos);
}
