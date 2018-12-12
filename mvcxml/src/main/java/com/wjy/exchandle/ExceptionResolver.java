/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: ExceptionResolver
 * Author:   suneee
 * Date:     2018/12/12 16:46
 * Description: 错误处理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.exchandle;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈错误处理〉
 *
 * @author suneee
 * @create 2018/12/12
 * @since 1.0.0
 */
@Component
public class ExceptionResolver implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse, Object o, Exception e) {
        System.out.println("*******");
        ModelAndView mv = new ModelAndView("error2");
        mv.addObject("ex",e);
        return mv;
    }
}
