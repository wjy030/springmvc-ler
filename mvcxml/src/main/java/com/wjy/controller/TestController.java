/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: TestController
 * Author:   suneee
 * Date:     2018/12/5 12:04
 * Description: 测试controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试controller〉
 *
 * @author suneee
 * @create 2018/12/5
 * @since 1.0.0
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/first")
    public ModelAndView test () {
        System.out.println("***************");
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/jsp/test.jsp");
        modelAndView.addObject("name","my test");
        return modelAndView;
    }
}
