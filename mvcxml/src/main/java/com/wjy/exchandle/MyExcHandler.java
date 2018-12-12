/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: MyExcHandler
 * Author:   suneee
 * Date:     2018/12/12 15:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.exchandle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author suneee
 * @create 2018/12/12
 * @since 1.0.0
 */
@ControllerAdvice
public class MyExcHandler {

    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView exec(Exception ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception",sw.toString());
        return mv;
    }
}
