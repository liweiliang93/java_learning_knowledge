package com.atguigu.assemble.map;

/**
 * @author liweiliang
 * @create 2022-10-18 11:55
 * @description
 */
public class Person implements Comparable{
    int id;
    String name;

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Person){
            Person person = (Person)o;
            int compare = this.name.compareTo(person.name);
            if(compare != 0) {
                return compare;
            }else{
                return Integer.compare(this.id,person.id);
            }
        }else {
            throw new RuntimeException("传入的数据不匹配");
        }
    }
}
