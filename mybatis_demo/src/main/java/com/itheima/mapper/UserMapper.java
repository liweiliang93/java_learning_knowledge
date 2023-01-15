package com.itheima.mapper;

import com.itheima.pojo.Brand;
import com.itheima.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author liweiliang
 * @create 2023-01-04 9:07
 * @description
 */
public interface UserMapper {
    /***
    * @author: liweiliang
    * @date: 2023/1/4 9:32
    * @param: [map]
    * @return: java.util.List<com.itheima.pojo.User>
    * @details: 动态查询-单条件
    **/
    List<User> selectByCondition(Map map);
}
