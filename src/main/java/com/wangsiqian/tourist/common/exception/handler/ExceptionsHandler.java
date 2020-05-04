package com.wangsiqian.tourist.common.exception.handler;

import com.alibaba.fastjson.JSONObject;
import com.wangsiqian.tourist.common.exception.ApiException;
import com.wangsiqian.tourist.common.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/** @author wangsiqian */
@Slf4j
@ControllerAdvice
@ResponseBody
public class ExceptionsHandler {
    @ExceptionHandler
    public CommonResult<String> handleApiException(ApiException exception) {
        log.error(exception.toString());
        return CommonResult.falseResponse(exception);
    }

    @ExceptionHandler
    public CommonResult<List<JSONObject>> handleValidationErrorException(
            MethodArgumentNotValidException exception) {
        log.error(exception.toString());
        return CommonResult.validationErrorResponse(exception.getBindingResult());
    }

    @ExceptionHandler
    public CommonResult<String> handleException(Exception exception) {
        log.error(exception.getClass().getName());
        return CommonResult.falseResponse();
    }

    @ExceptionHandler
    public CommonResult<List<JSONObject>> handleBindException(BindException exception) {
        return CommonResult.validationErrorResponse(exception.getBindingResult());
    }
}
