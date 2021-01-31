package com.hfq.ba06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component("myStudent")
public class Student {

@Value("张飞")
private String name;
@Value("11")
private Integer age;

/**
 * 引用类型
 * @Resource 来自JDK中的注解，spring框架提供了对这个注解的功能支持，可以使用它给引用类型赋值
 *           使用的也是自动注入的原理，支持byName，byType   默认使用byName
 * 使用位置： 1.在属性定义的上面，无需set方法，推荐使用
 *          2.在set方法的上面
 */

//默认赋值方式是byName   原则：先使用byName自动注入，如果复制失败，在使用byTypeSchool
//Student
@Resource
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
