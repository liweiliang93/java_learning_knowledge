package com.atguigu.assemble.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author liweiliang
 * @create 2022-10-09 21:49
 * @description
 */
public class ForTest {
    @Test
    public void test(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Tom",23));
        coll.add(new Date());
        coll.add(new String("Local"));

        //for(集合元素的类型 局部变量 : 集合对象)
        for(Object obj : coll){
            System.out.println(obj);
        }
        int [] arr = new int[]{1,2,3};
        for(int i : arr){
            System.out.println(i);
        }

        String [] strs = new String[]{"MM","MM","MM"};
//        for (int i = 0; i < strs.length; i++) {
//            strs[i] = "GG";
//        }
        for(String str : strs){ //只是将str修改为了GG，并没有真正操作数组元素
            str = "GG";
        }
        for(int i = 0; i < strs.length;i++){    //MM MM MM
            System.out.println(strs[i]);
        }
    }
}
