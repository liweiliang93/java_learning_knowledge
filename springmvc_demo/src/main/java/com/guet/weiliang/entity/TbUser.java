package com.guet.weiliang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

;

/**
 * @author liweiliang
 * @create 2023-10-04 10:41:03
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbUser {
    private String id;
    private String userName;
    private String passWord;
    private char gender;
    private String addr;
}