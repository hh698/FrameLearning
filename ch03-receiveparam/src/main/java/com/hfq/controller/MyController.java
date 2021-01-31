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
     *逐个接收请求参数
     *  要求：处理器方法的形参名和请求中参数名一致   同名的请求参数赋值给形参
     *
     */
    /**
     *请求中参数名和处理器方法中的形参名不一样
     * @RequestParam解决该问题
     * 属性 value 请求中的参数名
     *     require 是一个boolean类型，默认是ture，true表示请求中必须包含此参数
     * 位置 在处理器形参的前面
     */
    @RequestMapping(value = "/receiveproperty.do")
    public ModelAndView doSome(String name,Integer age){
        ModelAndView mv= new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        return mv;
    }

    /**
     *处理器方法形参是java对象，这个对象的属性名和请求中的参数名一样
     *框架会创建形参的java对象，给属性赋值  比如说请求中的参数是name，框架就会调用setName()
     */
    @RequestMapping(value = "/receiveobject.do")
    public ModelAndView receiveParam(Student mystudent){
        System.out.println("name:"+mystudent.getName()+" age:"+mystudent.getAge());
        ModelAndView mv= new ModelAndView();
        mv.addObject("myname",mystudent.getName());
        mv.addObject("myage",mystudent.getAge());
        mv.addObject("mystudent",mystudent);
        mv.setViewName("show");
        return mv;
    }
}
