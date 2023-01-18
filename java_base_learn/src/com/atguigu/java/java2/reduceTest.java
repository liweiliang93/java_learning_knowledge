package com.atguigu.java.java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liweiliang
 * @create 2022-11-26 19:21
 * @description Stream的收集
 */
public class reduceTest {
    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
        Optional<Double> reduce = doubleStream.reduce(Double::sum);
        System.out.println(reduce);
    }
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
