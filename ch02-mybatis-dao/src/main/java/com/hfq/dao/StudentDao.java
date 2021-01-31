package com.hfq.dao;

import com.hfq.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudents();

    int insertStudent(Student student);

}
