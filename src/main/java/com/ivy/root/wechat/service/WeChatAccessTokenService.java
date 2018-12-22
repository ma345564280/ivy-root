package com.ivy.root.wechat.service;

import com.ivy.root.wechat.domain.WeChatAccessToken;

import java.io.IOException;

public interface WeChatAccessTokenService {
    WeChatAccessToken getAccessToken() throws IOException;
}
