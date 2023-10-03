package com.itheima.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liweiliang
 * @create 2023-01-03 16:55
 * @description User实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private String gender;
    private String addr;
}
