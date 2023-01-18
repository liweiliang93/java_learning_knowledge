package com.atguigu.java.java3;

/**
 * @author liweiliang
 * @create 2022-11-26 19:45
 * @description
 */
public class Girl {

    private String name;

    public Girl( String name) {
        this.name = name;
    }

    public Girl() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
