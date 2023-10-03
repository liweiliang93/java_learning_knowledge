package com.itweiiliang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itweiiliang.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liweiliang
 * @create 2023-06-30 09:58:54
 * @description
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
