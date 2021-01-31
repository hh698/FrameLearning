package com.hfq;

import com.hfq.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    //测试方法，测试功能
    @Test
    public void testInsert() throws IOException {
        //访问mybatis读取student数据
        //1.定义mybatis主配值文件的名称，从类路径的根开始（target/classes）
        String config = "mybatis.xml";
        //2.读取config表示的文件
        InputStream is = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory sf = sfb.build(is);
        //5.获取SqlSession对象,从SqlSessionFactory中获取SqlSession  !!!!!!!!!
        SqlSession s = sf.openSession();
        //6.指定要执行的sql语句的标识  sql映射文件中的namespace+"."+标签的id值  !!!!!!!!!!!
        String sqlId = "com.hfq.dao.StudentDao"+"."+"insertStudent";
        //String sqlId = "com.hfq.dao.StudentDao.selectStudents";
        //7.执行sql语句，通过sqlId来找到语句执行
        Student student = new Student();
        student.setId(1004);
        student.setName("郭源潮");
        student.setEmail("pangzi@163.com");
        student.setAge(30);
        int num = s.insert(sqlId,student);
        s.commit();
        //8.输出结果
        System.out.println(num);
        //9.关闭sqlSession对象
        s.close();
    }
}
