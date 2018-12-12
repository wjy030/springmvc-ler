/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: TestInitializer
 * Author:   suneee
 * Date:     2018/12/12 10:20
 * Description: 启动
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 〈一句话功能简述〉<br> 
 * 〈启动〉
 *
 * @author suneee
 * @create 2018/12/12
 * @since 1.0.0
 */

public class TestInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{JavaConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"*.action"};
    }
}
