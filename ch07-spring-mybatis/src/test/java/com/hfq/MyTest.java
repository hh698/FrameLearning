package com.hfq;


import com.hfq.dao.StudentDao;
import com.hfq.entity.Student;
import com.hfq.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void testDaoInsert(){
        String config ="applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //获取spring容器中的dao对象
        StudentDao studentDao = (StudentDao) ac.getBean("studentDao");
        Student student = new Student();
        student.setId(1010);
        student.setName("山羊");
        student.setEmail("shanyang@163.com");
        student.setAge(18);
        int nums =  studentDao.insertStudent(student);
        //spring和mybaits整合后，事务是是自动提交的，无需sqlSession.commit()
        System.out.println(nums);
    }

    @Test
    public void testServiceInsert(){
        String config ="applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //获取spring容器中的dao对象
        StudentService ss = (StudentService) ac.getBean("studentService");
        Student student = new Student();
        student.setId(1010);
        student.setName("岩石");
        student.setEmail("yanshi@163.com");
        student.setAge(18);
        int nums =  ss.addStudent(student);
        //spring和mybaits整合后，事务是是自动提交的，无需sqlSession.commit()
        System.out.println(nums);
    }

    @Test
    public void testServiceSelect(){
        String config ="applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //获取spring容器中的dao对象
        StudentService ss = (StudentService) ac.getBean("studentService");
        List<Student> students =  ss.queryStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
