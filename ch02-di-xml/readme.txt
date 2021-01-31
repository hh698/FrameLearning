spring的ioc，由spring创建对象
实现步骤：
1.创建maven项目
2.加入maven依赖
    spring依赖，版本5.2.5
    junit依赖
3.创建类（接口和实现类）
    和没有使用框架一样，就是普通类
4.创建spring使用的配置文件
  声明类的信息，这些类由spring创建和管理

  通过spring的语法，完成属性的赋值

5.测试spring创建


ch02-di-xml: 在spring配置文件中给java对象的属性赋值
di: 依赖注入,表示创建对象给属性赋值
di实现的两种语法:
1.在spring的配置文件中，使用标签和属性来完成,叫做基于xml的di实现
2.使用spring 中的注解，完成属性的赋值，叫做基于注解的di实现

di的语法分类:
1.set注入（设置注入）:spring调用类的set方法，set方法可以实现属性的赋值
80%是set注入
2.构造注入，spring调用类的有参构造方法，创建对象，在构造方法中完成赋值