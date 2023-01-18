package com.atguigu.dao;

import java.util.List;

/**
 * @author liweiliang
 * @create 2022-10-30 11:27
 * @description
 */
public class DAO<T> {
    //增加一条数据
    public void add(T t){

    }
    //删除一条数据
    public boolean delete(int index){
        return false;
    }
    //修改一条数据
    public void update(int index,T t){

    }
    //查询一条数据
    public T getIndex(int index){
        return null;
    }
    //查询多条数据
    public List<T> getForList(int index){
        return null;
    }

    //泛型方法
    public <E> E getValue(){

        return null;
    }
}
