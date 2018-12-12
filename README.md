
# springmvc学习
## 配置文件
配置文件可以配在servlet中，也可以通过listener配置
### servlet配置
    <servlet>
      <servlet-name>DispatcherServlet</servlet-name>
      <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
      <load-on-startup>1</load-on-startup>
    </servlet>
### listener配置
    <listener>
      <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
      <context-param>
          <param-name>contextConfigLocation</param-name>
          <param-value>classpath:springmvc.xml</param-value>
      </context-param>
## springmvc流程
![springmvc流程](flow.png)
## 配置驱动的处理器(HandlerMapping)和适配器(HandlerAdapter)
启用新的处理器和适配器
### 启用方式一
    <mvc:annotation-driven></mvc:annotation-driven>
### 启用方式二
     <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping"/>
     <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter"/>
## 配置视图解析器
     <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
         <property name="suffix" value=".jsp"/>
         <property name="prefix" value="/WEB-INF/jsp/"/>
     </bean>
 配置后  
 ``ModelAndView modelAndView = new ModelAndView("/WEB-INF/jsp/test.jsp");``
 可以改成  
  ``ModelAndView modelAndView = new ModelAndView("test");``
## [RequestMapping,RequestBody,ResponseBody注解](RequestMapping.md)
## [springmvc中跳转](redirect.md)
## [请求参数接收](databinding.md)
## [错误处理](exception.md)
## 文件上传
### 表单中的配置
     <form action="/upload/test.action" enctype="multipart/form-data" method="post">
必须配置enctype="multipart/form-data"和method="post"
### bean配置
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        return resolver;
    }
配置CommonsMultipartResolver，它的name或id必须是**multipartResolver**，该类中还可以配置文件最允许大小等参数
### pom.xml配置
        <dependency>
          <groupId>commons-fileupload</groupId>
          <artifactId>commons-fileupload</artifactId>
          <version>LATEST</version>
      </dependency>
### 方法中
#### 参数
     public String upload(HttpServletRequest request, String userName, MultipartFile file) {
使用MultipartFile类型定义文件参数
#### 执行
    file.transferTo(new File(request.getSession().getServletContext().getRealPath("/upload")+"/"+file.getOriginalFilename()));
使用transferTo执行上传
