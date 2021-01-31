package com.hfq;

import com.hfq.dao.StudentDao;
import com.hfq.entity.Student;
import com.hfq.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
    @Test
    public void testSelectStudents(){
        /**
         * 使用mybatis的动态代理，使用sqlSession.getMapper(dao接口)
         * getMapper能获取dao接口对应的实现类对象
         */
        SqlSession s = MyBatisUtils.getSqlSession();
        StudentDao dao = s.getMapper(StudentDao.class);
        //com.sun.proxy.$Proxy4   jdk的动态代理
        System.out.println("dao="+dao.getClass().getName());
        //调用dao的方法执行数据库的操作
        List<Student> students = dao.selectStudents();
        for (Student stu : students) {
            System.out.println(stu);
        }
    }

    @Test
    public void testInsertStudent(){
        SqlSession s = MyBatisUtils.getSqlSession();
        StudentDao dao = s.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1008);
        student.setName("莉莉安");
        student.setEmail("lilian@163.com");
        student.setAge(18);
        int nums = dao.insertStudent(student);
        s.commit();
        System.out.println(nums);
    }
}
