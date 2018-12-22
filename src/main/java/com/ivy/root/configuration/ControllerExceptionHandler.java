package com.ivy.root.configuration;

import com.ivy.root.common.response.ResponseVo;
import com.ivy.root.common.rootenum.ResponseCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseVo defaultHandler(HttpServletRequest request, Exception e) {
        return ResponseVo.buildFailInstance(e.getMessage(), ResponseCodeEnum.FAILED_SYSTEM.getCode());
    }
}
