package com.example.hxcom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hxcom.entity.Contact;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContactMapper extends BaseMapper<Contact> {
}
