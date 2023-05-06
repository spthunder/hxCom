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

    @ApiOperation("显示所以通知")
    @GetMapping("/notify")
    public List<Notify> getNotify(){
        List<Notify> list = notifyMapper.selectList(null);
        return list;
    }

    @ApiOperation("新增通知")
    @PutMapping("/notify")
    public String save(Notify notify){
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




}
