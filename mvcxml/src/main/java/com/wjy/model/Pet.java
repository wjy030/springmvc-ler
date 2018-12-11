/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: Pet
 * Author:   suneee
 * Date:     2018/12/7 15:56
 * Description: 宠物
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.model;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈宠物〉
 *
 * @author suneee
 * @create 2018/12/7
 * @since 1.0.0
 */
public class Pet {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }
}
