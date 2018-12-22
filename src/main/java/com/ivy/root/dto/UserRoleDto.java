package com.ivy.root.dto;

public class UserRoleDto {
    private Long userId;
    private Long roleId;
    private String userName;
    private String roleName;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public UserRoleDto(Long userId, String userName, String roleName) {
        this.userId = userId;
        this.userName = userName;
        this.roleName = roleName;
    }

    public UserRoleDto() {
    }
}
