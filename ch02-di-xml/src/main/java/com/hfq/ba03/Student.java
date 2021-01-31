package com.hfq.ba03;

public class Student {
    //简单类型
    private String name;
    private int age;
    //引用类型
    private School school;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    //创建有参构造方法
    public Student(String name, int age, School school) {
        System.out.println("有参1");
        this.name = name;
        this.age = age;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school='" + school + '\'' +
                '}';
    }
}
