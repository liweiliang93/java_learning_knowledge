package com.guet.weiliang.service;

import com.guet.weiliang.entity.TbUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-10-04 10:43:42
 * @description
 */
@Transactional
public interface TbUserService {

    boolean save(TbUser tbUser);

    boolean update(TbUser tbUser);

    boolean delete(Integer id);

    TbUser selectById(Integer id);

    List<TbUser> selectAll();
}