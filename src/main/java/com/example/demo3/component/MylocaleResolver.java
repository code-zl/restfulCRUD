package com.example.demo3.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author Lee
 * @create 2020-05-28 17:52
 */
public class MylocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l=httpServletRequest.getParameter("l");//获得浏览器url传入参数的值

        //最终是要返回一个国际化locale对象，这个对象包含了区域信息
        Locale locale=Locale.getDefault();//初始化为默认值
        if(!StringUtils.isEmpty(l)){
            String[] str=l.split("_");//分割语言和国家名称
            locale=new Locale(str[0],str[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
