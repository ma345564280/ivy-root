package com.ivy.root.configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:druid.properties")//这是属性文件路径
public class DruidConfig {
    @Value("${druid.allows}")
    private String allows;
    @Value("${druid.denies}")
    private String denies;
    @Value("${druid.loginUsername}")
    private String loginUsername;
    @Value("${druid.loginPassword}")
    private String loginPassword;
    @Value("${druid.resetEnable}")
    private String resetEnable;

    /**
     * 注册一个StatViewServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean DruidStatViewServlet(){
        //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //添加初始化参数：initParams
        //白名单：逗号分割
        servletRegistrationBean.addInitParameter("allow",allows);
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        servletRegistrationBean.addInitParameter("deny",denies);
        //登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername",loginUsername);
        servletRegistrationBean.addInitParameter("loginPassword",loginPassword);
        //是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable", resetEnable);
        return servletRegistrationBean;
    }

    /**
     * 注册一个：filterRegistrationBean
     * @return
     */
    @Bean
    public FilterRegistrationBean druidStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
