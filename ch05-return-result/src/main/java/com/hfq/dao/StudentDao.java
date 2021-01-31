package com.hfq.dao;

import com.hfq.entity.Student;
import com.hfq.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    public Student selectStudentById(Integer id);


    List<Student> selectMulitParam(@Param("myname") String name,
                                   @Param("myage") Integer age);

    int countStudent();

    List<Student> selectLikeOne(String name);
    List<Student> selectLikeTwo(String name);
}
