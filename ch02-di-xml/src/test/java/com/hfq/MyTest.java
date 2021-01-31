package com.hfq;

import com.hfq.ba01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;
import java.util.Date;

public class MyTest {
    @Test
    public void test01(){
        String config = "ba01/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获取Student对象
        Student mySudent = (Student) ac.getBean("myStudent");
        System.out.println(mySudent);
    }


}
