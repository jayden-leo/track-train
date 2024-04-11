package com.jayden.common.controller;

import com.jayden.common.exception.BusinessException;
import com.jayden.common.response.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: ControllerExceptionHandler
 * @Author: 梁金德 Jayden
 * @Date: 2024-04-11 10:46
 * @Version: V1.0
 */

@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * 统一异常处理
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public CommonResponse exceptionHandler(Exception e){
        CommonResponse<Object> commonResponse = new CommonResponse<>();
        LOG.error("系统异常: ",e);
        commonResponse.setSuccess(false);
        commonResponse.setMessage("系统出现异常，请联系管理员");
        return commonResponse;
    }

    /**
     * 业务异常处理
     * @param e 业务异常
     * @return 异常报告
     */
    @ExceptionHandler(value=BusinessException.class)
    @ResponseBody
    public CommonResponse exceptionHandler(BusinessException e){
        CommonResponse<Object> commonResponse = new CommonResponse<>();
        LOG.error("业务异常: {}",e.getAnEnum().getDesc());
        commonResponse.setSuccess(false);
        commonResponse.setMessage(e.getAnEnum().getDesc());
        return commonResponse;
    }

    /**
     * 业务异常处理
     * @param e 业务异常
     * @return 异常报告
     */
    @ExceptionHandler(value=MethodArgumentNotValidException.class)
    @ResponseBody
    public CommonResponse exceptionHandler(MethodArgumentNotValidException e){
        CommonResponse<Object> commonResponse = new CommonResponse<>();
        LOG.error("校验异常: {}",e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        commonResponse.setSuccess(false);
        commonResponse.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return commonResponse;
    }
}
