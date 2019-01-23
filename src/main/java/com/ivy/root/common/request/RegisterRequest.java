package com.ivy.root.common.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String userName;
    private String mobile;
    private Integer gender;
    private Integer role;
    private Integer verification;
    private String password;
    private String email;

}
