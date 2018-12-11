/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: DateConvertor
 * Author:   suneee
 * Date:     2018/12/11 14:55
 * Description: 转换
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.convertor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈转换〉
 *
 * @author suneee
 * @create 2018/12/11
 * @since 1.0.0
 */
@Component("dateConverter")
public class DateConvertor implements Converter<String,Date> {
    public Date convert(String birth) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
