package com.tmj.bookshop.interceptor;

import com.tmj.bookshop.model.User;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 测试拦截器1
 */
public class LoginInterceptor implements HandlerInterceptor{

    //进入Handler方法之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("LoginInterceptor...preHandle");

        //获得请求的URL
        String url=request.getRequestURI();

        //判断url是否是公开地址(实际开发时将公开地址配置在配置文件中)

        //这里公开地址是登录提交的地址
        if (url.indexOf("toLogin") >= 0||url.indexOf("doLogin")>=0) {
            //如果进行登录提交放行
            return true;
        }

        //判断session
        HttpSession session = request.getSession();

        //从session中取出用户信息
        User user = (User)session.getAttribute("u");
        if(user !=null){

            //身份信息存在 就放行
            return true;
        }

        //执行到这里时表示用户需要认证身份信息 ,跳转登录页面
        request.getRequestDispatcher("/toLogin").forward(request,response);
        return false;
        
    }

    //进入Handler方法之后,返回ModelAndView之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("LoginInterceptor...postHandle");
    }

    //Handler完成 执行此方法
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("LoginInterceptor...afterCompletion");
    }
}
