package com.atguigu.reflection;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liweiliang
 * @create 2022-11-22 17:06
 * @description 动态代理的实现
 */

//代理类和被代理类共同实现的接口
interface Human{
    String getBelief();
    void eat(String food);
}
//被代理类(实现共同接口)
class Superman implements Human{
    @Override
    public String getBelief() {
        return "I believe i can fly!";
    }
    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }
}
class ProxyFactory {
    //调用此方法，返回一个代理类的对象.解决问题一
    public static Object getProxyInstance(Object obj) {//obj:被代理的对象
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(obj);
        return  Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),myInvocationHandler);
    }
}
class MyInvocationHandler implements InvocationHandler{
    public Object obj;//需要使用被代理类的对象进行赋值
    public void bind(Object obj){
        this.obj = obj ;
    }
    //当我们通过代理类的对象，调用方法a时,就会自动的调用如下的方法:invoke()
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method():即为代理类对象调用的方法,此方法也就作为了被代理类对象要调用的方法
        //obj:被代理类的对象
        //上述方法的返回值就作为当前类中invoke()的返回值
        return method.invoke(obj, args);
    }
}
public class ProxyTest {
    public static void main(String[] args) {
        Superman superman = new Superman();
        //代理类的对象
        Human proxyInstance = (Human)ProxyFactory.getProxyInstance(superman);
        //当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("四川麻辣烫");
        System.out.println("-------------------------------------------------");
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyClothFactory.produceCloth();
    }
}

