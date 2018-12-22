package com.ivy.root.configuration;

import com.github.pagehelper.StringUtil;
import com.ivy.root.Service.OauthService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


//@Aspect //  声明切面
//@Component //声明组件
//@ComponentScan //组件自动扫描
//@EnableAspectJAutoProxy //spring自动切换JDK动态代理和CGLIB
public class OauthAspect {
//    @Autowired
//    private OauthService oauthService;
//
//    @Before("execution(public * com.ivy.root.controller.*.*(..)) && @annotation(com.ivy.root.common.annotation.Oauth)")
//    public void doOauth(JoinPoint point) throws Throwable {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        //获取调用者带来的token
//        Object token = request.getHeaders("token").nextElement();
//        //截取请求的uri
//        String requestUri = request.getRequestURI();
//        int num = requestUri.length() - requestUri.replace("/", "").length();
//        if (num >= 4) {
//            //截取/a/b/c三层后面的字符
//            requestUri = getStr(requestUri, 3);
//        }
//        System.out.println("token:" + token + "=======" + "requestUri:" + requestUri);
//        //根据uri来获取接口开发状态
//        Integer isValid = oauthService.getIsValid(requestUri);
//        if (StringUtil.isEmpty(isValid)) {
//            System.out.println("接口状态：关闭！");
//            throw new Exception("接口状态：关闭，不允许访问！");
//        } else {
//            if (isValid == 1) {
//                System.out.println("接口状态：可用！");
//            } else {
//                System.out.println("接口状态：关闭！");
//                throw new Exception("接口状态：关闭，不允许访问！");
//            }
//        }
//
//        //根据uri来获取鉴权约定的token
//        String id = oauthService.getId(requestUri);
//        //判断是否一致，是：放行；否则抛出异常
//        if (token.equals(id)) {
//            System.out.println("权限通过，放行");
//        } else {
//            throw new Exception("权限不满足,不允许访问次接口！请先去鉴权！！");
//        }
//    }
//
//    private static String getStr(String str, int n) {
//        int i = 0;
//        int s = 0;
//        while (i++ < n) {
//            s = str.indexOf("/", s + 1);
//            if (s == -1) {
//                return str;
//            }
//        }
//        return str.substring(0, s);
//    }
}
