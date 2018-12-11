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

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wjy.model.Pet;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试controller〉
 *
 * @author suneee
 * @create 2018/12/5
 * @since 1.0.0
 */
@Controller
@RequestMapping("/dispatch")
public class DispatchController {
    @RequestMapping(value = "/first",method = RequestMethod.GET,params = {"name"}
//            headers = {"sessionId"},
//            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ModelAndView test () {
        System.out.println("***************");
        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.addObject("name","my test");
        return modelAndView;
    }

    @RequestMapping(value="/second",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String second() {
        return "{\"key\":\"value\"}";
    }

    @RequestMapping(value="/third",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String third(@RequestBody String name) {
        System.out.println(name);
        return "redirect:http://www.baidu.com";
    }
    @RequestMapping(value="/forth",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ModelAndView forth(@RequestBody String name) {
        System.out.println(name);
        return new ModelAndView("redirect:http://www.baidu.com");
    }
    @RequestMapping(value="/fifth",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void fifth(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        response.sendRedirect("http://www.baidu.com");
    }


}
