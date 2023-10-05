package com.guet.weiliang.controller;

/**
 * @author liweiliang
 * @create 2023-10-04 15:33:30
 * @description 状态码
 */
public class Code {

    //增删改查状态码
    public static final Integer SAVE_OK = 200;
    public static final Integer UPDATE_OK = 201;
    public static final Integer DELETE_OK = 202;
    public static final Integer SELECT_OK = 203;


    public static final Integer SAVE_ERR = 204;
    public static final Integer UPDATE_ERR = 205;
    public static final Integer DELETE_ERR = 206;
    public static final Integer SELECT_ERR = 207;

    public static final Integer SYSTEM_ERR = 501;
    public static final Integer BUSINESS_ERR = 502;
    public static final Integer UNKNOWN_ERR = 502;
}