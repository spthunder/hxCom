package com.example.hxcom.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hxcom.entity.User;
import com.example.hxcom.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserMapper userMapper;
    @PostMapping("/login")
    public List login(User user){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("name",user.getName());
        return userMapper.selectList(userQueryWrapper);
    }
    @RequestMapping(value = "/user")
    public List<User> getUser(){
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
        return list;
    }
}
