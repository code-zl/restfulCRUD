package com.example.demo3.controller;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Lee
 * @create 2020-05-30 17:28
 */
@Controller
public class LoginController {
    @PostMapping(value = "/user/login")//这里对提交的表单请求进行处理，postMapping等同于@RequestMapping(method="post")
    public String login(@RequestParam( "username") String username,
                        @RequestParam("password") String password,
                        Map<String,String> map,
                        HttpSession session){//只有将map放入到处理方法的参数中,在html中才能取出key对应的value值
        if(!StringUtils.isEmpty(username)&&password.equals("1234")) {
            //登录成功为了防止表单重复提交（刷新后需要重新填写信息），可以重定向到主页（这里mian是随便写的，就是加一个url的请求名）。
            session.setAttribute("loginUser", username);//session中用key，value的方式存放登录信息
            return "redirect:/main.html";
        }
        else{
            map.put("msg", "用户名和密码错误");
            return "index";
        }

    }
}
