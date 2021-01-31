package com.hfq.ba02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



    @Component
public class Student {
   /**
    * @Value 简单类型的属性赋值
    * 属性 ： value 是String类型 表示简单类型的属性值  value可以省略
    * 位置： 1.在属性定义的上面，无需set方法 ，推荐
    *       2.在set方法上面
    */
   @Value("张飞")
    private String name;
   @Value("11")
    private Integer age;

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
                '}';
    }
}
