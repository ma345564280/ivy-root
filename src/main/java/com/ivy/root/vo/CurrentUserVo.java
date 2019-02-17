package com.ivy.root.vo;

import com.ivy.root.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author matao
 */
@Getter
@Setter
public class CurrentUserVo {
    private String name;
    private String avatar;
    private Long userid;
    private String email;
    private String signature;
    private String title;
    private String group;
    private List<String> tags;
    private Integer notifyCount;
    private String country;
    private List<String> residence;
    private String address;
    private String phone;

    public CurrentUserVo(User user) {

        this.name = user.getNickName() == null ? "" : user.getNickName();
        this.avatar = user.getPicUrl() == null ? "" : user.getPicUrl();

        this.userid = user.getId();
        this.email = user.getEmail() == null ? "" : user.getEmail();
        this.signature = user.getSignature() == null ? "" : user.getSignature();




    }
}
