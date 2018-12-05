/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: JavaConfig
 * Author:   suneee
 * Date:     2018/12/5 12:23
 * Description: spring配置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

/**
 * 〈一句话功能简述〉<br> 
 * 〈spring配置〉
 *
 * @author suneee
 * @create 2018/12/5
 * @since 1.0.0
 */
@Configurable
@ComponentScan(basePackages = "com.wjy")
public class JavaConfig {

}
