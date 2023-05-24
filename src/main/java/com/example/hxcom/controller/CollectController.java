package com.example.hxcom.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hxcom.entity.Collect;
import com.example.hxcom.entity.Contact;
import com.example.hxcom.entity.Event;
import com.example.hxcom.entity.User;
import com.example.hxcom.mapper.CollectMapper;
import com.example.hxcom.mapper.EventMapper;
import com.example.hxcom.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CollectController {
    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private EventMapper eventMapper;
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/collect/{userId}")
    @ApiOperation("根据用户ID查询收藏列表")
    public Map<String, Object> getListByUser(@PathVariable int userId){
        Map<String, Object> data = new HashMap<>();
        QueryWrapper<Collect> wrapper = new QueryWrapper<>();
        wrapper.eq("user", userId); //匹配userId
        try{
            List<Collect> collects = collectMapper.selectList(wrapper); //列表
            User user = userMapper.selectById(userId);
            List<Event> list = new ArrayList<>();
            for(Collect collect: collects){
                Event event = eventMapper.selectById(collect.getEvent());
                if(event!=null) list.add(event);
            }
            data.put("user", user);
            data.put("event_list",list);
            if(list.isEmpty()){
                data.put("msg","empty");
            }else{
                data.put("mag","success");
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
            data.put("mag","failed");
            return data;
        }

    }
    @PostMapping("collect/add")
    @ApiOperation("新增收藏记录")
    public String addCollect(Collect collect){
        int res = collectMapper.insert(collect);
        if(res > 0){
            return "插入成功";
        }else{
            return "插入失败";
        }
    }
    @GetMapping("/collect/{userId}/{eventId}") //查询是否已经帮扶 帮扶人ID，事件ID
    @ApiOperation("查询是否已经收藏 用户ID，事件ID")
    public List query(@PathVariable int userId, @PathVariable int eventId){
        QueryWrapper<Collect> wrapper = new QueryWrapper<>();
        wrapper.eq("user", userId);
        wrapper.eq("event", eventId);
        List<Collect> list = collectMapper.selectList(wrapper);
        return list;
    }
    @DeleteMapping("/collect/{userId}/{eventId}")
    @ApiOperation("删除收藏记录 传入userId,eventId")
    public String cancelCollect(@PathVariable int userId, @PathVariable int eventId){
        QueryWrapper<Collect> wrapper = new QueryWrapper<>();
        wrapper.eq("user", userId);
        wrapper.eq("event", eventId);
        int res  = collectMapper.delete(wrapper);
        if(res > 0){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }

}
