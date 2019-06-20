package com.mybaties.plus.demo.mybatiesplusdemo;

import com.mybaties.plus.demo.mybatiesplusdemo.entity.User;
import com.mybaties.plus.demo.mybatiesplusdemo.mapper.MyUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatiesPlusTestSave {

    @Autowired
    MyUserMapper myUserMapper;


    /**
     * 测试新增
     * 主键生成策略默认为雪花算法生成的数字， 如果设置了则不自动生成
     */
    @Test
    public void insert() {
        User user = new User();
        user.setAge(20);
        user.setName("王武");
        user.setEmail("ls@153.com");
        int rows = myUserMapper.insert(user);
        System.out.println("受影响的行数:  " + rows);
    }

    /**
     * 测试查询所有
     */
    @Test
    public void selectAll() {
        List<User> users = myUserMapper.selectList(null);
        users.forEach(System.out::println);
    }

}
