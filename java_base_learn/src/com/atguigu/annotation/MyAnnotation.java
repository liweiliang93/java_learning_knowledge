package com.atguigu.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author liweiliang
 * @create 2022-10-06 20:14
 * @description 自定义注解：
 *      注解类型声明为：@interface(继承了java.lang.annotation.Annotation接口)
 *      内部定义成员，通常使用value表示
 *      可以指定成员的默认值，使用default定义
 *      如果自定义注解没有成员，则表明是一个表示作用
**/
@Inherited
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
public @interface MyAnnotation {
    String value() default "hello";
}
