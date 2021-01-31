package com.hfq;

import com.github.pagehelper.PageHelper;
import com.hfq.dao.StudentDao;
import com.hfq.entity.Student;
import com.hfq.utils.MyBatisUtils;
import com.hfq.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMybatis {
    @Test
    public void testSelectMulitParam(){
        SqlSession s= MyBatisUtils.getSqlSession();
        StudentDao dao = s.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("郭源潮");
        student.setAge(30);
        List<Student> students = dao.selectStudentIf(student);
        for (Student stu : students) {
            System.out.println("///***"+stu);
        }
        s.close();
        }

    @Test
    public void testSelectStudentWhere(){
        SqlSession s= MyBatisUtils.getSqlSession();
        StudentDao dao = s.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("郭源潮");
        student.setAge(30);
        List<Student> students = dao.selectStudentWhere(student);
        for (Student stu : students) {
            System.out.println("///***"+stu);
        }
        s.close();
    }

    @Test
    public void testSelectForeachOne(){
        SqlSession s= MyBatisUtils.getSqlSession();
        StudentDao dao = s.getMapper(StudentDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> students = dao.selectForeachOne(list);
        for (Student stu : students) {
            System.out.println(stu);
        }
        s.close();
    }
    @Test
    public void testSelectForeachTwo(){
        SqlSession s= MyBatisUtils.getSqlSession();
        StudentDao dao = s.getMapper(StudentDao.class);
        List<Student> stulist = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(1001);
        stulist.add(s1);
        Student s2 = new Student();
        s2.setId(1002);
        stulist.add(s2);
        List<Student> students = dao.selectForeachTwo(stulist);
        for (Student stu : students) {
            System.out.println(stu);
        }
        s.close();
    }

    @Test
    public void testSelectAllPageHelper(){
        SqlSession s= MyBatisUtils.getSqlSession();
        StudentDao dao = s.getMapper(StudentDao.class);
        //加入PageHelper的方法，进行分页
        //pageNum 是第几页 从第一页开始
        //pageSize 一页中有多少数据
        PageHelper.startPage(2,3);
        List<Student> students = dao.selectAll();
        for (Student stu : students) {
            System.out.println(stu);
        }
        s.close();
    }
}
