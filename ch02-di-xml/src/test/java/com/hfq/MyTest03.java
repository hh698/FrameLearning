package com.hfq;

import com.hfq.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class MyTest03 {
    @Test
    public void test01(){
        String config = "ba03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获取Student对象
        Student mySudent = (Student) ac.getBean("myStudent3");
        System.out.println(mySudent);

        File file = (File) ac.getBean("myfile");
        System.out.println(file.getName());
    }
}
