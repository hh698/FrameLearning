ch03-receiveparam:接收请求的参数
接收请求的参数，使用的是处理器方法的形参
1）HttpServletRequest
2）HttpServletResponse
3）HttpSession
4)用户提交的数据

接收用户的提交的参数：
1.逐个接收
2.对象接收

注意：在提交请求参数的时候，使用post方式提交请求，中文有乱码，需要使用过滤器处理乱码问题
过滤器可以自定义，也可以使用框架中的过滤器CharacterEncodingFilter

实现步骤：
1.新建maven项目  web
2.加入依赖
    spring-webmvc 依赖，间接把spring的依赖加入到项目中
    jsp，servlet依赖
3.重点：在web.xml中注册springmvc框架的核心对象DispatcherServlet
    1)DispatcherServlet是中央调度器，是一个servlet,他的父类继承HttpServlet
    2)DispatcherServlet也叫做前端控制器（front controller）
    3)DispatcherServlet负责接收用户提交的请求，调用其他的控制对象，并把请求的处理结果显示给用户
4.创建一个发起请求的jsp   index.jsp
5.创建控制器类
    1)在类的上面加入@Controller注解，创建对象，并放入到springmvc容器中
    2)在类中的方法上面加入@RequestMapping注解
6.创建一个作为结果的jsp，显示请求处理的结果
7.创建一个springmvc的配置文件（和spring的配置文件一样）
    1)声明组件扫描器，指定@Controller注解所在的包
    2)声明视图解析器，帮助处理视图