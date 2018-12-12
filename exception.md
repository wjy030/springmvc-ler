# 错误处理
## @ExceptionHandler注解处理
    @ExceptionHandler(value = ArithmeticException.class)
    public ModelAndView handle(Exception ex) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception",ex);
        return mv;
    }
被ExceptionHandler注解的方法可以用来处理本类中抛出的异常，传入Exception参数。  
如果要使该方法对其他类的也起作用，需要在该方法的类上加上ControllerAdvice注解  


@ControllerAdvice
public class ExceptionController {


## SimpleMappingExceptionResolver配置处理
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties prop = new Properties();
        prop.setProperty("java.lang.StringIndexOutOfBoundsException","error2");
        resolver.setExceptionMappings(prop);
        resolver.setExceptionAttribute("ex");
        return resolver;
    }
配置SimpleMappingExceptionResolver类，setExceptionMappings方法配置Exception和跳转页面的对应，setExceptionAttribute设置在页面中取出exception时
用的属性名
