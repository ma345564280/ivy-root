package com.ivy.root.vo;

import com.ivy.root.domain.Profile;
import com.ivy.root.domain.ProfileImg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileVo {
    private Profile profile;
    private ProfileImg sharePageBackgroundImg;
    private List<ProfileImg> enterpriseImgs;
}
