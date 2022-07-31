package com.kaifeng.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaifeng.mybatisplus.mapper.UserMapper;
import com.kaifeng.mybatisplus.pojo.User;
import com.kaifeng.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {



}
