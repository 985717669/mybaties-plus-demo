package com.mybaties.plus.demo.mybatiesplusdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mybaties.plus.demo.mybatiesplusdemo.entity.User;
import com.mybaties.plus.demo.mybatiesplusdemo.mapper.MyUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author fengjf
 * Desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatiesPlusSelectTest {

    @Autowired
    MyUserMapper userMapper;


    /**
     * 根据Id查询，只返回一条数据
     */
    @Test
    public void selectById() {
        User user = userMapper.selectById(1231231L);
        System.out.println(user);
    }


    /**
     * 查询多个id返回集合
     */
    @Test
    public void selectBatchIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4, 1141611458367381506L));
        users.forEach(System.err::println);
    }

    /**
     * 通过map构造查询条件
     */
    @Test
    public void selectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jone");
        map.put("age", "18");

        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.err::println);
    }

    /**
     * selectOne 当满足条件的结果大于一条时，会有异常，
     * 一条或者null,都没有问题
     */
    @Test
    public void selectOne() {
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.eq("name", "Billie");

        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    /**
     * 统计数量
     */
    @Test
    public void selectCount() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.ge("age", 20);
        Integer count = userMapper.selectCount(userQueryWrapper);
        System.out.println("满足条件的数据量为：" + count);
    }


    /**
     * select(String ...columns) 指定返回的列
     */
    @Test
    public void selectList() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select("id", "name", "age").ge("age", 20);

        List<User> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.err::println);
    }


    /**
     * selectMaps 将返回结果转为  map 返回
     */
    @Test
    public void selectMaps() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select("id", "name", "age").ge("age", 20);

        List<Map<String, Object>> maps = userMapper.selectMaps(userQueryWrapper);
        maps.forEach(System.err::println);
    }
}
