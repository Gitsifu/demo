package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sifu on 2017/8/13
 *
 * @author sifu
 * @version 1.0.0
 */
@RestController
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public int add(User user){
        return service.add(user);
    }
}
