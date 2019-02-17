package com.ivy.root.controller;

import com.ivy.root.service.UserService;
import com.ivy.root.common.request.LoginRequest;
import com.ivy.root.common.request.RegisterRequest;
import com.ivy.root.common.response.ResponseVo;
import com.ivy.root.common.rootenum.ResponseCodeEnum;
import com.ivy.root.domain.User;
import com.ivy.root.domain.UserAuthority;
import com.ivy.root.dto.UserAuthorityDto;
import com.ivy.root.dto.UserRoleDto;
import com.ivy.root.vo.CurrentUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(value = "账户控制器")
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "登录校验")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseVo<UserAuthorityDto> login(@RequestBody LoginRequest param) {
        if(param == null || param.getUserName() == null || param.getPassword() == null)
        {
            return  ResponseVo.buildFailInstance(ResponseCodeEnum.WRONG_OR_EMPTY_PARAM);
        }

        User user = userService.getOneUserByCondition(param);
        if(user == null) {
            return ResponseVo.buildFailInstance(ResponseCodeEnum.WRONG_ACCOUNT_INFO);
        }

        List<UserRoleDto> userRoleDtos = userService.queryUserRole(user);
        if(userRoleDtos == null || userRoleDtos.size() == 0) {
            return ResponseVo.buildFailInstance(ResponseCodeEnum.ILLEGAL_ACCOUNT);
        }

        List<UserAuthority> userAuthorities = userService.queryAuthoritiesByCondition(userRoleDtos);
        List<String> authorities;
        if(userAuthorities == null || userAuthorities.size() == 0) {
            authorities = new ArrayList<>();
        } else {
            authorities = userAuthorities.stream().map(UserAuthority::getAuthorityTag).collect(Collectors.toList());
        }
        return ResponseVo.buildSuccessInstance(new UserAuthorityDto(user.getId(), user.getUserName(), authorities));
    }

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseVo<Boolean> register(@RequestBody RegisterRequest param) {
        if(!validateRegisterInfo(param)) {
            return ResponseVo.buildFailInstance(ResponseCodeEnum.WRONG_OR_EMPTY_PARAM);
        }

        boolean ret = userService.register(param);

        return ResponseVo.buildSuccessInstance(ret);
    }

    private boolean validateRegisterInfo(RegisterRequest param) {
        if(param == null) {
            return false;
        }

        if(StringUtils.isEmpty(param.getUserName()) || StringUtils.isEmpty(param.getPassword())) {
            return false;
        }
        return true;
    }

    @ApiOperation(value = "获取当前用户")
    @RequestMapping(value = "/queryCurrent", method = RequestMethod.POST)
    public ResponseVo<CurrentUserVo> queryCurrent(@RequestBody Long userId) {
        if(userId == null) {
            return ResponseVo.buildFailInstance(ResponseCodeEnum.WRONG_OR_EMPTY_PARAM);
        }

        CurrentUserVo ret = userService.queryCurrentUser(userId);

        return ResponseVo.buildSuccessInstance(ret);
    }

}