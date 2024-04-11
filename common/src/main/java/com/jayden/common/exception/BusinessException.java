package com.jayden.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName: BusinessException
 * @Author: 梁金德 Jayden
 * @Date: 2024-04-11 10:59
 * @Version: V1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends RuntimeException{

    private BusinessExceptionEnum anEnum;

    /**
     * @return 别递归打印了，就直接打印当前异常信息就行
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
