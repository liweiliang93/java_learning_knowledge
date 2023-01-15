package com.atguigu.setcomparetest;

/**
 * @author liweiliang
 * @create 2022-10-18 10:48
 * @description
 */
public class Employee implements Comparable<Employee>{
    private int age;
    private String name;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(int age, String name, MyDate birthday) {
        this.age = age;
        this.name = name;
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }

       @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }

    //按姓名拼音排序
//    @Override
//    public int compareTo(Object o) {
//        if(o instanceof Employee){
//            Employee employee = (Employee)o;
//            return this.name.compareTo(employee.name);
//        }
//        throw new RuntimeException("传入的数据类型不一致");
//    }
}
