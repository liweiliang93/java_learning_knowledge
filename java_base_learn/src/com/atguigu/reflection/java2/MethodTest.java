package com.atguigu.reflection.java2;

import com.atguigu.reflection.java1.Person1;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @author liweiliang
 * @create 2022-11-20 23:07
 * @description
 */
public class MethodTest {
    @Test
    public void test(){
        Class clazz = Person1.class;
        //getMethod():获取获取当前运行时类及其父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for(Method m : methods){
            System.out.println(m);
        }

        System.out.println("----------------------------------");
        //getDeclaredMethod():获取当前运行时类的方法(不包含父类中的所有方法)
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m : declaredMethods){
            System.out.println(m);
        }
    }

    @Test
    public void test1(){
        Class clazz = Person1.class;
        //getMethod():获取获取当前运行时类及其父类中声明为public权限的方法
        Method[] methods = clazz.getDeclaredMethods();
        for(Method m : methods){
            //1.获取方法声明的注解
            Annotation[] annotations = m.getAnnotations();
            for(Annotation a : annotations){
                System.out.println(a);
            }
            //2.获取权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");
            //3.返回值类型
            System.out.print(m.getReturnType().getName() + "\t");
            //4.方法名
            System.out.print(m.getName() + "\t");
            //5.形参列表
            System.out.print("(");
            Class<?>[] parameterTypes = m.getParameterTypes();
            for(int i = 0;i < parameterTypes.length; i++){
                if(i == parameterTypes.length - 1){
                    System.out.print(parameterTypes[i].getName() + " args_" + i);
                    break;
                }
                System.out.print(parameterTypes[i].getName() + " args_" + i + ",");
            }
            System.out.print(")");
            //6.抛出的异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            System.out.print("throws:");
            if(exceptionTypes.length > 0) {
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1) {
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }
            System.out.println();
        }
    }
    @Test
    public void test2(){
        Class clazz = Person1.class;
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor c : constructors){
            System.out.println(c);
        }
        System.out.println("---------------------------------");
        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor c1 : declaredConstructors){
            System.out.print(c1);
        }
    }

    @Test
    public void test3(){
        //获取运行时类的父类
        Class clazz = Person1.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
        System.out.println("---------------------------------");
        //获取运行时类带泛型的父类的泛型
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for(Type t : actualTypeArguments){
            System.out.println(t.getTypeName());
        }
    }
    @Test
    public void test4(){
        //获取当前运行时类的接口
        Class clazz = Person1.class;
        Class[] interfaces = clazz.getInterfaces();
        for(Class c:interfaces){
            System.out.println(c);
        }
        System.out.println();
        //获取运行时类父类的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for(Class c:interfaces1){
            System.out.println(c);
        }
    }
    @Test  //获取运行时类的包
    public void test5(){
        Class clazz = Person1.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }
    @Test   //获取运行时类的注解
    public void test6(){
        Class clazz = Person1.class;
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation a:annotations){
            System.out.println(a);
        }
    }
}
