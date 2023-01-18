package com.atguigu.java.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author liweiliang
 * @create 2022-11-22 23:15
 * @description Predicate断定型接口的使用
 */
public class FounctionTest {
    @Test
    public void test(){
        List<String> list = Arrays.asList("北京","南京","天津","上海","西京","普京");
        List<String> filter = filterString(list, s -> s.contains("京"));
        System.out.println(filter);
    }
    public List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }
}
