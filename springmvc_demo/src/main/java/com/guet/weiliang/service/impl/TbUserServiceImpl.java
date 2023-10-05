package com.guet.weiliang.service.impl;

import com.guet.weiliang.controller.Code;
import com.guet.weiliang.dao.TbUserDao;
import com.guet.weiliang.entity.TbUser;
import com.guet.weiliang.exception.BusinessException;
import com.guet.weiliang.exception.SystemException;
import com.guet.weiliang.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-10-04 10:43:55
 * @description
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public boolean save(TbUser tbUser) {
        tbUserDao.save(tbUser);
        return true;
    }

    @Override
    public boolean update(TbUser tbUser) {
        tbUserDao.update(tbUser);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        tbUserDao.delete(id);
        return true;
    }

    @Override
    public TbUser selectById(Integer id) {
        if(id == 1){
            throw new BusinessException(Code.BUSINESS_ERR,"请不要挑战我的底线!!");
        }
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, "系统异常",e);
        }
        return tbUserDao.selectById(id);

    }

    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }
}