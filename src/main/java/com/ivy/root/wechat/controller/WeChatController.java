package com.ivy.root.wechat.controller;

import com.ivy.root.common.response.ResponseVo;
import com.ivy.root.wechat.domain.WeChatAccessToken;
import com.ivy.root.wechat.service.WeChatAccessTokenService;
import com.ivy.root.wechat.util.CheckoutUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@RestController
@Api(value = "WeChat相关")
public class WeChatController {
    @Autowired
    WeChatAccessTokenService weChatAccessTokenService;

    @ApiOperation(value = "获取WeChat的AccessToken",notes = "获取WeChat的AccessToken")
    @RequestMapping(value="/getWeChatAccessToken", method = RequestMethod.GET)
    public ResponseVo<WeChatAccessToken> getWeChatAccessToken() throws IOException {
       return ResponseVo.buildSuccessInstance(weChatAccessTokenService.getAccessToken());
    }

    /**
     * 微信消息接收和token验证
     * @param model
     * @param request
     * @param response
     * @throws IOException
     */
    @ApiOperation(value = "WeChat验证",notes = "Token验证")
    @RequestMapping(value="/weChatToken.do", method = RequestMethod.GET)
    public void weChat(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean isGet = request.getMethod().toLowerCase().equals("get");
        PrintWriter print;
        if (isGet) {
            // 微信加密签名
            String signature = request.getParameter("signature");
            // 时间戳
            String timestamp = request.getParameter("timestamp");
            // 随机数
            String nonce = request.getParameter("nonce");
            // 随机字符串
            String echostr = request.getParameter("echostr");
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
            if (signature != null && CheckoutUtil.checkSignature(signature, timestamp, nonce)) {
                try {
                    print = response.getWriter();
                    print.write(echostr);
                    print.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
