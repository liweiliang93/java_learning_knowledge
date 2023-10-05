package com.itheima.servlet.user;

import com.alibaba.fastjson.JSON;
import com.itheima.entity.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import com.itheima.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * @author liweiliang
 * @create 2023-10-02 13:31:28
 * @description user操作的所有接口都在这里
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    private final UserService userService = new UserServiceImpl();

    /**
     * @details: 添加用户
     * @date: 2023/10/2
     * @Param: [request, response]
     * @return: void
     */
    public void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //设置请求体解码为utf-8
        request.setCharacterEncoding("utf-8");
        BufferedReader reader = request.getReader();
        String params = reader.readLine();

        //将数据解析为User类并进行存储
        User user = JSON.parseObject(params,User.class);
        userService.addUser(user);
    }

    /**
     * @details: 删除用户
     * @date: 2023/10/3
     * @Param: [request, response]
     * @return: void
     */
    public void deleteUser(HttpServletRequest request, HttpServletResponse response){

        int number = 1;
        userService.deleteUser(number);
    }


    /**
     * @details: 修改用户
     * @date: 2023/10/3
     * @Param: [request, response]
     * @return: void
     */
    public void updateUser(HttpServletRequest request, HttpServletResponse response){

        User user = new User(2,"赵六","123","男","河南");
        userService.updateUser(user);
    }

    /**
     * @details: 查询所有用户
     * @date: 2023/10/2
     * @Param: [request, response]
     * @return: void
     */
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<User> users = userService.selectAll();

        //将数据封装为json以utf-8的形式传入
        String jsonString = JSON.toJSONString(users);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

}