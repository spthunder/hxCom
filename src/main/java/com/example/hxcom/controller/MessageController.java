package com.example.hxcom.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hxcom.entity.Event;
import com.example.hxcom.entity.Message;
import com.example.hxcom.mapper.MessageMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private MessageMapper messageMapper;

    @PostMapping("/message")
    @ApiOperation("添加消息记录")
    public String addMessage(Message message){
        int res = messageMapper.insert(message);
        if(res > 0){
            return "添加消息成功";
        }else{
            return "添加消息失败";
        }
    }

    @GetMapping("/message/{userId}")
    @ApiOperation("根据用户id获取消息列表")
    public List<Message> queryById(@PathVariable int userId){
        QueryWrapper<Message> wrapper = new QueryWrapper<>();
        wrapper.eq("user", userId);
        List<Message> list = messageMapper.selectList(wrapper);
        return list;
    }
}
