package com.ivy.root.vo;

import com.ivy.root.domain.Design;
import com.ivy.root.domain.DesignImg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DesignVo {
    private Design design;
    private DesignImg designHeadImg;
    private List<DesignImg> designImgList;
}
