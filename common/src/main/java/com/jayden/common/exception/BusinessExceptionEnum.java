package com.jayden.common.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName: BusinessExceptionEnum
 * @Author: 梁金德 Jayden
 * @Date: 2024-04-11 10:56
 * @Version: V1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@ToString
public enum BusinessExceptionEnum {
    MEMBER_MOBILE_EXIST("手机号已注册")
    ;
//    private Integer code;
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
