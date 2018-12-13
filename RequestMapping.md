# RequestMapping及相关注解介绍
可以放在类上或方法上
## RequestMapping中的属性
### value和path
意义相同，指定路径
### name
映射名
### method
限制能进入类或方法的http方法，不设置则不限制
### param
指定进入类或方法**必须**的参数
### headers
指定进入类或方法**必须**的http header 属性
### consumes
指定进入类或方法允许的参数类型，如 application/json
### produces
指定该类或方法返回的参数类型，如 application/json
## RequestBody注解
放在方法参数前，springmvc会根据参数类型解析http请求的body中数据并注入参数中
### 要解析json类型数据需要引入jackson，否则报415
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>2.8.1</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.8.1</version>
    </dependency>
## ResponseBody注解
放在方法上，方法返回的数据会放到http响应的body中
## 例
    @RequestMapping(value = "/test",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String getJson(@RequestBody User user) {
        System.out.println(user);
        return "test";
    }
