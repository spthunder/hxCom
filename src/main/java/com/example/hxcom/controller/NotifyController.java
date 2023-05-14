package com.example.hxcom.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hxcom.entity.Event;
import com.example.hxcom.entity.Notify;
import com.example.hxcom.mapper.NotifyMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotifyController {

    @Autowired
    private NotifyMapper notifyMapper;

    @ApiOperation("显示所有通知")
    @GetMapping("/notify")
    public List<Notify> getNotify(){
        List<Notify> list = notifyMapper.selectList(null);
        return list;
    }

    @ApiOperation("新增通知")
    @PostMapping("/notify")
    public String add(Notify notify){
        int res = notifyMapper.insert(notify);
        if(res > 0){
            return "新增成功";
        }else{
            return "增加失败";
        }
    }

    @ApiOperation("删除通知")
    @DeleteMapping("/notify/{id}")
    public String deleteById(@PathVariable int id){
        QueryWrapper<Notify> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        int res = notifyMapper.delete(wrapper);
        if(res > 0){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }
    @ApiOperation("根据标题或内容模糊查询")
    @GetMapping("/notify/search/{target}")
    public List<Notify> getNotifyByTarget(@PathVariable String target){
        QueryWrapper<Notify> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", target).or().like("content", target);
        List<Notify> notifies = notifyMapper.selectList(queryWrapper);
        System.out.println(notifies);
        return notifies;
    }
//    @ApiOperation("根据内容模糊查询")
//    @GetMapping("/notify/content/{content}")
//    public List<Notify> getEventByContent(@PathVariable String content){
//        QueryWrapper<Notify> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("content", content);
//        List<Notify> notifies = notifyMapper.selectList(queryWrapper);
//        return notifies;
//    }



}
