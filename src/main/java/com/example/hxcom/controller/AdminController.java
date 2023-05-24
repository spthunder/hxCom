package com.example.hxcom.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hxcom.entity.Admin;
import com.example.hxcom.entity.User;
import com.example.hxcom.mapper.AdminMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminMapper adminMapper;

    @PostMapping("/admin/login")
    @ApiOperation("管理员登录")
    public List<Admin> login(Admin admin){
        System.out.println(admin.getName());
        System.out.println(admin.getPassword());
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("name",admin.getName());
        wrapper.eq("password",admin.getPassword());
        List<Admin> list = adminMapper.selectList(wrapper);
        return list;
    }
}
