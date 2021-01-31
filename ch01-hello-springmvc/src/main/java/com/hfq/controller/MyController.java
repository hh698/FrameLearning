package com.hfq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller:创建处理器对象（控制器），对象放在springmvc容器中  创建对象的，相当于spring中的@Service,@Component
 * 位置：在类的上面
 *
 * 能处理对象的都是控制器（处理器）  MyController能处理请求，
 *                            叫做后端控制器（back controller）
 */
@Controller
public class MyController {
    /**
     * 处理用户提交的请求，springmvc中是使用方法处理的
     * 方法是自定义的，可以有多种返回值，多种参数，方法名称自定义
     */

    /**
     *使用doSome方法处理some.do请求
     * @RequestMapping： 请求映射，作用是把一个请求地址和一个方法绑定在一起、
     *                  一个请求指定一个方法进行处理
     *            属性：1.value,是一个string，表示请求的uri地址（some.do）
     *                  value值是唯一的 在使用是，地址以"/"开头推荐
     *                 2.
     *            位置：1.在方法的上面，常用  2.在类的上面
     *    说明：使用@RequestMapping修饰的方法叫做处理器方法或者控制器方法
     *      使用@RequestMapping修饰的方法可以处理请求，类似servlet中的doGet,doPost
     *
     *    返回值：  ModelAndView 表示本次请求处理的结果
     *        Model：数据，请求完成后，显示给用户的数据
     *        View：视图，比如jsp等
     */
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(){
        ModelAndView mv= new ModelAndView();
        //添加数据,框架在请求的最后把数据放到request作用域
        //request.setAttribute("msg","qqq")  框架做的
        mv.addObject("msg","qqq");
        mv.addObject("fun","20");

        //指定视图,指定视图的完整路径
        //框架对视图执行的forword操作，相当于 request.getRequesctDispatcher("/show.jsp").forward(..)

        //框架使用视图解析器的前缀+逻辑名称+后缀组成完整路径
        mv.setViewName("show");

        //返回mv
        return mv;
    }
}
