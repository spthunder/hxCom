package com.example.hxcom.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hxcom.entity.Event;
import com.example.hxcom.mapper.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventMapper eventMapper;

    @GetMapping("/event")
    public List query(){
        List<Event> list = eventMapper.selectList(null);
        System.out.println(list);
        return list;
    }
    //普通类型
    @GetMapping("/event/common")
    public List queryCommon(){
        QueryWrapper<Event> eventQueryWrapper = new QueryWrapper<>();
//    QueryWrapper<User> userQueryWrapper = Wrappers.query(); 和上面一样的效果
        eventQueryWrapper.eq("type", 0);
        List<Event> list = eventMapper.selectList(eventQueryWrapper);
        System.out.println(list);
        return list;
    }
    //紧急类型
    @GetMapping("/event/urgent")
    public List queryUrgent(){
        QueryWrapper<Event> eventQueryWrapper = new QueryWrapper<>();
//    QueryWrapper<User> userQueryWrapper = Wrappers.query(); 和上面一样的效果
        eventQueryWrapper.eq("type", 1);
        List<Event> list = eventMapper.selectList(eventQueryWrapper);
        System.out.println(list);
        return list;
    }
    @PostMapping("/event/add")
    public String save(Event event){
        int res = eventMapper.insert(event);
        if(res > 0){
            return "插入成功";
        }else{
            return "插入失败";
        }
    }

}
