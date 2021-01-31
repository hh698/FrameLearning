package com.hfq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *@RequestMapping
 * value 所有请求地址的公共部分，叫做模块名称
 * 位置 在类的 上面
 *
 * 请求映射
 * 属性：method,表示请求的方式，它的值是RequestMethod类枚举值
 * 例如：get请求方式， RequestMethod.GET
 *      post请求方式， RequestMethod.POST
 */
@Controller
public class MyController {
    //指定some.do是get请求方式
    @RequestMapping(value = "/test/some.do")
    public ModelAndView doSome(){
        ModelAndView mv= new ModelAndView();
        mv.addObject("msg","qqq");
        mv.addObject("fun","20");
        mv.setViewName("show");
        return mv;
    }
}
