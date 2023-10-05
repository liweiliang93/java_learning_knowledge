package com.guet.weiliang.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @author liweiliang
 * @create 2023-10-03 15:35:03
 * @description 4.SpringMvc容器启动的配置类,用于初始化Spring容器,加载Bean
 */
public class ServletContainerInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    //配置SpringMvc拦截请求
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //加载SpringConfig配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }
    //加载SpringMvc配置
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    //配置filter过滤器:解决中文乱码
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        return new Filter[]{filter};
    }
}

//    //springmvc旧启动类配置
//    //加载springmvc容器配置
//    @Override
//    protected WebApplicationContext createServletApplicationContext() {
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(SpringMvcConfig.class);
//        return context;
//    }
//
//    @Override
//    protected WebApplicationContext createRootApplicationContext() {
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(SpringConfig.class);
//        return context;
//    }
