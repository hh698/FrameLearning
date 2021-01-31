ch04-return:处理器方法的返回值表示请求的处理结果
1.ModelAndView:有数据和视图，对视图执行forward
2.String:表示视图，可以是逻辑名称，也可以是完整视图路径
如果有@ResponseBody注解，返回就是数据，没有就是视图
3.void:不能表示数据，也不能表示视图
 在处理ajax的时候，可以使用void。通过HttpServletResponse输出数据，相应ajax请求
 ajax请求服务器端返回的就是数据，和视图无关
4.Object:例如String,Integer,Map,List,Student等等都是对象
对象有属性，属性就是数据，所以返回Object表示数据，和视图无关
可以使用对象表示的数据，响应ajax的请求

现阶段的ajax，主要使用json的格式，实现步骤：
 1.加入处理json工具库的依赖，springmvc默认使用的是jackson
 2.在springmvc的配置文件中加入<mvc:annotation-driven>注解驱动
 把java对象转成驱动
 3.在处理器方法的上面加@ResponseBody注解
 @ResponseBody：
        作用：把处理器方法返回对象转为json后，通过HttpServletResponse输出给浏览器
        位置：方法的定义上面，和其他注解没关系


原理：springmvc处理器方法返回Object，可以转为json输出到浏览器，响应ajax的内部原理
1.<mvc:annotation-driven>注解驱动
实现的功能是，完成java对象到json,xmlt,text,二进制等数据的格式的转换
需要HttpMessageConverter接口：消息转换器
这个接口的功能定义了java转为json，xml等数据格式的方法，这个接口有很多实现类
        这些实现类完成java对象到json ，java对象到xml，java对象到二进制数据的转换

