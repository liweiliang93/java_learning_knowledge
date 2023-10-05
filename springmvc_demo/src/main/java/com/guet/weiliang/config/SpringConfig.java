package com.guet.weiliang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author liweiliang
 * @create 2023-10-03 15:59:18
 * @description
 */
@Configuration
//配置Spring容器加载的Bean,排除掉controller
@ComponentScan(value = "com.guet.weiliang.service")
//        value = {"com.guet.weiliang"},
//        excludeFilters = @ComponentScan.Filter(
//            type = FilterType.ANNOTATION,
//            classes = Controller.class
//    )
//)
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class,MybatisConfig.class})
@EnableTransactionManagement
public class SpringConfig {

}