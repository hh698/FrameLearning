package com.hfq;

import com.hfq.dao.StudentDao;
import com.hfq.entity.Student;
import com.hfq.utils.MyBatisUtils;
import com.hfq.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
    @Test
    public void testSelectStudentById(){
        /**
         * 使用mybatis的动态代理，使用sqlSession.getMapper(dao接口)
         * getMapper能获取dao接口对应的实现类对象
         */
        SqlSession s = MyBatisUtils.getSqlSession();
        StudentDao dao = s.getMapper(StudentDao.class);

        Student student = dao.selectStudentById(1003);
        System.out.println(student);
//        //com.sun.proxy.$Proxy4   jdk的动态代理
//        System.out.println("dao="+dao.getClass().getName());
//        //调用dao的方法执行数据库的操作
//        List<Student> students = dao.selectStudents();
//        for (Student stu : students) {
//            System.out.println(stu);
//        }
    }

    @Test
    public void testSelectMulitParam(){
        SqlSession s= MyBatisUtils.getSqlSession();
        StudentDao dao = s.getMapper(StudentDao.class);
        List<Student> students = dao.selectMulitParam("李四",20);
        for (Student stu : students) {
            System.out.println(stu);
        }
        s.close();
        }

    @Test
    public void testSelectMulitObject(){
        SqlSession s= MyBatisUtils.getSqlSession();
        StudentDao dao = s.getMapper(StudentDao.class);
        QueryParam qp = new QueryParam();
        qp.setParamName("郭源潮");
        qp.setParamAge(30);
        List<Student> students = dao.selectMulitObject(qp);
        for (Student stu : students) {
            System.out.println(stu);
        }
        s.close();
    }

    @Test
    public void testSelectMulitStudent(){
        SqlSession s= MyBatisUtils.getSqlSession();
        StudentDao dao = s.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("郭源潮");
        student.setAge(30);
            List<Student> students = dao.selectMulitStudent(student);
        for (Student stu : students) {
            System.out.println(stu);
        }
        s.close();
    }

//    @Test
//    public void testInsertStudent(){
//        SqlSession s = MyBatisUtils.getSqlSession();
//        StudentDao dao = s.getMapper(StudentDao.class);
//        Student student = new Student();
//        student.setId(1007);
//        student.setName("雁巡");
//        student.setEmail("yanxun@163.com");
//        student.setAge(30);
//        int nums = dao.insertStudent(student);
//        s.commit();
//        System.out.println(nums);
//    }
}
