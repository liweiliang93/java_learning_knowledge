package com.atguigu.stream;

import com.atguigu.java.java2.Employee;
import com.atguigu.java.java2.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author liweiliang
 * @create 2022-11-25 20:53
 * @description
 */
public class StreamAPITest {

    //创建Stream的方式一:通过集合
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        //default Stream<E> com.atguigu.stream():返回一个顺序流
        Stream<Employee> stream = employees.stream();
        //default Stream<E> parallelStream():返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();
    }

    //创建Stream的方式二:通过数组
    @Test
    public void test2(){
        //Arrays 的静态方法 static <T> Stream<T> com.atguigu.stream(T[] array): 返回一个流
        int[] arr = new int[]{1,2,4,5,6};
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001,"Tom");
        Employee e2 = new Employee(1002,"Jerry");
        Employee[] arr1 = new Employee[]{e1,e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    //创建Stream的方式三:通过Stream的of()
    @Test
    public void test3(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    //创建Stream的方式四:创建无限流
    @Test
    public void test4(){
        //迭代
        //public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前十个偶数
        Stream.iterate(0,t->t + 2).limit(10).forEach(System.out::println);
        //生成
        //public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    //筛选与切片
    @Test
    public void test5(){
        List<Employee> arr1 = EmployeeData.getEmployees();
        Stream<Employee> stream = arr1.stream();
        //filter():接收Lambda,从流中排除某些元素
        stream.filter(e -> e.getSalary() > 9000).forEach(System.out::println);
        System.out.println();
        //limit():阶段流，限制元素数量
        arr1.stream().limit(3).forEach(System.out::println);
        System.out.println();
        //skip():跳过元素,返回一个扔掉了前n个元素的流
        arr1.stream().skip(3).forEach(System.out::println);
        System.out.println();
        //distinct():筛选,去除重复元素,并通过流所生成元素的hashCode()和equals()去除重复元素
        arr1.add(new Employee(1010,"刘强东",40,8000));
        arr1.add(new Employee(1010,"刘强东",40,8000));
        arr1.add(new Employee(1010,"刘强东",40,8000));
        arr1.add(new Employee(1010,"刘强东",40,8000));
        arr1.add(new Employee(1010,"刘强东",40,8000));
        arr1.stream().distinct().forEach(System.out::println);
    }

    @Test
    public void test6(){
        //map(Function f):接收一个函数作为参数，该函数作用到每一个元素上,将其映射为一个新的元素
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> stringStream = employees.stream().map(Employee::getName);
        stringStream.filter(name -> name.length() > 3).forEach(System.out::println);

        //练习map():突出flatMap的使用情景
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest::fromStringToStream);
        streamStream.forEach(t->{
            t.forEach(System.out::println);
        });
        //flatMap(Function f):接收一个函数作为参数，将流中的每一个值都转化为另一个流，然后将所有合为一个流(类似于集合里面套集合)
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest::fromStringToStream);
        characterStream.forEach(System.out::println);
    }
    //将字符串中的多个字符构成的集合转化为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for(Character c:str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }
    @Test
    public void test7(){
        List<Integer> integers = Arrays.asList(12, 23, 34, 35, 35, 353, 35);
        integers.stream().sorted().forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
//        employees.com.atguigu.stream().sorted().forEach(System.out::println);//抛异常，Employee没有实现comparator接口
        employees.stream().sorted((e1,e2)->{
            return Integer.compare(e1.getAge(),e2.getAge());
        }).forEach(System.out::println);
    }
}
