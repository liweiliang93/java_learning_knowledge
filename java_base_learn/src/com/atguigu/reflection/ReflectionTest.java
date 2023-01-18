package com.atguigu.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author liweiliang
 * @create 2022-11-06 14:23
 * @description 通过反射，调用类的所有结构
 */
public class ReflectionTest {
    @Test
    public void test(){
        Person p = new Person(12,"Tom");
        p.age = 10;
        System.out.println(p.toString());
        p.show();
        //在Person类的外部，不可以通过Person的对象调用其内部私有结构
    }
    @Test
    public void test1() throws Exception {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(int.class, String.class);
        Person tom = constructor.newInstance(23,"Tom");
        Field age = personClass.getDeclaredField("age");
        //通过反射调用属性
        age.set(tom,10);
        System.out.println(tom);
        //通过反射调用方法
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(tom);
        //调用私有的构造器
        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person jerrry = declaredConstructor.newInstance("Jerrry");
        System.out.println(jerrry);
        //调用私有的属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(jerrry,"Hanmeimie");
        System.out.println(jerrry);
        //调用私有的方法
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(jerrry,"中国");
    }
    @Test
    public void test2() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class clazz = Person.class;
        //方式二：通过运行时类的对象,调用getClass()方法
        Person p1 = new Person();
        Class aClass = p1.getClass();
        System.out.println(aClass);
        //方式三：调用Class的静态方法：forName(String classPath)
        Class aClass1 = Class.forName("com.atguigu.reflection.Person");
        System.out.println(aClass1);
        System.out.println(clazz == aClass);
        System.out.println(aClass == aClass1);
        //方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class aClass2 = classLoader.loadClass("com.atguigu.reflection.Person");
        System.out.println(aClass2);
    }
}
