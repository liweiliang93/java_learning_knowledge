package com.atguigu.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liweiliang
 * @create 2022-11-22 20:57
 * @description
 */
interface Human1{
    String getBelief();
    void eat(String food);
}
//被代理类
class SuperMan implements Human1{
    @Override
    public String getBelief() {
        return "I believe i can fly!";
    }
    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }
}
//代理类
class ProxyFactory1{
    public static Object getProxyInstance(Object obj){
        MyInvocationHandler1 myInvocationHandler1 = new MyInvocationHandler1();
        myInvocationHandler1.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),myInvocationHandler1);
    }
}

class MyInvocationHandler1 implements InvocationHandler{
    public Object obj;
    public void bind(Object obj){
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj,args);
    }
}

public class ProxyTest3 {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human1 proxyInstance = (Human1)ProxyFactory1.getProxyInstance(superMan);
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("牛牛");
    }
}
