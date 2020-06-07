package com.example.demo3.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lee
 * @create 2020-05-31 18:45
 */

/**
 * 添加登录拦截器，检测登录状态，只有成功输入用户名和密码才进行登录
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //目标方法执行之前进行拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user==null){
            request.setAttribute("msg","没有权限，请先登录");//user为空就重新冲到index界面，并且给请求对象中加入信息进行说明。
            request.getRequestDispatcher("index.html").forward(request,response);
            return false;
        }else{
            //登录成功，返回true就说明不再进行拦截
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
