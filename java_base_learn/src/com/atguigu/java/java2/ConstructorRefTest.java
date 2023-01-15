package com.atguigu.java.java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 * 二、数组引用
 * Created by shkstart
 */
public class ConstructorRefTest {
	//构造器引用
    //Supplier中的T get()
    @Test
    public void test1(){
        //之前的
        Supplier<Employee> sup1 = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        //Lambda表达式
        Supplier<Employee> sup2 = ()->new Employee();
        //构造器引用
        Supplier<Employee> sup3 = Employee::new;
	}

	//Function中的R apply(T t)
    @Test
    public void test2(){
        Function<Integer,Employee> func1 = id->new Employee(id);
        Employee apply = func1.apply(1001);
        System.out.println(apply);

        System.out.println("*********************");

        Function<Integer,Employee> func2 = Employee::new;
        Employee apply1 = func2.apply(1002);
        System.out.println(apply1);
    }

	//BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        BiFunction<Integer,String,Employee> func1 = (id,name)->new Employee(id,name);
        Employee tom = func1.apply(1001, "Tom");
        System.out.println(tom);

        System.out.println("*********************");

        BiFunction<Integer,String,Employee> func2 = Employee::new;
        System.out.println(func2.apply(1002,"Jack"));
    }

	//数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        Function<Integer,String[]> func1 = length->new String[length];
        String[] apply = func1.apply(5);
        System.out.println(Arrays.toString(apply));

        System.out.println("*********************");

        Function<Integer,String[]> func2 = String[] :: new;
        String[] apply1 = func2.apply(5);
        System.out.println(Arrays.toString(apply1));
    }
}
