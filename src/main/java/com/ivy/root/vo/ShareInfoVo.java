package com.ivy.root.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShareInfoVo {
    private ProfileVo profileVo;
    private List<DesignVo> designList;
}
