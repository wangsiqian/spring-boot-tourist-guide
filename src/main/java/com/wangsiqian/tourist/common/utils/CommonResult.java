package com.wangsiqian.tourist.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.wangsiqian.tourist.common.exception.ApiException;
import lombok.Getter;
import lombok.ToString;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用返回结果
 *
 * @date 2020/1/27
 * @author wangsiqian
 */
@Getter
@ToString
public class CommonResult<T> {
    private final boolean ok;
    private final String message;
    private final T result;

    private CommonResult(boolean ok, String message, T result) {
        this.ok = ok;
        this.message = message;
        this.result = result;
    }

    public static CommonResult<String> okResponse() {
        return new CommonResult<>(
                ResultEnum.SUCCESS.isOk(),
                ResultEnum.SUCCESS.getMessage(),
                ResultEnum.SUCCESS.getResult());
    }

    public static <T> CommonResult<T> okResponse(T data) {
        return new CommonResult<>(ResultEnum.SUCCESS.isOk(), ResultEnum.SUCCESS.getMessage(), data);
    }

    public static CommonResult<String> falseResponse() {
        return new CommonResult<>(
                ResultEnum.FAILED.isOk(),
                ResultEnum.FAILED.getMessage(),
                ResultEnum.FAILED.getResult());
    }

    public static CommonResult<String> falseResponse(ApiException exception) {
        return new CommonResult<>(
                ResultEnum.FAILED.isOk(), exception.getMessage(), exception.getErrorType());
    }

    public static CommonResult<List<JSONObject>> validationErrorResponse(
            BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        List<JSONObject> errors = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            JSONObject filedErrorMap = new JSONObject(5, true);
            filedErrorMap.put("error_type", "validation_error");
            filedErrorMap.put("filed", fieldError.getField());
            filedErrorMap.put("message", fieldError.getDefaultMessage());

            errors.add(filedErrorMap);
        }

        return new CommonResult<>(
                ResultEnum.VALIDATE_FAILED.isOk(), ResultEnum.VALIDATE_FAILED.getMessage(), errors);
    }
}
