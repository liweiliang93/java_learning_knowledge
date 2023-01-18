package com.atguigu.generic;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * @author liweiliang
 * @create 2022-10-30 14:43
 * @description 1.泛型在继承方面的体现：
 *                 虽然类A是类B的父类，但是G<A>，G<B>不具备子父类关系，二者是并列关系
 *                 补充：类A是类B的父类，则A<G>、B<G>仍具备子父类关系
 *              2.通配符的使用: ?
 *                  类A是类B的父类，则G<A>、G<B>是没有关系的。二者共同的父类是：G<?>
 *
 */
public class GenericTest2 {
    @Test
    public void test(){
        Object obj  = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] str1 = null;
        arr1 = str1;

        List<Object> list1 = null;
        List<String> list2 = null;
        //此时的List1和list2的类型不具有子父类关系
//        list1 = list2;

        List<?> list = null;
        list = list1;
        list = list2;

        List<? extends Person> li1 = null;
        List<? super Person> li2 = null;

        List<Student> lis3 = null;
        List<Person> lis4 = null;
        List<Object> lis5 = null;

        li1 = lis3;
        li1 = lis4;
        li2 = lis4;
        li2 = lis5;

    }
    public void show(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

}

