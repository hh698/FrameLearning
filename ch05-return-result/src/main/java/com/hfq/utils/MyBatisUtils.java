package com.hfq.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {

    public static  SqlSessionFactory sf = null;
    //静态块执行一次即可
    static{
        String config = "mybatis.xml";//需要和项目中的文件名一致
        try {
            InputStream in =  Resources.getResourceAsStream(config);
            //使用sqlSessionFactoryBuild创建sqlSessionFactory对象
            sf = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //获取SqlSession方法
    public static SqlSession getSqlSession(){
        SqlSession s = null;
        if (sf != null){
            s = sf.openSession();//非自动提交事务
        }
        return s;
    }
}
