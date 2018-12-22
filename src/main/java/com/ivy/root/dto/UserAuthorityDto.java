package com.ivy.root.dto;

import java.util.List;

public class UserAuthorityDto {
    private Long userId;
    private String userName;
    private List<String> authorities;

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

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    public UserAuthorityDto(Long userId, String userName, List<String> authorities) {
        this.userId = userId;
        this.userName = userName;
        this.authorities = authorities;
    }

    public UserAuthorityDto() {
    }
}
