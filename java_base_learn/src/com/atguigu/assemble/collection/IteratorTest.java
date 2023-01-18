package com.atguigu.assemble.collection;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * @author liweiliang
 * @create 2022-10-09 20:48
 * @description
 */
public class IteratorTest {
    @Test
    public void test(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Tom",23));
        coll.add(new Date());
        coll.add(new String("Local"));

        //迭代器实例化
        Iterator iterator = coll.iterator();

        //遍历集合
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //错误方式
        while(coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }
    }
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Tom",23));
        coll.add(new Date());
        coll.add(new String("Tom"));

        //删除集合中的"Tom"
        //如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，
        //再调用remove都会报IllegalStateException。
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            //iterator.remove();
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
                //iterator.remove();
            }
        }

        iterator = coll.iterator();//上次调用过iterator，再次将游标放置在集合之前
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
