package com.itheima.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.itheima.pojo.Brand;

/**
 * @author liweiliang
 * @create 2023-01-03 19:51
 * @description
 */
public interface BrandMapper {

    /***
     * @author: liweiliang
     * @date: 2023/1/3 21:13
     * @param: []
     * @return: java.util.List<com.itheima.pojo.Brand>
     * @details: 查询所有
     **/
    List<Brand> selectAll();

    /***
     * @author: liweiliang
     * @date: 2023/1/3 21:46
     * @param: [id]
     * @return: com.itheima.pojo.Brand
     * @details: 查询详情
     **/
    @Select("select * from tb_brand where id = #{id}")
    Brand selectById(int id);

    /***
     * @author: liweiliang
     * @date: 2023/1/3 21:48
     * @param: [status, companyName, brandName]
     * @return: java.util.List<com.itheima.pojo.Brand>
     * @details: 多条件查询(散装参数)
     **/
    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName,
        @Param("brandName") String brandName);

    // /***
    // * @author: liweiliang
    // * @date: 2023/1/3 22:00
    // * @param: [brand]
    // * @return: java.util.List<com.itheima.pojo.Brand>
    // * @details: 多条件查询(对象参数)
    // **/
    // List<Brand> selectByCondition(Brand brand);

    // /***
    // * @author: liweiliang
    // * @date: 2023/1/4 9:45
    // * @param: [map]
    // * @return: java.util.List<com.itheima.pojo.Brand>
    // * @details: 多条件查询(map参数)
    // **/
    // List<Brand> selectByCondition(Map map);

    /***
     * @author: liweiliang
     * @date: 2023/1/4 9:46
     * @param: [map]
     * @return: java.util.List<com.itheima.pojo.Brand>
     * @details: 单条件查询(Map参数)
     **/
    List<Brand> selectByConditionSingle(Map map);

    /***
     * @author: liweiliang
     * @date: 2023/1/4 10:28
     * @param: [brand]
     * @return: void
     * @details: 增加数据
     **/
    void add(Brand brand);

    int update(Brand brand);

    void deleteById(int id);

    void deleteByIds(@Param("ids") int[] ids);
}
