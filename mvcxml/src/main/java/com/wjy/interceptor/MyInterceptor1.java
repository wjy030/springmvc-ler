/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: MyInterceptor1
 * Author:   suneee
 * Date:     2018/12/13 11:11
 * Description: 拦截
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈拦截〉
 *
 * @author suneee
 * @create 2018/12/13
 * @since 1.0.0
 */
public class MyInterceptor1 implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o
    ) throws Exception {
        System.out.println("执行preHandle1");
        return true;
    }
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("执行postHandle1");
    }
        public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
        System.out.println("执行afterCompletion1");
    }
}
