package com.hfq.service.impl;

import com.hfq.dao.StudentDao;
import com.hfq.entity.Student;
import com.hfq.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    //引用类型的自动注入@Autowired  @Resouce
    @Resource
    private StudentDao studentDao;

    @Override
    public int addStudent(Student student) {
        int nums =  studentDao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> findStudents() {
        return studentDao.selectStudents();
    }
}
