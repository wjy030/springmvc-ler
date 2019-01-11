
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
## 零配置使用
### AbstractAnnotationConfigDispatcherServletInitializer
```
public class TestInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{JavaConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"*.action"};
    }
}
```
实现了servlet3.0的容器启动时会通过该类加载spring容器和web的相关配置,web的filter和listener都可以通过覆写onStartup方法添加
### WebMvcConfigurerAdapter
```
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.wjy.controller")
public class WebConfig extends WebMvcConfigurerAdapter {
```
web配置类继承WebMvcConfigurerAdapter 可以实现一些xml配置的功能
比如添加拦截器,配置静态资源等
## 实现拦截器
### 实现拦截器接口
```
public class MyInterceptor1 implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o
    ) throws Exception {
        return true; //返回false则不会执行后续
    }
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
    }
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}
```        
实现HandlerInterceptor接口，实现preHandle，postHandle，afterCompletion方法  
### 配置拦截器接口
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/inter/handle.action");
    }
添加拦截器并指定拦截的path为 **/inter/handle.action**  
添加拦截器的顺序即拦截器执行的顺序
### 多个拦截器时的整个执行顺序
假设有两个拦截器interceptor1和interceptor2，先加入的是interceptor1
* 执行interceptor1的preHandle方法
* 执行interceptor2的preHandle方法
* 执行controller的方法
* 执行interceptor2的postHandle方法
* 执行interceptor1的postHandle方法
* 执行interceptor2的afterCompletion方法
* 执行interceptor1的afterCompletion方法
## 配置静态资源映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");
    }
    http访问/static/前缀时会去/WEB-INF/static/找对应静态资源
## springmvc对restful支持
* restful风格中http方法的意义
* get 查询
* post 新增
* put 更新
* delete 删除
### form表单中增加参数_method
      <input type="hidden" name="_method" value="put" />
### 加入HiddenHttpMethodFilter
public class TestInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        FilterRegistration.Dynamic hiddenMethod = servletContext.addFilter("hiddenMethod", HiddenHttpMethodFilter.class);
        hiddenMethod.addMappingForServletNames(null,true,getServletName());
    }
### controller中指定对应的requestmethod
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public String doPut() {
