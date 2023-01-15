package com.atguigu.setcomparetest;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author liweiliang
 * @create 2022-10-18 10:51
 * @description
 */
public class EmployeeTest {
    //1.使用泛型后的自然排序
    @Test
    public void test1(){
        TreeSet<Employee> set = new TreeSet<Employee>();
        Employee e1 = new Employee(55,"liudehua",new MyDate(1965,5,4));
        Employee e2 = new Employee(43,"zhangxueyou",new MyDate(1945,12,6));
        Employee e3 = new Employee(44,"guofucheng",new MyDate(1965,5,9));
        Employee e4 = new Employee(26,"liming",new MyDate(1978,12,4));
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        Iterator<Employee> iterator = set.iterator();
        while(iterator.hasNext()){
            Employee next = iterator.next();
            System.out.println(next);
        }
    }

    //2.使用泛型后的定制排序
    @Test
    public void test2() {
        TreeSet<Employee> treeset = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                MyDate b1 = o1.getBirthday();
                MyDate b2 = o2.getBirthday();
                return b1.compareTo(b2);
            }
        });
        Employee e1 = new Employee(55,"liudehua",new MyDate(1965,5,4));
        Employee e2 = new Employee(43,"zhangxueyou",new MyDate(1945,12,6));
        Employee e3 = new Employee(44,"guofucheng",new MyDate(1965,5,9));
        Employee e4 = new Employee(26,"liming",new MyDate(1978,12,4));
        treeset.add(e1);
        treeset.add(e2);
        treeset.add(e3);
        treeset.add(e4);
        Iterator<Employee> iterator = treeset.iterator();
        while(iterator.hasNext()){
            Employee next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    public void test3(){
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();
                    return b1.compareTo(b2);
                }
                throw new RuntimeException("传入的数据类型不一致");
            }
        });
        Employee e1 = new Employee(55,"liudehua",new MyDate(1965,5,4));
        Employee e2 = new Employee(43,"zhangxueyou",new MyDate(1945,12,6));
        Employee e3 = new Employee(44,"guofucheng",new MyDate(1965,5,9));
        Employee e4 = new Employee(26,"liming",new MyDate(1978,12,4));
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
