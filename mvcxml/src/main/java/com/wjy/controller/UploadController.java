/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: UploadController
 * Author:   wjy
 * Date:     2018/12/12 22:26
 * Description: 上传
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈上传〉
 *
 * @author wjy
 * @create 2018/12/12
 * @since 1.0.0
 */
@RequestMapping("/upload")
@Controller
public class UploadController {

    @RequestMapping("/test")
    public String upload(HttpServletRequest request, String userName, MultipartFile file) {
        try {
            System.out.println(userName);
            File upload = new File(request.getSession().getServletContext().getRealPath("/upload"));
            if(!upload.exists())
                upload.mkdir();
            file.transferTo(new File(request.getSession().getServletContext().getRealPath("/upload")+"/"+file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "test";
    }
}
