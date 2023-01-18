package com.atguigu.java.java3;

/**
 * @author liweiliang
 * @create 2022-11-26 19:44
 * @description
 */
public class Boy {
    private Girl girl;

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Boy() {
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }
}
