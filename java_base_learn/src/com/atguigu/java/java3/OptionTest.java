package com.atguigu.java.java3;

import org.junit.Test;

import java.util.Optional;

/**
 * @author liweiliang
 * @create 2022-11-26 19:44
 * @description Optional类的使用
 */
public class OptionTest {
    @Test
    public void test1(){
        Girl girl = new Girl();
        Optional<Girl> girl1 = Optional.of(girl);
    }
    //未使用Optional类的getGirlName
    public String getGirlName(Boy boy){
        if(boy != null){
            Girl girl = boy.getGirl();
            if(girl != null){
                return girl.getName();
            }
        }
        return null;
    }
    //使用Optional类后的
    public String getGirlName1(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("赵丽颖")));
        Girl girl = boy1.getGirl();
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        Girl girl2 = girl1.orElse(new Girl("古力娜扎"));
        return girl2.getName();
    }
    @Test
    public void test2(){
        Boy boy = new Boy();
        String girlName = getGirlName(boy);
        System.out.println(girlName);
        //容易出现空指针异常
    }
}
