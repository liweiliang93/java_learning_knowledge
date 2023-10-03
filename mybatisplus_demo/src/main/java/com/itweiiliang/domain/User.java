package com.itweiiliang.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
// @TableName("tb_user") //处理类和表名不对应
public class User {

    //id设置自增策略
    private long id;

    private String name;

    //查询不显示密码
    @TableField(value = "pwd", select = false)
    private String password;

    private long age;
    private String tel;

    //类中有表中不存在属性online
    @TableField(exist = false)
    private Integer online;

    //设置版本
    @Version
    private Integer version;

    //设置逻辑删除
    //@TableLogic(value = "0", delval = "1")
    private Integer deleted;
}