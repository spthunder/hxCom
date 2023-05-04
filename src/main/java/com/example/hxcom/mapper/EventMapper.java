package com.example.hxcom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hxcom.entity.Event;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EventMapper extends BaseMapper<Event> {
//    @Select("select * from event")
//    public List<Event> find();
//
//    @Insert("insert into event values(#{id},#{name},#{title},#{img},#{content},#{time},#{tag},#{type},#{tel},#{location})")
//    public int insert(Event event);
}
