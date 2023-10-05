package com.itheima.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

;

/**
 * @author liweiliang
 * @create 2023-10-02 13:22:50
 * @description BaseServlet实现从类或者接口获取方法
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {

        //1.获取请求路径
        String uri = req.getRequestURI();

        //2.获取最后一段方法名
        int index = uri.lastIndexOf('/');
        String methodName = uri.substring(index + 1);

        //3.获取执行方法的对象
        Class<? extends BaseServlet> aClass = this.getClass();

        //4.执行方法
        try {
            Method method = aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}