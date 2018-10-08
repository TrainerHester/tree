package com.it1315.tree.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dly on 2018/10/8
 */
@RestController
public class HelloController {

    @RequestMapping("/tree")
    public String hello() {
        return "hello tree!";
    }

}
