package com.hfq.dao.impl;

import com.hfq.dao.StudentDao;
import com.hfq.entity.Student;
import com.hfq.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao{
    @Override
    public List<Student> selectStudents() {
        //获取SqlSession对象
        SqlSession s = MyBatisUtils.getSqlSession();
        String sqlId = "com.hfq.dao.StudentDao.selectStudents";
        //执行sql语句
        List<Student> students = s.selectList(sqlId);
        //关闭session
        s.close();
        return students;
    }

    @Override
    public int insertStudent(Student student) {
        //获取SqlSession对象
        SqlSession s = MyBatisUtils.getSqlSession();
        String sqlId = "com.hfq.dao.StudentDao.insertStudent";
        //执行sql语句
        int nums = s.insert(sqlId,student);
        s.commit();
        //关闭session
        s.close();
        return nums;
    }
}
