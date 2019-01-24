package com.ivy.root.wechat.service.serviceImp;

import com.alibaba.fastjson.JSONObject;
import com.ivy.root.wechat.dao.WeChatAccessTokenMapper;
import com.ivy.root.wechat.domain.WeChatAccessToken;
import com.ivy.root.wechat.service.WeChatAccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

import static com.ivy.root.wechat.util.BaseRequest.*;

@Service
public class WeChatAccessTokenServiceImpl implements WeChatAccessTokenService {

    @Value("${wechat.appId}")
    private String appId;
    @Value("${wechat.appSecret}")
    private String appSecret;
    @Value("${wechat.urlGetAccessToken}")
    private String urlGetAccessToken;

    @Autowired
    WeChatAccessTokenMapper tokenMapper;

    @Override
    public WeChatAccessToken getAccessToken() throws IOException {
        WeChatAccessToken accessToken = tokenMapper.getNewestAccessToken();

        if(accessToken != null && accessToken.getExpireDate().getTime() < System.currentTimeMillis())
        {
            return accessToken;
        }

        String url = urlGetAccessToken.replace("APPID", appId).replace("APPSECRET", appSecret);
        JSONObject jsonObject = doGet(url);
        System.out.println(jsonObject.toString());
        if(jsonObject.getString("errorcode") == null){
            accessToken = new WeChatAccessToken();
            accessToken.setAccessToken(jsonObject.getString("access_token"));
            Long expires = Long.parseLong(jsonObject.getString("expires_in"));
            Date expireDate = new Date();

            expireDate.setTime(expireDate.getTime() + (expires - 100) * 1000);
            accessToken.setExpireDate(expireDate);
            accessToken.setExpireIn(String.valueOf(expires));
            accessToken.setCreateDate(new Date());

            tokenMapper.insert(accessToken);
        }

        return accessToken;
    }
}
