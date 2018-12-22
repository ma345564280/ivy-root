package com.ivy.root.wechat.dao;

import com.ivy.root.wechat.domain.WeChatAccessToken;
import org.springframework.stereotype.Repository;

@Repository
public interface WeChatAccessTokenMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WeChatAccessToken record);

    int insertSelective(WeChatAccessToken record);

    WeChatAccessToken selectByPrimaryKey(Long id);

    WeChatAccessToken getNewestAccessToken();


}