package com.hfq.controller;

import com.hfq.entity.Student;
import com.hfq.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller("/student")
public class StudentController {
    @Resource
    private StudentService studentService;

    //注册学生
    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student){
        ModelAndView mv = new ModelAndView();
        String tips = "注册失败";
         //调用sevice处理student对象
        int nums = studentService.addStudent(student);
        if(nums > 0){
            //注册成功
            tips = "学生【"+student.getName()+"】注册成功";
        }
        //添加数据
        mv.addObject("tips",tips);
        //指定结果页面
        mv.setViewName("result");
        return mv;
    }

    //处理查询，响应ajax
    @RequestMapping("queryStudent.do")
    @ResponseBody
    public List<Student> queryStudentd(){
        //参数检查，简单的数据处理
        List<Student> students =  studentService.findStudents();
        return students;
    }
}
