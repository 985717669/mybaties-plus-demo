package com.mybaties.plus.demo.mybatiesplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybaties.plus.demo.mybatiesplusdemo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserMapper extends BaseMapper<User> {

}