/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: InterceptorController
 * Author:   suneee
 * Date:     2018/12/13 11:07
 * Description: 拦截器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 〈一句话功能简述〉<br> 
 * 〈拦截器〉
 *
 * @author suneee
 * @create 2018/12/13
 * @since 1.0.0
 */
@Controller
@RequestMapping("/inter")
public class InterceptorController {

    @RequestMapping("/handle")
    @ResponseBody
    public String handle() {
        System.out.println("执行handle方法");
        return "success";
    }
}
