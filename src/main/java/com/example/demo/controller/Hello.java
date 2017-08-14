package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sifu on 2017/8/13
 *
 * @author sifu
 * @version 1.0.0
 */
@RestController
public class Hello {
    @RequestMapping("/hi")
    public String hello(){
        return "hello world";
    }
}
