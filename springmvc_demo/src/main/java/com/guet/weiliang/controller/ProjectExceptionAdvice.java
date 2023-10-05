package com.guet.weiliang.controller;

import com.guet.weiliang.exception.BusinessException;
import com.guet.weiliang.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author liweiliang
 * @create 2023-10-04 16:41:16
 * @description 异常处理器,拦截系统异常并处理
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e){
        //记录日志
        //发送消息
        //发送邮件给开发人员
        return new Result(null,e.getCode(),e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e){
        return new Result(null,e.getCode(),e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception e){
        return new Result(null,Code.UNKNOWN_ERR,"系统繁忙请稍后再试");
    }
}