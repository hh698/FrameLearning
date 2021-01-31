package com.hfq.controller;

import com.hfq.vo.Student;
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
//@RequestMapping(value = "/test")
public class MyController {
    /**
     *处理器方法返回String   表示逻辑视图名称，需要配置视图解析器
     *
     */
    @RequestMapping(value = "/returnString-view.do")
    public String doReturnView(String name,Integer age){
        ModelAndView mv= new ModelAndView();

        //show 是逻辑视图，项目中配置了视图解析器
        //框架对视图执行forward转发操作
        return "show";
    }
}
