package com.hfq;

import com.hfq.dao.StudentDao;
import com.hfq.dao.impl.StudentDaoImpl;
import com.hfq.entity.Student;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
    @Test
    public void testSelectStudents(){
        StudentDao dao = new StudentDaoImpl();
        List<Student> studentList = dao.selectStudents();
        for (Student stu : studentList) {
            System.out.println(stu);
        }
    }

    @Test
    public void testInsertStudent(){
        StudentDao dao = new StudentDaoImpl();
        Student student = new Student();
        student.setId(1005);
        student.setName("梵高");
        student.setEmail("bige@163.com");
        student.setAge(35);
        int nums = dao.insertStudent(student);
        System.out.println(nums);
    }
}
