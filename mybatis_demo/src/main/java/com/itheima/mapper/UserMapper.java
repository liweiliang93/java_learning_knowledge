package com.itheima.mapper;

import com.itheima.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-01-04 9:07
 * @description User数据库操作代理接口
 */
public interface UserMapper {

    /**
     * @details: 增加用户
     * @date: 2023/10/2
     * @Param: []
     * @return: void
     */
    @Insert("insert into tb_user values(null,#{userName},#{passWord},#{gender},#{addr})")
    void addUser(User user);

    /**
     * @details: 删除用户
     * @date: 2023/10/2
     * @Param: [id]
     * @return: void
     */
    @Delete("delete from tb_user where id = #{id}")
    void deleteUser(int id);

    /**
     * @details: 修改用户
     * @date: 2023/10/2
     * @Param: [user]
     * @return: void
     */
    void update(User user);

    /**
     * @details: 查询所有用户
     * @date: 2023/10/2
     * @Param: [map]
     * @return: java.util.List<com.itheima.domain.User>
     */
    List<User> selectAll();

}
