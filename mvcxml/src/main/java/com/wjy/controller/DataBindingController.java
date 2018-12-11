/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: DataBindingController
 * Author:   suneee
 * Date:     2018/12/11 11:10
 * Description: 数据绑定
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.controller;

import com.wjy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈数据绑定〉
 *
 * @author suneee
 * @create 2018/12/11
 * @since 1.0.0
 */
@Controller
@RequestMapping("/db")
public class DataBindingController {

    @RequestMapping("/show")
    public String show() {
       return "show";
    }
    @RequestMapping(value = "/req",method = RequestMethod.POST)
    public String getFromReq(HttpServletRequest request) {
        System.out.println(request.getParameter("userName"));
        System.out.println(request.getParameter("password"));
        return "test";
    }
    @RequestMapping(value = "/path/{mod}/{id}",method = RequestMethod.POST)
    public String getFromPath(@PathVariable("mod") String module,@PathVariable("id") Long id) {
        System.out.println(module);
        System.out.println(id);
        return "test";
    }
    @RequestMapping(value = "/simple",method = RequestMethod.POST)
    public String getSimple(String userName,String password) {
        System.out.println(userName);
        System.out.println(password);
        return "test";
    }

    @RequestMapping(value = "/reqp",method = RequestMethod.POST)
    public String getRep(@RequestParam("userName") String name,@RequestParam("password") String pass) {
        System.out.println(name);
        System.out.println(pass);
        return "test";
    }

    @RequestMapping(value = "/jb",method = RequestMethod.POST)
    public String getRep(User user) {
        System.out.println(user);
        return "test";
    }
    @RequestMapping(value = "/jbjb",method = RequestMethod.POST)
    public String getReRep(User user) {
        System.out.println(user);
        return "test";
    }
    @RequestMapping(value = "/con",method = RequestMethod.POST)
    public String getCon(Date birth) {
        System.out.println(birth);
        return "test";
    }
    @RequestMapping(value = "/arr",method = RequestMethod.POST)
    public String getArr(Integer[] like) {
        for(Integer i: like) {
            System.out.println(i);
        }
        return "test";
    }
}
