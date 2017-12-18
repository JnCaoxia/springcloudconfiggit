package com.caox.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by BF100 on 2017/12/18.
 */
@RestController // 方法都以json格式输出，不用再写什么jackjson配置的
public class HelloWorldController {
    @RequestMapping
    public String index(){
        return "Hello World";
    }
}
