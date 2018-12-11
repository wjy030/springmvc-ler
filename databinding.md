# 接收前台请求数据
## 使用request接收请求数据
     @RequestMapping(value = "/req",method = RequestMethod.POST)
     public String getFromReq(HttpServletRequest request) {
方法中定义HttpServletRequest参数，框架会往里注入当前request，可从中获取前台参数
## @PathVariable接收请求参数
     @RequestMapping(value = "/path/{mod}/{id}",method = RequestMethod.POST)
     public String getFromPath(@PathVariable("mod") String module,@PathVariable("id") Long id) {
请求路径中通过{}定义参数名，方法参数中用@PathVariable指定接收请求的参数
## @RequestParam接收请求参数
### 默认接收请求参数
     @RequestMapping(value = "/simple",method = RequestMethod.POST)
     public String getSimple(String userName,String password) {
方法参数名和请求参数名一致，则框架会自动将请求参数传入方法参数中
### 使用@RequestParam
     @RequestMapping(value = "/reqp",method = RequestMethod.POST)
     public String getRep(@RequestParam("userName") String name,@RequestParam("password") String pass) {
方法参数名和请求参数名不一致，则框架会将请求参数传入RequestParam指定的方法参数中
### javabean封装参数
      public class User {
          private String userName;
          private String password;
          
      @RequestMapping(value = "/jb",method = RequestMethod.POST)
      public String getRep(User user) {
创建javabean，bean中属性名与请求参数名一致（主要是符合set，get方法），用该javabean做参数时，框架会将请求参数注入其属性中
### 包装javabean类型接收参数
    public class User {
    private String userName;
    private String password;
    private Role role;
    
    public class Role {
    private String id;
    private String name;
javabean中有Object类型属性时，要往其中属性传入请求参数时表单name写法：  
    ``<input type="text" name="role.id">``  
    ``<input type="text" name="role.name">``
### 自定义类型转换
      @Component("dateConverter")
      public class DateConvertor implements Converter<String,Date> {
          public Date convert(String birth) {
              SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
              try {
                  return simpleDateFormat.parse(birth);
              } catch (ParseException e) {
                  e.printStackTrace();
              }
              return null;
          }
      }
定义转换器，实现Converter接口  


``<bean id="converterCol" class="org.springframework.context.support.ConversionServiceFactoryBean">``  
    ``<property name="converters">``  
        ``<set>``  
            ``<ref bean="dateConverter"/>``  
        ``</set>``  
    ``</property>``  
``</bean>``  
定义ConversionServiceFactoryBean  


``<mvc:annotation-driven conversion-service="converterCol"></mvc:annotation-driven>``  
配置ConversionServiceFactoryBean  
### 用数组接收多个同名参数
      @RequestMapping(value = "/arr",method = RequestMethod.POST)
       public String getArr(Integer[] like) {
表单中  
``<form action="/db/arr.action" method="post">``  
``    <input type="checkbox" name="like" value="1">学习<br>``  
``    <input type="checkbox" name="like" value="2">锻炼<br>``  
``    <input type="checkbox" name="like" value="3">看书<br>``  
``    <input type="submit" value="提交">``  
``  </form>``  
