package com.guet.weiliang.controller;

import com.guet.weiliang.entity.TbUser;
import com.guet.weiliang.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author liweiliang
 * @create 2023-10-04 11:02:06
 * @description RESTFUL风格的增删改查对饮api-fox的各个接口
 */
@RestController
@RequestMapping("/tbuser")
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;

    @PostMapping
    public Result save(@RequestBody TbUser tbUser) {
        boolean save = tbUserService.save(tbUser);
        String saveStr = save ? "保存成功" : "保存失败";
        return new Result(save,save ? Code.SAVE_OK : Code.SAVE_ERR,saveStr);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean delete = tbUserService.delete(id);
        String deleteStr = delete ? "删除成功" : "删除失败";
        return new Result(delete,delete ? Code.SAVE_OK : Code.SAVE_ERR,deleteStr);
    }

    @PutMapping
    public Result update(@RequestBody TbUser tbUser) {
        boolean update = tbUserService.update(tbUser);
        String updateStr = update ? "更新成功" : "更新失败";
        return new Result(update,update ? Code.SAVE_OK : Code.SAVE_ERR,updateStr);
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        TbUser tbUser = tbUserService.selectById(id);
        Integer code = tbUser == null ? Code.SELECT_ERR : Code.SELECT_OK;
        String message = tbUser == null ? "查询失败" : "查询成功";
        return new Result(tbUser,code,message);
    }

    @GetMapping
    public Result selectAll() {
        List<TbUser> tbUsers = tbUserService.selectAll();
        Integer code = tbUsers == null ? Code.SELECT_ERR : Code.SELECT_OK;
        String message = tbUsers == null ? "查询失败" : "查询成功";
        return new Result(tbUsers,code,message);
    }
}