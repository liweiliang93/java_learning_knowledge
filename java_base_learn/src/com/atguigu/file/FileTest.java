package com.atguigu.file;

import org.junit.Test;

import java.io.File;

/**
 * @author liweiliang
 * @create 2022-10-31 11:57
 * @description
 */
public class FileTest {
    @Test
    public void test(){
        File file = new File("E:\\learning Information\\java learning\\hi\\nima");
        boolean mkdirs = file.mkdirs();
        System.out.println(mkdirs);
    }
}
