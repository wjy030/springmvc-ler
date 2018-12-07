# 请求转发和重定向
## 请求转发关键字forward,重定向关键字redirect
## 几种转发和重定向方式
### 返回字符串
     return "forward:/test/second.action";
     return "redirect:third.action";
     return "redirect:third.action";
     return "redirect:http://www.baidu.com";
### 返回ModelAndView
     return new ModelAndView("redirect:http://www.baidu.com");
### 通过HttpServletRequest,HttpServletResponse
     @RequestMapping(value="/fifth",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
     public void fifth(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
         response.sendRedirect("http://www.baidu.com");
     }
方法中定义HttpServletRequest   HttpServletResponse  HttpSession 参数，框架会自动注入然后能在方法体中使用
