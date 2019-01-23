package com.ivy.root.service;

import com.ivy.root.common.request.ShareInfoRequest;
import com.ivy.root.vo.ShareInfoVo;

public interface ApiService {
    ShareInfoVo getShareInfo(ShareInfoRequest param);
    void saveProfile(ShareInfoRequest profile);
}
