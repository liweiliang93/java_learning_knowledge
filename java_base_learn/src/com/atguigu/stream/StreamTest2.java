package com.atguigu.stream;

import com.atguigu.java.java2.Employee;
import com.atguigu.java.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author liweiliang
 * @create 2022-11-25 22:07
 * @description
 */
public class StreamTest2 {
    @Test
    public void test(){
        //allMatch()
        List<Employee> employees = EmployeeData.getEmployees();
        boolean b = employees.stream().allMatch(e -> e.getSalary() > 8500);
        System.out.println(b);

        //anyMatch()
        boolean b1 = employees.stream().anyMatch(e -> e.getSalary() > 9000);
        System.out.println(b1);

        //noneMatch()
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);

        //findFirst():返回第一个元素值
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        //findAny():返回当前流中任意元素
        Optional<Employee> any = employees.stream().parallel().findAny();
        System.out.println(any);

        //count
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);

        //max
        Stream<Double> doubleStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> max = doubleStream.max(Double::compare);
        System.out.println(max);

        Optional<Employee> max1 = employees.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println(max1);

        //min
        Optional<Employee> min = employees.stream().min(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(min);

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}
