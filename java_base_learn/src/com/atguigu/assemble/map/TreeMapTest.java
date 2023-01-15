package com.atguigu.assemble.map;

import org.junit.Test;

import java.util.*;

/**
 * @author liweiliang
 * @create 2022-10-23 16:59
 * @description
 */
public class TreeMapTest {
    @Test
    public void test(){
        TreeMap treemap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person)o1;
                    Person p2 = (Person)o2;
                    int compare =  Integer.compare(p1.id,p2.id);
                    if(compare != 0){
                        return compare;
                    }else{
                        return p1.name.compareTo(p2.name);
                    }
                }
                throw  new RuntimeException("传入的数据非法");
            }
        });
        Person person = new Person(1,"Java");
        Person person1 = new Person(1,"Number");
        Person person2 = new Person(2,"Python");
        treemap.put(person,13);
        treemap.put(person1,13);
        treemap.put(person2,13);
        Set entrySet = treemap.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }
    }
}
