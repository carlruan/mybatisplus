package com.kaifeng.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.kaifeng.mybatisplus.mapper.UserMapper;
import com.kaifeng.mybatisplus.pojo.User;
import com.kaifeng.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class MybatisplusApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
//        User user = new User();
//        user.setName("张三");
//        user.setAge(23);
//        user.setEmail("zhangsan@test.com");
//        System.out.println(userMapper.insert(user));
//        System.out.println(user.getId());
//
//        System.out.println(userMapper.deleteById(1553224076357951489L));
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "张三");
//        map.put("age", 23);
//        userMapper.deleteByMap(map);
//
//        System.out.println(userMapper.deleteBatchIds(Arrays.asList(1L, 2L, 3L)));
//
//        User user1 = new User();
//        user.setId(4L);
//        user.setName("张三");
//        user.setAge(23);
//        user.setEmail("zhangsan@test.com");
//        System.out.println(userMapper.updateById(user1));
//
//        System.out.println(userMapper.selectById(1L));
//
//        userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L)).forEach(System.out::println);
//
//        Map<String, Object> map1 = new HashMap<>();
//        map1.put("age", 20);
//        userMapper.selectByMap(map1).forEach(System.out::println);
//
//        userMapper.selectList(null).forEach(System.out::println);

        System.out.println(userMapper.selectMapById(1L));
    }

    @Autowired
    private UserService userService;

    @Test
    public void test2() {
        System.out.println(userService.count());
    }

    @Test
    public void insertMany(){
        List<User> l = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            User user = new User();
            user.setName("testUser" + i);
            user.setAge(i + 20);
            user.setEmail(user.getName() + "@test.com");
            l.add(user);
        }
        boolean b = userService.saveBatch(l);
        System.out.println(b);
    }

    @Test
    public void queryWrapperTest(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "e").between("age", 20, 30).isNotNull("email");
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    @Test
    public void test3(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("id");
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }
    @Test
    public void deleteTest(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        System.out.println(userMapper.delete(queryWrapper));
    }

    @Test
    public void test4(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 20).like("name", "a").or().isNull("email");
        User user = new User();
        user.setName("小明");
        user.setEmail("xiaoming@test.com");
        user.setAge(19);
        System.out.println(userMapper.update(user, queryWrapper));
    }

    @Test
    public void test5(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name", "age");
        userMapper.selectMaps(queryWrapper).forEach(System.out::println);
    }

    @Test
    public void subQuery(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("age", "select age from t_user where age = 24");
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    @Test
    public void upddateWrapper(){
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.like("name", "小").set("name", "小黑");
        System.out.println(userMapper.update(null, userUpdateWrapper));
    }

}
