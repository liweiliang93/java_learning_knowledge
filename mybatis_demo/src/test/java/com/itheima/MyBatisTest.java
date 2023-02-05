package com.itheima;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;

/**
 * @author liweiliang
 * @create 2023-01-03 19:38
 * @description 快速入门
 */
public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
        // 1.获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.获取BrandMapper接口对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> users = brandMapper.selectAll();
        System.out.println(users);
        // 4.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        // 接收参数id
        int id = 2;
        // 1.获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.获取BrandMapper接口对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);
        // 4.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {
        // 获取信息
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";
        // 封装对象
        // Brand brand = new Brand();
        // brand.setBrandName(brandName);
        // brand.setCompanyName(companyName);
        // brand.setStatus(status);
        // map集合
        // HashMap map = new HashMap();
        // map.put("status",status);
        // map.put("companyName",companyName);
        // map.put("brandName",brandName);
        // 1.获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.获取BrandMapper接口对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        // List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);
        // 4.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByConditionSingle() throws IOException {
        // 获取信息
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";
        // 封装对象
        // Brand brand = new Brand();
        // brand.setBrandName(brandName);
        // brand.setCompanyName(companyName);
        // brand.setStatus(status);
        // map集合
        HashMap map = new HashMap();
        // map.put("status",status);
        // map.put("companyName",companyName);
        // map.put("brandName",brandName);
        // 1.获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.获取BrandMapper接口对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        List<Brand> brands = brandMapper.selectByConditionSingle(map);
        System.out.println(brands);
        // 4.释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 100;
        // 封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(); // 设置为true，自动提交事务
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);
        List<Brand> brands = brandMapper.selectAll();
        brands.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "波导手机,手机中的战斗机";
        int ordered = 200;
        int id = 6;
        // 封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        // brand.setBrandName(brandName);
        // brand.setCompanyName(companyName);
        // brand.setDescription(description);
        // brand.setOrdered(ordered);
        brand.setId(id);
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true); // 设置为true，自动提交事务
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Integer count = brandMapper.update(brand);
        System.out.println(count);
        List<Brand> brands = brandMapper.selectAll();
        brands.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testDelete() throws IOException {
        int[] ids = {5, 6, 7, 8};
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.deleteByIds(ids);
        List<Brand> brands = brandMapper.selectAll();
        brands.forEach(System.out::println);
        sqlSession.close();
    }
}
