package com.hfq.ba05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("myStudent")
public class Student {

@Value("张飞")
private String name;
@Value("11")
private Integer age;

/**
 * 引用类型
 * @Autowired spring框架提供的注解实现引用类型的赋值，使用的是自动注入原理,byName,byType
 * @Autowried 默认使用byType
 *
 * 属性 require ,是一个boolean类型，默认为true
 * require = true 表示引用类型赋值失败，程序报错，并终止执行
 * require = false 表示应用类型赋值失败，程序正常运行，引用类型为null
 *
 * 位置
 * 1.在属性定义的上面，无需set方法 推荐使用
 * 2.在set方法的上面
 *
 * 使用byName
 * 1.在属性上面加@Autowired
 * 2.在属性上面加@Qualifier(value="bean的id") 表示使用指定名称的bean完成赋值
 */

//使用byName自动注入
@Autowired
@Qualifier(value = "mySchool")
private School school;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public Integer getAge() {
    return age;
}

public void setAge(Integer age) {
    this.age = age;
}

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
