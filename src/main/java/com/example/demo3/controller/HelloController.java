package com.example.demo3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lee
 * @create 2020-05-08 17:02
 */
@Controller
public class HelloController {
//    @ResponseBody
//    @RequestMapping("/hello")
//    public String hello(){
//        return "hello";
//    }
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("key", "key对应的value");
        map.put("title", "<h2>检测转义字符<h2>");
        map.put("users", Arrays.asList("张三","lise","wangmazi"));
        return "success";
    }


//如果想要自己通过@enableWebMvc去控制时，由于
//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }
}
