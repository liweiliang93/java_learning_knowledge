package com.guet.weiliang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liweiliang
 * @create 2023-10-03 16:40:47
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private int age;
    private Address address;
}