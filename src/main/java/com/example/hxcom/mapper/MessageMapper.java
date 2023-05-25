package com.example.hxcom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hxcom.entity.Message;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper extends BaseMapper<Message> {
}
