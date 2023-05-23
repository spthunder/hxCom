package com.example.hxcom.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hxcom.entity.Contact;
import com.example.hxcom.entity.Event;
import com.example.hxcom.mapper.ContactMapper;
import com.example.hxcom.mapper.EventMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ContactController {
    @Autowired
    private ContactMapper contactMapper;
    @Autowired
    private EventMapper eventMapper;
    @GetMapping("/contact/{id}")
    @ApiOperation("根据用户ID，查询用户帮扶了哪些人")
    public List queryById(@PathVariable int id){
        QueryWrapper<Contact> wrapper = new QueryWrapper<>();
        wrapper.eq("contact", id);
        List<Contact> list = contactMapper.selectList(wrapper);
        List<Integer> eventList = new ArrayList<Integer>();
//        System.out.println(list);
        for(int  i = 0; i < list.size(); i++){
            eventList.add(list.get(i).getEvent());
        }
//        System.out.println(eventList);
        List<Event> list3 = eventMapper.selectBatchIds(eventList);
        return list3;
    }
    @PostMapping("/contact")     //添加帮扶记录
    @ApiOperation("添加帮扶记录 传递contact beContacted contactName event")
    public String add(Contact contact){
        int res = contactMapper.insert(contact);
        if(res > 0){
            return "插入成功";
        }else{
            return "插入失败";
        }
    }

    @GetMapping("/contact") //查询所有帮扶记录
    @ApiOperation("查询所有帮扶记录")
    public List query(){
        List<Contact> list = contactMapper.selectList(null);
        System.out.println(list);
        return list;
    }
}
