package com.example.hxcom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hxcom.entity.Notify;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface NotifyMapper extends BaseMapper<Notify> {

}
