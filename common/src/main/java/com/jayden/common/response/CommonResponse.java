package com.jayden.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName: CommonResponse
 * @Author: 梁金德 Jayden
 * @Date: 2024-04-11 10:28
 * @Version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommonResponse<T> {
    /**
     * 业务上的成功或失败
     */
    private boolean success = true;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回泛型数据，自定义类型
     */
    private T content;
}
