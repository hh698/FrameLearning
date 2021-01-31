package com.hfq.dao;

import com.hfq.entity.Student;
import com.hfq.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    //动态sql 使用java对象作为参数\
    //if
    List<Student> selectStudentIf(Student student);
    //where
    List<Student> selectStudentWhere(Student student);
    //foreach用法1
    List<Student> selectForeachOne(List<Integer> idlist);
    //foreach用法2
    List<Student> selectForeachTwo(List<Student> stulist);
    //使用PageHelper分页数据
    List<Student> selectAll();
}
