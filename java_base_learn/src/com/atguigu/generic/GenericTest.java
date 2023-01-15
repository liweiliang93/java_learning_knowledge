package com.atguigu.generic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author liweiliang
 * @create 2022-10-29 21:33
 * @description 在集合中使用泛型
 */
public class GenericTest {
    @Test
    public void test(){
        Map<String,Integer> map = new HashMap<String,Integer>();
        //使用泛型实例化集合对象，以规范集合内的元素
        map.put("Tom",87);
        map.put("Jack",45);
        map.put("Jerry",87);// 均为（String,Integer）类型
//        map.put(123,"FA"); //不能添加进去
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        //方法使用泛型--->指定为实例化时的泛型
        while(iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key + "-----" + value);
        }
    }
}
