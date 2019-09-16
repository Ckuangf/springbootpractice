package com.cifor.practice.filter;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidConfiguration {

    //注册ServletRegistrationBean:SpringBoot 默认是以 jar 包的方式启动嵌入式的 Servlet 容器来启动 SpringBoot 的 web 应用，没有 web.xml 文件。
    //所以想用使用 Servlet 功能，就必须要借用 Spring Boot 提供的 ServletRegistrationBean 接口。
    @Bean
    public ServletRegistrationBean druidStatViewServle(){
        //通过该注册器注册相关的Servlet 可传参数 servlet 路径
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        servletRegistrationBean.addInitParameter("loginUsername","root");
        servletRegistrationBean.addInitParameter("loginPassword","123456");
        servletRegistrationBean.addInitParameter("resetEnable","true");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean druidStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        //添加需要忽略的格式信息
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}
