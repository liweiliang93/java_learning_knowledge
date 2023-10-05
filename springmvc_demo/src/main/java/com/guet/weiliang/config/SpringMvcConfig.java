package com.guet.weiliang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author liweiliang
 * @create 2023-10-03 15:34:00
 * @description 3.初始化容器SpringMvcConfig,设置容器加载的Bean
 */
@Configuration
@ComponentScan({"com.guet.weiliang"})
@EnableWebMvc
public class SpringMvcConfig {

}