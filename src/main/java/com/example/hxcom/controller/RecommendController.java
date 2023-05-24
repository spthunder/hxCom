package com.example.hxcom.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hxcom.entity.Event;
import com.example.hxcom.entity.Recommend;

import com.example.hxcom.entity.User;
import com.example.hxcom.mapper.EventMapper;
import com.example.hxcom.mapper.RecommendMapper;
import com.example.hxcom.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RecommendController {
    @Autowired
    private RecommendMapper recommendMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EventMapper eventMapper;

    @ApiOperation("根据id查询推荐表")
    @GetMapping("/getById/{id}")
    public Map<String, Object> getById(@PathVariable int id){
        Map<String, Object> data = new HashMap<>();
        Recommend recommend = recommendMapper.selectById(id);
        if (recommend==null) {
            data.put("msg","null");
            return data;
        } else {
            try {
                Event event = eventMapper.selectById(recommend.getEventId());
                User user = userMapper.selectById(recommend.getUserId());
                data.put("recommend", recommend);
                data.put("event", event);
                data.put("user", user);
                data.put("msg", "success");
                return data;
            } catch (Exception e) {
                e.printStackTrace();
                data.put("msg", "exception");
                return data;
            }
        }
    }


    @GetMapping("/recommend/{userId}/{eventId}")
    @ApiOperation("建立推荐关系 传入userId和eventId")
    public String addScore(@PathVariable int userId, @PathVariable int eventId){
        QueryWrapper<Recommend> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        wrapper.eq("event_id", eventId);
        Recommend recommend = recommendMapper.selectOne(wrapper);
        int operate = 0;
        if (recommend==null) {
            Recommend r = new Recommend();
            r.setUserId(userId);
            r.setEventId(eventId);
            r.setScore(1);
             operate = recommendMapper.insert(r);
        } else {
            recommend.setScore(recommend.getScore()+1);
            operate = recommendMapper.updateById(recommend);
        }
        if (operate>0) {
            // success
            return "success";
        } else {
            return "failed";
            // fail
        }
    }

    @GetMapping("/recommend/listByUser/{userId}")
    @ApiOperation("根据userId查询推荐表")
    public Map<String, Object> listByUser(@PathVariable Integer userId) {
        Map<String, Object> data = new HashMap<>();

        QueryWrapper<Recommend> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        wrapper.orderByDesc("score");
        try {
            List<Recommend> recommends = recommendMapper.selectList(wrapper);
            User user = userMapper.selectById(userId);
            List<Event> list = new ArrayList<>();
            for (Recommend recommend : recommends) {
                Event event = eventMapper.selectById(recommend.getEventId());
                if (event!=null) list.add(event);

            }
            data.put("user", user);
            data.put("event_list", list);
            if (list.isEmpty()) {
                data.put("msg", "empty");
            } else {
                data.put("msg", "success");
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            data.put("msg", "failed");
            return  data;
        }
    }


}
