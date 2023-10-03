package com.itweiiliang.mybatisplus_demo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itweiiliang.dao.UserDao;
import com.itweiiliang.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisplusDemoApplicationTests {

    @Autowired
    private UserDao userDao;

    /**
     * @details: 查询所有
     * @date: 2023/6/30
     * @Param: []
     * @return: void
     */
    @Test
    void testGetAll() {
        System.out.println(userDao.selectList(null));
    }


    @Test
    void testGet(){
        //LambdaQueryWrapper
        LambdaQueryWrapper<User> lambdaQueryWrapper =  new LambdaQueryWrapper();
        Integer age1 = 10;
        Integer age2 =  null;
        //选择：设置条件为age大于18,小于30的,并且当其中一个条件可以为null,仍然正常查询
        lambdaQueryWrapper.gt(null != age1,User::getAge,age1);
        lambdaQueryWrapper.lt(null != age2,User::getAge,age2);
        //投影：只显示tel
        lambdaQueryWrapper.select(User::getTel);
        System.out.println(userDao.selectList(lambdaQueryWrapper));

        //QueryWrapper
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.select("count(*) as count","tel");
        queryWrapper.groupBy("tel");
        System.out.println(userDao.selectMaps(queryWrapper));
    }

    /**
     * @details: 添加
     * @date: 2023/6/30
     * @Param: []
     * @return: void
     */
    @Test
    void testSave() {
        User user = new User();
        user.setName("itweiliang");
        int insert = userDao.insert(user);
    }

    /**
     * @details: 更新
     * @date: 2023/6/30
     * @Param: []
     * @return: void
     */
    @Test
    void testUpdate() {
        User user = userDao.selectById(3L);
        user.setName("itwei");
        int update = userDao.updateById(user);
        System.out.println(update);

        //乐观锁模拟:谁先抢到线程,谁就占据先机
        User user1 = userDao.selectById(3L);
        User user2 = userDao.selectById(3L);

        user2.setName("itwei 111");
        int update1 = userDao.updateById(user2);

        user1.setName("itwei 222");
        int update2 = userDao.updateById(user1);
    }

    /**
     * @details: 删除 deleteById、deleteByIds
     * @date: 2023/6/30
     * @Param: []
     * @return: void
     */
    @Test
    void testDelete() {
        int delete = userDao.deleteById(2L);
        System.out.println(delete);
    }


    /**
     * @details: 分页功能：先配置拦截器,再使用分页功能
     * @date: 2023/7/2
     * @Param: []
     * @return: void
     */
    @Test
    void testGetByPage(){
        IPage page = new Page(2,2);
        userDao.selectPage(page,null);
        System.out.println("当前页码:"+page.getCurrent());
        System.out.println("每页显示条数:"+page.getSize());
        System.out.println("总页数:"+page.getPages());
        System.out.println("数据为:"+page.getRecords());
    }

}
