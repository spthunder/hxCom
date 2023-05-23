package com.example.hxcom.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.Update;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.hxcom.entity.Event;
import com.example.hxcom.entity.User;
import com.example.hxcom.mapper.EventMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventMapper eventMapper;

    @GetMapping("/event")  //请求全部事件
    public List query(){
        List<Event> list = eventMapper.selectList(null);
        System.out.println(list);
        return list;
    }
    //普通类型
    @GetMapping("/event/common")  //请求普通类型事件
    public List queryCommon(){
        QueryWrapper<Event> eventQueryWrapper = new QueryWrapper<>();
//    QueryWrapper<User> userQueryWrapper = Wrappers.query(); 和上面一样的效果
        eventQueryWrapper.eq("type", 0);
        List<Event> list = eventMapper.selectList(eventQueryWrapper);
        System.out.println(list);
        return list;
    }
    //紧急类型
    @GetMapping("/event/urgent")  //请求紧急类型事件
    public List queryUrgent(){
        QueryWrapper<Event> eventQueryWrapper = new QueryWrapper<>();
//    QueryWrapper<User> userQueryWrapper = Wrappers.query(); 和上面一样的效果
        eventQueryWrapper.eq("type", 1);
        List<Event> list = eventMapper.selectList(eventQueryWrapper);
        System.out.println(list);
        return list;
    }
    @PostMapping("/event")     //添加事件
    public String add(Event event){
        System.out.println(event.toString());
        int res = eventMapper.insert(event);
        if(res > 0){
            return "插入成功";
        }else{
            return "插入失败";
        }
    }
    @DeleteMapping("/event/{id}")
    public String deleteById(@PathVariable int id){
        QueryWrapper<Event> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        int res  = eventMapper.delete(wrapper);
        if(res > 0){
            return "插入成功";
        }else{
            return "插入失败";
        }
    }

    @ApiOperation("根据id查询事件 一次只能查询一个")
    @GetMapping("/event/{id}")
    public List<Event> queryById(@PathVariable int id){
        QueryWrapper<Event> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        List<Event> list = eventMapper.selectList(wrapper);
        return list;
    }
    @ApiOperation("根据id查询事件 一次可以查询多个 传入string类型如1 2")
    @GetMapping("/event/ids/{ids}")
    public List<Event> queryByIds(@PathVariable String ids){
        String[] a = ids.split(" ");
        List<Integer> list1 = new ArrayList<Integer>();
        for(int i = 0; i < a.length; i++){
            list1.add(Integer.parseInt(a[i]));
        }
//        QueryWrapper<Event> wrapper = new QueryWrapper<>();
        List<Event> list = eventMapper.selectBatchIds(list1);
        return list;
    }
    @ApiOperation("根据name查询事件 一次只能查询一个")
    @GetMapping("/event/fromByName/{name}")
    public List<Event> queryByName(@PathVariable String name){
        QueryWrapper<Event> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        List<Event> list = eventMapper.selectList(wrapper);
        return list;
    }
    @ApiOperation("根据用户Id查询事件 一次只能查询一个")
    @GetMapping("/event/fromById/{id}")
    public List<Event> queryByUserId(@PathVariable int id){
        QueryWrapper<Event> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", id);
        List<Event> list = eventMapper.selectList(wrapper);
        return list;
    }


    @ApiOperation("喜欢和收藏+1,必须:数据类型 string(love/collect);事件id int;操作类型:(add/sub)")
    @PutMapping("/event/{select}/{operation}")  //love++ 喜欢加1,
    public String update(@PathVariable String select, @PathVariable String operation, Event event){
        UpdateWrapper<Event> wrapper= new UpdateWrapper<>();
        if(select.equals("love")){
            wrapper.eq("id", event.getId());
            int num = event.getLove();
            if(operation.equals("add")){
                num++;
            }else if(operation.equals("sub")){
                num--;
                if(num < 0) num = 0;
            }
            wrapper.set("love", num);
        }else if(select.equals("collect")){
            wrapper.eq("id", event.getId());
            int num = event.getCollect();
            if(operation.equals("add")){
                num++;
            }else if(operation.equals("sub")){
                num--;
                if(num < 0) num = 0;
            }
            wrapper.set("collect", num);
        }
        int res = eventMapper.update(null, wrapper);
        if(res > 0){
            return "更新成功";
        }else{
            return "更新失败";
        }
    }
    @GetMapping("/event/process/{process}")
    @ApiOperation("0 未建立 1 待审核 2 流程中 3 完成")
    public List queryByProcess(@PathVariable int process){
        QueryWrapper<Event> wrapper = new QueryWrapper<>();
        wrapper.eq("process", process);
        List<Event> list = eventMapper.selectList(wrapper);
        return list;
    }

    @ApiOperation("根据标题内容用户名模糊查询")
    @GetMapping("/event/search/{target}")
    public List<Event> getEventByTarget(@PathVariable String target){
        QueryWrapper<Event> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", target).or().like("content", target).or().like("name", target);
        List<Event> events = eventMapper.selectList(queryWrapper);
        return events;
    }
//    @ApiOperation("根据内容模糊查询")
//    @GetMapping("/event/content/{content}")
//    public List<Event> getEventByContent(@PathVariable String content){
//        QueryWrapper<Event> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("content", content);
//        List<Event> events = eventMapper.selectList(queryWrapper);
//        return events;
//    }


//    @ApiOperation("更新")
//    @PutMapping("/updateById")
//    public List updateById(@RequestBody Event event) {
//        int update = eventMapper.updateById(event);
//
//    }
//    @PutMapping("/event/collect")  //collect++ 收藏加1
//    public String update(Event event){
//        UpdateWrapper<Event> wrapper= new UpdateWrapper<>();
//        wrapper.eq("id", event.getId());
//        wrapper.set("collect", event.getCollect() + 1);
//        int res = eventMapper.update(null, wrapper);
//        return "更新成功";
//    }

}
