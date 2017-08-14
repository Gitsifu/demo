package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sifu on 2017/8/13
 *
 * @author sifu
 * @version 1.0.0
 */
@Service
public class UserService {
    private final UserMapper mapper;

    @Autowired
    public UserService(UserMapper mapper) {
        this.mapper = mapper;
    }

    public int add(User user) {
        return mapper.insert(user);
    }
}
