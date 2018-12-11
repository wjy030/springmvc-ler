/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: Role
 * Author:   suneee
 * Date:     2018/12/11 14:23
 * Description: 参数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.model;

/**
 * 〈一句话功能简述〉<br> 
 * 〈角色〉
 *
 * @author suneee
 * @create 2018/12/11
 * @since 1.0.0
 */
public class Role {
    private String id;
    private String name;

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
