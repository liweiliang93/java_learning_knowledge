package com.atguigu.assemble.set;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author liweiliang
 * @create 2022-10-16 9:56
 * @description
 */
public class TreeSetTest {
    @Test
    public void test() {
        TreeSet treeset = new TreeSet();
        treeset.add(new User(13,"Tom"));
        treeset.add(new User(15,"Jom"));
        treeset.add(new User(35,"Ikun"));
        treeset.add(new User(34,"Ien"));
        treeset.add(new User(45,"Ien"));
        Iterator iterator = treeset.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){
        Comparator comparator = new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User user1 = (User)o1;
                    User user2 = (User)o2;
                    return Integer.compare(user1.getAge(),user2.getAge());
                }else{
                    throw new RuntimeException("输入的数据类型不一致");
                }
            }
        };
        TreeSet treeset = new TreeSet(comparator);
         
        treeset.add(new User(13,"Tom"));
        treeset.add(new User(15,"Jom"));
        treeset.add(new User(35,"Ikun"));
        treeset.add(new User(34,"Ien"));
        treeset.add(new User(45,"Ien"));
        Iterator iterator = treeset.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
