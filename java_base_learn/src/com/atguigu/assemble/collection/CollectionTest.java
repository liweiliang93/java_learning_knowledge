package com.atguigu.assemble.collection;

import org.junit.Test;

import java.util.*;

public class CollectionTest {
    @Test
    public void test(){
        Collection coll = new ArrayList();
        //1.add():像集合中添加元素
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new Date());
        //2.size():返回当前集合的长度
        System.out.println(coll.size());
        //3.addAll():将集合coll1中的所有元素加入到coll中
        Collection coll1 = new ArrayList();
        coll1.add("aa");
        coll1.add("bb");
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);
        //4.clear():
        coll.clear();
        //5.isEmpty():判断集合是否为空
        System.out.println(coll.isEmpty());
        //6.contains(obj):判断当前集合中是否含有obj,判断时会调用obj所在类的equals()方法
        Collection coll2 = new ArrayList();
        coll2.add(1242);
        coll2.add("Tom");
        coll2.add(new Date());
        coll2.add(new Person("Tom",12));
        boolean contains = coll2.contains(1242);
        System.out.println(contains);
        System.out.println(coll2.contains("Tom"));//true
        System.out.println(coll2.contains(new Person("Tom",12)));//true
        //7.containsAll(Collection coll1):判断coll1中的所有元素是否都存在于当前集合中
        Collection coll3 = Arrays.asList(123,456);
        System.out.println(coll2.containsAll(coll3));//false
        //8.remove(Object obj):从当前集合中移除obj元素
        coll2.remove(1242);
        coll2.remove(new Person("Tom",12));
        System.out.println(coll2);
        //9.removeAll(Collection coll4):差集：从当前集合中移除coll4中的所有元素
        Collection co114 = Arrays.asList("Tom");
        coll2.removeAll(co114);
        System.out.println(coll2);
    }
    @Test
    public void test1(){
        //10.retainAll(Collection coll1):获取当前集合和coll1集合的交集，并修改当前集合为交集
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("Tom",12));
        Collection coll1 = Arrays.asList(123,456);
        coll.retainAll(coll1);
        System.out.println(coll);
        //11.equals(Object obj):要想返回true，需要判断当前集合和形参集合的元素都相同
        Collection coll2 = Arrays.asList(123,456);
        boolean equals = coll.equals(coll2);
        System.out.println(equals);
        //12.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());
        //13.toArray():
            //集合----->数组
        Object[] obj = coll.toArray();
        for (int i = 0; i < obj.length; i++) {
            System.out.println(obj[i]);
        }
            //数组----->集合(整形数组用包装类)
        List<String> strings = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(strings);
        List<Integer> integers = Arrays.asList(new Integer[]{123, 456});
        System.out.println(integers);
    }
}

@SuppressWarnings("ALL")
class Person{
    private String name;
    private int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

}