/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: ExceptionController
 * Author:   suneee
 * Date:     2018/12/12 15:06
 * Description: 异常
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 〈一句话功能简述〉<br> 
 * 〈异常〉
 *
 * @author suneee
 * @create 2018/12/12
 * @since 1.0.0
 */
@Controller
@RequestMapping("/exc")
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = ArithmeticException.class)
    public ModelAndView handle(Exception ex) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception",ex);
        return mv;
    }

    @RequestMapping("/ari")
    public String ari() {
        int i = 100/0;
        return "test";
    }
    @RequestMapping("/nul")
    public String nullp() {
        String a = null;
        System.out.println(a.toString());
        return "test";
    }
    @RequestMapping("/arr")
    public String arr() {
        String arr = "";
        arr.substring(0,3);
        return arr;
    }

    @RequestMapping("/her")
    public String her() {
        String arr = "aaa";
        Long.parseLong(arr);
        return arr;
    }
}
