package com.guet.weiliang.dao;

import com.guet.weiliang.entity.TbUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-10-04 10:43:15
 * @description
 */

public interface TbUserDao {

    @Insert("insert into tb_user values(null,#{userName},#{passWord},#{gender},#{addr})")
    void save(TbUser tbUser);

    @Update("update tb_user set username=#{userName},password=#{passWord},gender=#{gender},addr=#{addr} where id=#{id}")
    void update(TbUser tbUser);

    @Delete("delete from tb_user where id=#{id}")
    void delete(Integer id);

    @Select("select * from tb_user where id = #{id}")
    TbUser selectById(Integer id);

    @Select("select * from tb_user")
    List<TbUser> selectAll();
}