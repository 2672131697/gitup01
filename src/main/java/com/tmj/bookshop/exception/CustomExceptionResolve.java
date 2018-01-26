package com.tmj.bookshop.exception;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 */
public class CustomExceptionResolve implements HandlerExceptionResolver{

    /**
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param handler
     * @param e   系统抛出的异常
     * @return
     */
    @Nullable
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @Nullable Object handler, Exception e) {
        //handler就是处理器适配器要执行的handler对象(只有method)


        //解析出异常的类型
        //如果该异常是系统自定一的异常,直接取出异常信息,在错误页面显示

        /*String message=null;
        if(e instanceof CustomException){
            message = ((CustomException) e).getMessage();
        }else {
            //如果该异常不是系统自定义的异常,构造一个自定义异常类型（信息为“未知错误”）
            message = "未知错误";
        }*/

        // 上面代码变为
        CustomException customException=null;
        if(e instanceof CustomException){
            customException=(CustomException)e;
        }else{
            customException = new CustomException("未知错误");
        }

        //错误信息
        String message = customException.getMessage();

        ModelAndView modelAndView = new ModelAndView();

        //将错误信息传到页面
        modelAndView.addObject("message", message);


        //指向错误页面
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
