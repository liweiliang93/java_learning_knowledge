package com.atguigu.dao;

import org.junit.Test;

/**
 * @author liweiliang
 * @create 2022-10-30 11:39
 * @description
 */
public class DAOTest {
    @Test
    public void test(){
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.add(new Customer());

    }
}
