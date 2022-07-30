package com.kaifeng.mybatisplus;

import com.kaifeng.mybatisplus.mapper.UserMapper;
import com.kaifeng.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MybatisplusApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setEmail("zhangsan@test.com");
        System.out.println(userMapper.insert(user));
        System.out.println(user.getId());

        System.out.println(userMapper.deleteById(1553224076357951489L));

        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 23);
        userMapper.deleteByMap(map);

        System.out.println(userMapper.deleteBatchIds(Arrays.asList(1L, 2L, 3L)));

        User user1 = new User();
        user.setId(4L);
        user.setName("张三");
        user.setAge(23);
        user.setEmail("zhangsan@test.com");
        System.out.println(userMapper.updateById(user1));

        System.out.println(userMapper.selectById(1L));

        userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L)).forEach(System.out::println);

        Map<String, Object> map1 = new HashMap<>();
        map1.put("age", 20);
        userMapper.selectByMap(map1).forEach(System.out::println);

        userMapper.selectList(null).forEach(System.out::println);
    }

}
