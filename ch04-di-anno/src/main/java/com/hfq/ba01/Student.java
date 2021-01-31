package com.hfq.ba01;

import org.springframework.stereotype.Component;

/**
 * @Conponent创建对象，等同于<bean>的功能
 * 属性：value 就是对象的名称，也就是bean的id值 value是唯一的 创建的对象在spring中只有一个
 * 位置： 在类的上面
 * @Component(value = "myStudent")等同于
 * <bean id="myStudent" calss="com.hfq.ba01.Student"/>
 *
 * spring中和@Conponent功能一致，创建对象的注解还有
 * 1.@Repository（用在持久层类的）  放在dao的实现类上，表示创建dao对象，dao对象是访问数据库的
 * 2.@Service(用在业务层的)   放在service实现类上，表示创建service对象，service对象是做业务处理的
 *  可以有事务等功能的
 * 3.@Controller(用在控制层上)   放在控制器（处理器）类上 ，创建控制器对象
 *                            控制器对象能够接收用户的参数和显示处理的结果
 *  以上三个注解的使用语法和@Conponent一样，都能创建对象，但是还有自己的功能
 *  @Repository，@Service，@Controller是给项目的对象分层的
 */

//使用value属性，指定对象
// @Component(value = "myStudent")
//省略value
//@Component("myStudent")

//不指定对象名称，由spring提供默认名称（类的首字母小写）
    @Component
public class Student {
    private String name;
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
