package com.hfq.ba03;

//目标类
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name,Integer age) {
        //给doSome()增加一个功能，在doSome()执行之前，输出方法的执行时间
        System.out.println("***目标doName()***");
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("目标方法doOther()执行***");
        return "abc";
    }

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println("业务方法doFirst()******");
        return "doFirst";
    }
}
