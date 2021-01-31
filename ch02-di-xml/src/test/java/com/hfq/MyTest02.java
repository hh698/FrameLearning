package com.hfq;

import com.hfq.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {
    @Test
    public void test01(){
        String config = "ba02/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获取Student对象
        Student mySudent = (Student) ac.getBean("myStudent");
        System.out.println(mySudent);
    }

    //引用类型的set注入
    @Test
    public void test02(){
        String config = "ba02/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获取Student对象
        Student mySudent = (Student) ac.getBean("myStudent");
        System.out.println(mySudent);
    }
}
