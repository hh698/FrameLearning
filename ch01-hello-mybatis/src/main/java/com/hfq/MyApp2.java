package com.hfq;

import com.hfq.entity.Student;
import com.hfq.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp2 {
    public static void main(String[] args) throws IOException {
//        //访问mybatis读取student数据
//        //1.定义mybatis主配值文件的名称，从类路径的根开始（target/classes）
//        String config = "mybatis.xml";
//        //2.读取config表示的文件
//        InputStream is = Resources.getResourceAsStream(config);
//        //3.创建SqlSessionFactoryBuilder对象
//        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
//        //4.创建SqlSessionFactory对象
//        SqlSessionFactory sf = sfb.build(is);
        //5.获取SqlSession对象,从SqlSessionFactory中获取SqlSession  !!!!!!!!!
        SqlSession s = MyBatisUtils.getSqlSession();
        //6.指定要执行的sql语句的标识  sql映射文件中的namespace+"."+标签的id值  !!!!!!!!!!!
        String sqlId = "com.hfq.dao.StudentDao.selectStudents";
        //String sqlId = "com.hfq.dao.StudentDao.selectStudents";
        //7.执行sql语句，通过sqlId来找到语句执行
        List<Student> studentList = s.selectList(sqlId);
        //8.输出结果
        for (Student stu : studentList) {
            System.out.println(stu);
        }
        //9.关闭sqlSession对象
        s.close();
    }
}
