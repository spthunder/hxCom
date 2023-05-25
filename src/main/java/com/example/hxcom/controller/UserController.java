package com.example.hxcom.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.injector.methods.Update;
import com.example.hxcom.entity.Event;
import com.example.hxcom.entity.User;
import com.example.hxcom.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation("新增用户")
    @PostMapping("/user")
    public String addUser(User user){
        int res = userMapper.insert(user);
        if(res > 0){
            return "添加用户成功";
        }else{
            return "添加用户失败";
        }

    }
    @ApiOperation("查询所有用户信息 0残障 1老人 2小孩 3其他")
    @GetMapping("/user/tag/{tag}")
    public List<User> getUserByTag(@PathVariable int tag){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("tag", tag);
        List<User> list = userMapper.selectList(wrapper);
        return list;
    }

    @ApiOperation("根据标签查询用户信息")
    @GetMapping("/user")
    public List<User> getUser(){
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
        return list;
    }
    @ApiOperation("更新用户信息,id,age,name,img")
    @PutMapping("/user")
    public String updateUser(User user){
        User user1 = new User();
        user1.setId(user.getId());
        user1.setAge(user.getAge());
        user1.setName(user.getName());
        user1.setImg(user.getImg());
        userMapper.updateById(user1);
        return"更新成功";
    }

    @ApiOperation("任意更新用户信息,id,age,name,img")
    @PutMapping("/user/update")
    public String updateByUser(User user){
        int res = userMapper.updateById(user);
        if(res > 0){
            return "更新成功";
        }else{
            return "更新失败";
        }
    }

    @ApiOperation("模糊查询")
    @GetMapping("/user/{name}")
    public List<User> getUserByKey(@PathVariable String name){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",name);
        List<User> users = userMapper.selectList(queryWrapper);
        return users;
    }

    @ApiOperation("查询nuser 需要帮助的人")
    @GetMapping("/user/nuser")
    public List<User> getNuser(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//    QueryWrapper<User> userQueryWrapper = Wrappers.query(); 和上面一样的效果
        queryWrapper.eq("role", 0);
        List<User> list = userMapper.selectList(queryWrapper);
        return list;
    }

    @ApiOperation("查询huser 帮助他人的人")
    @GetMapping("/user/huser")
    public List<User> getHuser(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//    QueryWrapper<User> userQueryWrapper = Wrappers.query(); 和上面一样的效果
        queryWrapper.eq("role", 1);
        List<User> list = userMapper.selectList(queryWrapper);
        return list;
    }

    @DeleteMapping("/user/{id}")
    public String deleteById(@PathVariable int id){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        int res  = userMapper.delete(wrapper);
        if(res > 0){
            return "插入成功";
        }else{
            return "插入失败";
        }
    }

    @PutMapping("/user/collect/{id}")  //传入event的id拼接到collect中
    public String update(@PathVariable int id, User user){
        UpdateWrapper<User> wrapper= new UpdateWrapper<>();
        wrapper.eq("id", user.getId());
        wrapper.set("collectList",  user.getCollectList()+ " " + id );
        int res = userMapper.update(null, wrapper);
        return "更新成功";
    }
}
