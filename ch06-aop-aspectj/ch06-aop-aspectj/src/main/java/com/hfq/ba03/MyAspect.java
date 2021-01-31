package com.hfq.ba03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.rmi.server.ObjID;
import java.util.Date;

/**
 * @Aspect 是aspectj框架中的注解
 * 作用 表示当前类是切面类
 * 切面类 是用来给业务方法增加功能的类，在这个类中有切面的功能代码
 * 位置 在类定义的上面
 */
@Aspect
public class MyAspect {
    /**
     * 环绕通知方法的定义格式
     * 1。public
     * 2.必须有一个返回值，推荐Object
     * 3.方法名称自定义
     * 4.固定参数 ProceedingJoinPoint
     */

    /**
     * @Around 环绕通知
     * 属性 value 切入点表达式
     * 位置 在方法的定义上面
     * 特点：
     *      1.功能最强的通知
     *      2.在目标方法的前后都能增加功能
     *      3.控制目标方法是否被调用执行
     *      4.修改原来的目标方法的执行结果，影响最后的调用结果
     *
     * 环绕通知等同于jdk的动态代理  InvocationHandler接口x
     *
     * 参数ProceedingJoinPoint  等同于jdk代理中的Method  执行目标方法
     * 返回值 就是目标方法的返回结果，可以被修改
     *
     * 环绕通知经常来做事务，在目标方法之前开启事务，然后执行目标方法，最后提交事务   !!!
     */
    @Around(value = "execution(* *..SomeServiceImpl.doFirst(..))")
    public Object   myAround(ProceedingJoinPoint pjp) throws Throwable {

        String name = "";
        //获取第一个参数
        Object args[] = pjp.getArgs();
        if(args != null && args.length>1){
            Object arg = args[0];
             name = (String) arg;
        }

        //实现环绕通知
        Object result =null;
        System.out.println("环绕通知，在目标方法之前输出时间："+new Date());
        //1.目标方法的调用
        if("xxx".equals(name) ){
            result = pjp.proceed(); //相当于method.invoke();    就是Object result = doFirst();
        }


        System.out.println("环绕通知，在目标方法之后输出时间："+new Date());
        //2.在目标方法的前或者后增加功能(45,48行)

        //返回目标方法的执行结果
        return result;
    }
}
