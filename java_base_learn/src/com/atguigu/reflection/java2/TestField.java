package com.atguigu.reflection.java2;

import com.atguigu.reflection.java1.Person1;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liweiliang
 * @create 2022-11-21 20:12
 * @description
 */
public class TestField {
    @Test
    public void testField() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        /*
        如何操作运行时类中的指定的属性-------------!!!!!掌握
         */
        Class<Person1> clazz = Person1.class;
        //创建运行时类的对象
        Person1 p = clazz.newInstance();
        //1.获取指定的属性:要求运行时类中的属性声明为public的
        //通常不采用getField()
        Field name = clazz.getDeclaredField("name");
        //2.保证当前属性是设置为可访问的
        name.setAccessible(true);
        //3.设置当前属性的值set(参数一，参数二):参数一指明设置哪一个属性  参数二：将此属性设置为多少
        name.set(p,"Tom");
        String s = (String)name.get(p);
        System.out.println(s);

        //private static int Id:设置静态属性
        Field id = clazz.getDeclaredField("Id");
        id.setAccessible(true);
        id.set(p,12);
        int i =(int)id.get(p);
        System.out.println(i);
    }
    @Test
    public void testMethod() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<Person1> clazz = Person1.class;
        Person1 p = clazz.newInstance();
        /*
        1.获取指定的某个方法:
            getDeclaredMethod():参数一：指明获取参数的方法的名称  参数二:获取方法的形参列表
        */
        Method declaredMethod = clazz.getDeclaredMethod("show", String.class);
        //2.保证当前方法是可访问的
        declaredMethod.setAccessible(true);
        /*
        3.调用方法的invoke():参数一:方法的调用者  参数二:给方法形参赋值的实参
        invoke方法的返回值即为对应类中调用的方法的返回值,若调用方法无返回值则返回值置为null
         */
        String str = (String)declaredMethod.invoke(p, "CHN");
        //private static void showDesc()
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        Object invoke = showDesc.invoke(Person1.class);
        System.out.println(invoke);
    }
}
