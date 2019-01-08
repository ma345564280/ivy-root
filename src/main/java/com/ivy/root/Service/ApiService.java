package com.ivy.root.Service;

import com.ivy.root.common.request.ShareInfoRequest;
import com.ivy.root.domain.Profile;
import com.ivy.root.vo.ShareInfoVo;

public interface ApiService {
    ShareInfoVo getShareInfo(ShareInfoRequest param);
    void saveProfile(ShareInfoRequest profile);
}
