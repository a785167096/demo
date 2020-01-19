package com.hh.controller;

import com.alibaba.fastjson.JSON;
import com.hh.DTO.Result;
import com.hh.DTO.UserDto;
import com.hh.model.User;
import com.hh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class OpController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public Result getUser(){
        List<UserDto> userList = userService.findUserList();
        return new Result("200","ok",userList);
    }

    // http://localhost:8080/users/info/show
    @PostMapping("info/show")
    public Result<User> showInfo( UserDto userDto) throws Exception {
        // 从session中获取uid
        String uid = userDto.getId();
        // 调用业务对象的showInfo()方法查询用户数据
        User ppp = userService.findUserByid(uid);
        // 返回OK与以上调用时的返回结果
        return new Result<>("200","OK", ppp);
    }

    @PostMapping("info/add")
    public Result<User> addUser(User user) {
        User user1 = new User();
        User user2 = JSON.parseObject(JSON.toJSONString(user), User.class);

        System.err.println("ddd"+user);

        userService.insertUser(user2);
        return new Result<>("200","OK", null);
    }

    @PostMapping("info/del")
    public Result<User> delUser(User user) {
        System.out.println("妈妈帮我"+user.getId());
        User user2 = JSON.parseObject(JSON.toJSONString(user), User.class);
        userService.delectUser(user2);
        return new Result<>("200","OK", null);
    }

    @PostMapping("info/update")
    public Result<User> updateUser(User user) {
        System.out.println("妈妈帮我"+user.getId());
        User user2 = JSON.parseObject(JSON.toJSONString(user), User.class);
        userService.updateUser(user2);
        return new Result<>("200","OK", null);
    }







}
