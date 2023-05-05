package com.example.hxcom.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hxcom.entity.Event;
import com.example.hxcom.mapper.EventMapper;
import com.example.hxcom.mapper.SystemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SystemController {
    @Autowired
    private SystemMapper systemMapper;

    @GetMapping("/system")  //请求全部系统通知
    public List query(){
        List<System> list = systemMapper.selectList(null);
        System.out.println(list);
        return list;
    }
    //普通类型
    @PostMapping("/system")     //添加事件
    public String save(System system){
        int res = systemMapper.insert(system);
        if(res > 0){
            return "插入成功";
        }else{
            return "插入失败";
        }
    }
    @DeleteMapping("/system/{id}")
    public String deleteById(@PathVariable int id){
        QueryWrapper<System> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        int res  = systemMapper.delete(wrapper);
        if(res > 0){
            return "插入成功";
        }else{
            return "插入失败";
        }
    }

    @PutMapping("/system")
    public String update(System system){
        return "更新事件";
    }
}
