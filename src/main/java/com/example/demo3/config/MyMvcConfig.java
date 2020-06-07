package com.example.demo3.config;

import com.example.demo3.component.LoginHandlerInterceptor;
import com.example.demo3.component.MylocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Lee
 * @create 2020-05-28 18:03
 */
    @Configuration
    public class MyMvcConfig  implements WebMvcConfigurer {
        @Bean
        public LocaleResolver localeResolver(){
            return new MylocaleResolver();
        }
        //所有的WebMvcConfigurerAdapter组件都会一起起作用
        @Bean //将组件注册在容器
        public WebMvcConfigurer webMvcConfigurerAdapter(){
            WebMvcConfigurer adapter = new WebMvcConfigurer() {
                @Override
                public void addViewControllers(ViewControllerRegistry registry) {
                    registry.addViewController("/").setViewName("index");
                    registry.addViewController("/index.html").setViewName("index");
                    registry.addViewController("/main.html").setViewName("dashboard");//添加视图映射，将url请求映射到某个程序文件，比在controller中写一个requestBody要好一些
                }

                //注册拦截器
                @Override
                public void addInterceptors(InterceptorRegistry registry) {
                    //super.addInterceptors(registry);
                    //静态资源；  *.css , *.js
                    //SpringBoot已经做好了静态资源映射
                    registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")//添加拦截器，pathpattern说明对那些路径进行拦截，exclude是对哪些不进行
                            .excludePathPatterns("/index.html","/","/user/login");//首先要进入到login页面，所以index不能拦截，还有用户登录过程不能拦截。其他的页面都应该拦截，防止不经过登录就直接输入网址进行用户界面了
                }
            };
            return adapter;
        }
    }
