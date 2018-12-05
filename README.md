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
