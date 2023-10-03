package com.itheima.service;

import com.itheima.entity.User;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-10-02 13:18:22
 * @description UserMapper操作服务接口
 */
public interface UserService {
    /**
     * @details: 添加用户
     * @date: 2023/10/2
     * @Param: [user]
     * @return: void
     */
    void addUser(User user);

    /**
     * @details: 删除用户
     * @date: 2023/10/2
     * @Param: [id]
     * @return: void
     */
    void deleteUser(int id);

    /**
     * @details: 修改用户
     * @date: 2023/10/2
     * @Param: [id]
     * @return: void
     */
    void updateUser(User user);

    /**
     * @details: 查询所有用户
     * @date: 2023/10/2
     * @Param: []
     * @return: java.util.List<com.itheima.domain.User>
     */
    List<User> selectAll();
}