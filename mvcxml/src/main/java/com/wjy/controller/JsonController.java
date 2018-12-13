/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: JsonController
 * Author:   suneee
 * Date:     2018/12/13 10:37
 * Description: json
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.controller;

import com.wjy.model.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈json〉
 *
 * @author suneee
 * @create 2018/12/13
 * @since 1.0.0
 */
@Controller
@RequestMapping("/json")
public class JsonController {

    @RequestMapping(value = "/test",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String getJson(@RequestBody User user) {
        System.out.println(user);
        return "test";
    }
}
