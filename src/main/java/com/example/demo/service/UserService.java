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
public interface UserService {
    int add(User user);
}
