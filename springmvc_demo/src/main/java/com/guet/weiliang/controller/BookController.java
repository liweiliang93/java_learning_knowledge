package com.guet.weiliang.controller;

import com.guet.weiliang.entity.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author liweiliang
 * @create 2023-10-03 16:17:54
 * @description SpringMvc的参数传递方式和RESTFUL开发风格
 */
@RestController
@RequestMapping("/book")
public class BookController {

    //1.JSON接收参数------------------------------
    //1.1 JSON接收参数方式:集合
    @RequestMapping("/jsonArray")
    public List<String> jsonArray(@RequestBody List<String> likes){
        System.out.println("jsonArray likes===>" + likes);
        return likes;
    }
    //1.2 JSON接收参数方式:entity
    @RequestMapping("/jsonEntity")
    public User jsonEntity(@RequestBody User user){
        System.out.println("jsonEntity likes====>" + user.toString());
        return user;
    }
    //1.3 JSON接受参数方式：集合[entity]
    @RequestMapping("/jsonArrayEntity")
    public String jsonArrayEntity(@RequestBody List<User> users){
        System.out.println("jsonArrayEntity likes====>" + users);
        return "success";
    }


    //2.普通接收参数--------------------------------
    //2.1 普通接收参数方式一:@RequestParam("")基本数据类型
    @RequestMapping("/normal")
    public String normal(@RequestParam("UserName")String name, @RequestParam("UserAge")int age){
        System.out.println("普通参数传递name====>"+ name);
        System.out.println("普通参数传递age====>"+ age);
        return "success";
    }
    //2.2 普通接收参数方式二:(参数名字相同的前提下)使用实体类接收
    @RequestMapping("/entity")
    public String entity(User user){
        System.out.println("对象参数传递name====>"+ user.getName());
        System.out.println("对象参数传递age====>"+ user.getAge());
        System.out.println("对象参数传递address====>"+ user.getAddress());
        return "success";
    }
    //2.3 普通接收参数方式三:(参数名字相同的前提下)使用数组接收
    @RequestMapping("/array")
    public String array(String[] likes){
        System.out.println("数组参数传递array====>"+ Arrays.toString(likes));
        return "success";
    }
    //2.4 普通接收参数方式三:(参数名字相同的前提下)使用集合接收
    @RequestMapping("/list")
    public String list(@RequestParam List<String> likes){
        System.out.println("数字参数传递list====>"+ likes);
        return "success";
    }
    //2.5 普通接收参数方式四:(参数名字相同的前提下)使用日期接收,默认xxx/xxx/xxx
    @RequestMapping("/date")
    public String date(Date date,@DateTimeFormat(pattern = "yyyy-MM-dd")Date date1){
        System.out.println("数字参数传递date====>"+ date);
        System.out.println("数字参数传递date1====>"+ date1);
        return "success";
    }

    //3.REST风格简化开发:
    /*
    1.@RequestBody和@Controller可由@RestController代替
    2.@RuquestMapping()的四种请求方式可有@PostMapping/@DeleteMapping/@PutMapping/@GetMapping
    */
    @PostMapping
    public String save(){
        System.out.println("save...");
        return "success";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){
        System.out.println("delete..." + id);
        return "success";
    }
    @PutMapping
    public String modify(){
        System.out.println("modify...");
        return "success";
    }
    @GetMapping("/{id}")
    public String select(@PathVariable String id){
        System.out.println("select...");
        return "success";
    }
}