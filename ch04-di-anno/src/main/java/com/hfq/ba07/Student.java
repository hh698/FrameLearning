package com.hfq.ba07;

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
 *
 * 如果@Resource只是用byName方式，需要添加属性name
 * name的值是bean的id(名称)
 */

//只使用byName方式
//Student
@Resource(name = "mySchool")
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
