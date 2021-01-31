package com.hfq.dao;

import com.hfq.entity.Student;
import com.hfq.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    /*
    一个简单类型的参数
    mybatis把Java的基本数据类型和String都叫简单类型

    在mapper文件中获取一个简单参数的值，使用#{任意字符串}
     */
    public Student selectStudentById(Integer id);

    /**
     * 多个参数：命名参数，在形参定义的前面加入@param("自定义参数名称")
     */
    List<Student> selectMulitParam(@Param("myname") String name,
                                   @Param("myage") Integer age);
    /**
     * 多个参数，使用java对象作为接口中方法的参数
     */
    List<Student> selectMulitObject(QueryParam param);

    List<Student> selectMulitStudent(Student student);
}
